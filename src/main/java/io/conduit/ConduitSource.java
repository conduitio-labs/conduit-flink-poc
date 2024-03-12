package io.conduit;

import java.util.Map;
import java.util.UUID;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.flink.connector.kafka.source.KafkaSource;
import org.apache.flink.connector.kafka.source.reader.deserializer.KafkaRecordDeserializationSchema;
import org.apache.kafka.common.serialization.StringDeserializer;

@Slf4j
public class ConduitSource extends Connector {
    public ConduitSource(String plugin, Map<String, String> settings) {
        super(Type.source, plugin, settings);
    }

    @SneakyThrows
    public KafkaSource<String> buildKafkaSource() {
        String path = writeConfigFile();

        startPipeline(path, log);

        return KafkaSource.<String>builder()
            .setTopics(KAFKA_TOPIC)
            .setBootstrapServers(KAFKA_SERVERS)
            .setDeserializer(KafkaRecordDeserializationSchema.valueOnly(StringDeserializer.class))
            .build();
    }

    @Override
    protected PipelineConfig buildPipeline() {
        return PipelineConfig.builder()
            .id("source-pipeline-" + UUID.randomUUID())
            .status(PipelineConfig.Status.running)
            .connector(
                new ConnectorConfig(plugin + "-source", "source", plugin, settings)
            ).connector(
                new ConnectorConfig(
                    "kafka-destination",
                    "destination",
                    "kafka",
                    Map.of(
                        "servers", KAFKA_SERVERS,
                        "topic", KAFKA_TOPIC
                    )
                )
            )
            .build();
    }
}
