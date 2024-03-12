package examples;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;
import java.util.UUID;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import io.conduit.ConduitSink;
import io.conduit.ConduitSource;
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
        KafkaSource<String> source = new ConduitSource(
            appId,
            "file",
            Map.of("path", "/tmp/file-source.txt")
        ).buildKafkaSource();

        DataStream<String> in = env.fromSource(
                source,
                WatermarkStrategy.noWatermarks(),
                "file-source"
            ).map((MapFunction<String, String>) value -> {
                DocumentContext json = JsonPath.parse(value);
                byte[] afterB = Base64.getDecoder().decode((String) json.read("$.payload.after"));

                String updated = "hello, " + new String(afterB);
                json.set("$.payload.after", Base64.getEncoder().encodeToString(updated.getBytes(StandardCharsets.UTF_8)));

                return json.jsonString();
            })
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