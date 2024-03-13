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

public class GeneratorToFileProcessing {
    public static void main(String[] args) throws Exception {
        var env = StreamExecutionEnvironment.getExecutionEnvironment();
        String appId = UUID.randomUUID().toString();

        // todo use builder
        KafkaSource<Record> source = new ConduitSource(
            appId,
            "generator",
            Map.of(
                "recordCount", "1",
                "format.options", "id:int,name:string",
                "format.type", "structured"
            )
        ).buildKafkaSource();

        DataStream<Record> in = env.fromSource(
                source,
                WatermarkStrategy.noWatermarks(),
                "generator-source"
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