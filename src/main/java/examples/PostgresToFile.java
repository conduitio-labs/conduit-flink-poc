package examples;

import java.time.Duration;
import java.util.Map;

import io.conduit.flink.ConduitSink;
import io.conduit.flink.ConduitSource;
import io.conduit.opencdc.Record;
import io.conduit.opencdc.StructuredData;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.connector.kafka.source.KafkaSource;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class PostgresToFile {
    public static void main(String[] args) throws Exception {
        // Create the execution environment, configure checkpointing
        var env = StreamExecutionEnvironment.getExecutionEnvironment().enableCheckpointing(200);
        env.getCheckpointConfig().setCheckpointStorage("file:///tmp/flink-checkpoint-storage/");

        // Used to correlate all the pipelines which are part of this app
        String appId = "conduit-flink-demo";

        // todo use builder
        KafkaSource<Record> source = new ConduitSource(
            appId,
            "builtin:postgres",
            Map.of(
                "url", "postgresql://meroxauser:meroxapass@localhost/meroxadb?sslmode=disable",
                "key", "id",
                "table", "employees",
                "snapshotMode", "never",
                "cdcMode", "logrepl"
            )
        ).buildKafkaSource();

        DataStream<Record> in = env.fromSource(
                source,
                WatermarkStrategy.forMonotonousTimestamps(),
                "demo-postgres-source"
            ).map((MapFunction<Record, Record>) value -> {
                value.getMetadata().put("processed-by", "flink-app");
                // ((StructuredData) value.getPayload().getAfter()).put("department", "hr");
                return value;
            })
            .setParallelism(1);

        // todo use builder
        var conduitSink = new ConduitSink(
            appId,
            "file",
            Map.of("path", "/tmp/file-destination.txt")
        );

        in.sinkTo(conduitSink.buildKafkaSink()).setParallelism(1);

        env.execute("Flink Java API Skeleton");
    }
}