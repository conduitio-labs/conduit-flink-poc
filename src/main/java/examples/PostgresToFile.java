package examples;

import java.util.Map;
import java.util.UUID;

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
        String appId;
        if (args.length == 1) {
            appId = args[0];
        } else {
            appId = UUID.randomUUID().toString();
        }

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
                WatermarkStrategy.noWatermarks(),
                "demo-postgres-source"
            ).map((MapFunction<Record, Record>) value -> {
                value.getMetadata().put("processed-by", "flink");
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