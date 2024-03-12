package io.conduit;

import java.util.Map;
import java.util.UUID;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.flink.api.connector.sink2.Sink;
import org.apache.flink.connector.kafka.sink.KafkaRecordSerializationSchema;
import org.apache.flink.connector.kafka.sink.KafkaRecordSerializationSchemaBuilder;
import org.apache.flink.connector.kafka.sink.KafkaSink;
import org.apache.kafka.common.serialization.Serializer;

@Setter
@Slf4j
public class ConduitSink extends Connector {
    private Class<? extends Serializer<? super String>> keySerializer;
    private Class<? extends Serializer<? super String>> valueSerializer;

    public ConduitSink(String plugin, Map<String, String> settings) {
        super(Type.destination, plugin, settings);
    }

    public Sink<String> buildKafkaSink() {
        String path = writeConfigFile();

        startPipeline(path, log);

        KafkaRecordSerializationSchemaBuilder<String> serializerBuilder = KafkaRecordSerializationSchema
            .<String>builder()
            .setTopic(KAFKA_TOPIC);

        if (this.keySerializer != null) {
            serializerBuilder.setKafkaKeySerializer(this.keySerializer);
        }

        if (valueSerializer != null) {
            serializerBuilder.setKafkaValueSerializer(this.valueSerializer);
        }

        return KafkaSink.<String>builder()
            .setRecordSerializer(serializerBuilder.build())
            .setBootstrapServers(KAFKA_SERVERS)
            .build();
    }

    @Override
    protected PipelineConfig buildPipeline() {
        return PipelineConfig.builder()
            .id("destination-pipeline-" + UUID.randomUUID())
            .status(PipelineConfig.Status.running)
            .connector(
                new ConnectorConfig(
                    "kafka-source",
                    "source",
                    "kafka",
                    Map.of(
                        "servers", KAFKA_SERVERS,
                        "topic", KAFKA_TOPIC,
                        "readFromBeginning", "true"
                    )
                )
            ).connector(
                new ConnectorConfig(
                    plugin + "-destination",
                    "destination",
                    plugin,
                    settings
                )
            )
            .build();
    }
}
