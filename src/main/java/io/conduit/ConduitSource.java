package io.conduit;

import java.util.Map;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.flink.connector.kafka.source.KafkaSource;
import org.apache.flink.connector.kafka.source.reader.deserializer.KafkaRecordDeserializationSchema;
import org.apache.kafka.common.serialization.StringDeserializer;

@Slf4j
public class ConduitSource extends Connector {
    public ConduitSource(String appId, String plugin, Map<String, String> settings) {
        super(appId, Type.source, plugin, settings);
    }

    @SneakyThrows
    public KafkaSource<String> buildKafkaSource() {
        String path = writeConfigFile();

        startPipeline(path, log);

        // todo auto-create topic
        return KafkaSource.<String>builder()
            .setTopics(KAFKA_TOPIC)
            .setBootstrapServers(KAFKA_SERVERS)
            .setDeserializer(KafkaRecordDeserializationSchema.valueOnly(StringDeserializer.class))
            .build();
    }

    @Override
    protected PipelineConfig buildPipeline(String appId) {
        return PipelineConfig.builder()
            .id("source-pipeline-" + appId)
            .status(PipelineConfig.Status.running)
            .connector(ConnectorConfig.builder()
                .id(plugin + "-source")
                .type("source")
                .plugin(plugin)
                .settings(settings)
                .build()
            ).connector(ConnectorConfig.builder()
                .id("kafka-destination")
                .type("destination")
                .plugin("kafka")
                .settings(Map.of(
                    "servers", KAFKA_SERVERS,
                    "topic", KAFKA_TOPIC
                ))
                .build()
            )
            .build();
    }
}
