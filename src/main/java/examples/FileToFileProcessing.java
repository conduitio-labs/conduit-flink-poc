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
import org.apache.kafka.common.serialization.StringSerializer;

public class FileToFileProcessing {
    public static void main(String[] args) throws Exception {
        var env = StreamExecutionEnvironment.getExecutionEnvironment();
        String appId = UUID.randomUUID().toString();

        // todo use builder
        KafkaSource<Record> source = new ConduitSource(
            appId,
            "file",
            Map.of("path", "/tmp/file-source.txt")
        ).buildKafkaSource();

        DataStream<String> in = env.fromSource(
                source,
                WatermarkStrategy.noWatermarks(),
                "file-source"
            ).map((MapFunction<Record, String>) value -> null)
            .setParallelism(1);

        // todo use builder
        var conduitSink = new ConduitSink(
            appId,
            "file",
            Map.of("path", "/tmp/file-destination.txt")
        );
        conduitSink.setValueSerializer(StringSerializer.class);

        in.sinkTo(conduitSink.buildKafkaSink()).setParallelism(1);

        env.execute("Flink Java API Skeleton");
    }
}