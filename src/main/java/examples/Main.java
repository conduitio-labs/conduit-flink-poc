package examples;

import java.util.Map;

import io.conduit.ConduitSink;
import io.conduit.ConduitSource;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.connector.kafka.source.KafkaSource;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.kafka.common.serialization.StringSerializer;

public class Main {
    public static void main(String[] args) throws Exception {
        var env = StreamExecutionEnvironment.getExecutionEnvironment();

        // todo use builder
        KafkaSource<String> source = new ConduitSource("file",
            Map.of("path", "/tmp/file-source.txt")
        ).buildKafkaSource();

        DataStream<String> in = env.fromSource(
            source,
            WatermarkStrategy.noWatermarks(),
            "file-source"
        ).setParallelism(1);

        // todo use builder
        var conduitSink = new ConduitSink(
            "file",
            Map.of("path", "/tmp/file-destination.txt")
        );
        conduitSink.setValueSerializer(StringSerializer.class);

        in.sinkTo(conduitSink.buildKafkaSink());

        env.execute("Flink Java API Skeleton");
    }
}