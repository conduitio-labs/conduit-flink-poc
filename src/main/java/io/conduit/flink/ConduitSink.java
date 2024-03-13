package io.conduit.flink;

import java.util.Map;

import io.conduit.ConnectorConfig;
import io.conduit.PipelineConfig;
import io.conduit.ProcessorConfig;
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
    private static final String KAFKA_TOPIC = "flink-topic-sink";

    private Class<? extends Serializer<? super String>> keySerializer;
    private Class<? extends Serializer<? super String>> valueSerializer;

    public ConduitSink(String appId, String plugin, Map<String, String> settings) {
        super(appId, Type.destination, plugin, settings);
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
    protected PipelineConfig buildPipeline(String appId) {
        return PipelineConfig.builder()
            .id("destination-pipeline-" + appId)
            .status(PipelineConfig.Status.running)
            .connector(ConnectorConfig.builder()
                .id("kafka-source")
                .type("source")
                .plugin("kafka")
                .settings(Map.of(
                    "servers", KAFKA_SERVERS,
                    "topic", KAFKA_TOPIC,
                    "readFromBeginning", "true"
                ))
                .build()
            ).connector(ConnectorConfig.builder()
                .id(plugin + "-destination")
                .type("destination")
                .plugin(plugin)
                .settings(settings)
                .processor(ProcessorConfig.builder()
                    .id("unwrap-opencdc")
                    .plugin("unwrap.opencdc")
                    .settings(Map.of())
                    .build())
                .build()
            )
            .build();
    }
}
