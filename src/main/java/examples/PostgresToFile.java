package examples;

import java.time.Duration;
import java.util.Map;

import io.conduit.flink.ConduitSink;
import io.conduit.flink.ConduitSource;
import io.conduit.opencdc.Record;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.connector.kafka.source.KafkaSource;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class PostgresToFile {
    public static void main(String[] args) throws Exception {
        var env = StreamExecutionEnvironment.getExecutionEnvironment();
        // Used to correlate all the pipelines which are part of this app
        String appId = "conduit-flink-demo";

        // todo use builder
        KafkaSource<Record> source = new ConduitSource(
            appId,
            "builtin:postgres",
            Map.of(
                "url", "postgresql://meroxauser:meroxapass@pg-0/meroxadb?sslmode=disable",
                "key", "id",
                "table", "employees",
                "snapshotMode", "never",
                "cdcMode", "logrepl"
            )
        ).buildKafkaSource();

        DataStream<Record> in = env.fromSource(
                source,
                WatermarkStrategy.forBoundedOutOfOrderness(Duration.ofSeconds(1)),
                "demo-postgres-source"
            ).map((MapFunction<Record, Record>) value -> {
                value.getMetadata().put("processed-by", "flink");
                value.getMetadata().put("another-key", "flink-value");
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