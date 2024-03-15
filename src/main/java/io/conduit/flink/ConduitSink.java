package io.conduit.flink;

import java.util.Map;

import io.conduit.ConnectorConfig;
import io.conduit.PipelineConfig;
import io.conduit.ProcessorConfig;
import io.conduit.opencdc.Record;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.flink.api.connector.sink2.Sink;
import org.apache.flink.connector.kafka.sink.KafkaRecordSerializationSchema;
import org.apache.flink.connector.kafka.sink.KafkaRecordSerializationSchemaBuilder;
import org.apache.flink.connector.kafka.sink.KafkaSink;

@Setter
@Slf4j
public class ConduitSink extends Connector {
    private static final String KAFKA_TOPIC = "flink-topic-sink";

    public ConduitSink(String appId, String plugin, Map<String, String> settings) {
        super(appId, Type.destination, plugin, settings);
    }

    public Sink<Record> buildKafkaSink() {
        createPipeline();

        KafkaRecordSerializationSchemaBuilder<Record> serializerBuilder = KafkaRecordSerializationSchema
            .<Record>builder()
            .setTopic(KAFKA_TOPIC)
            .setKafkaValueSerializer(RecordSerializer.class);

        return KafkaSink.<Record>builder()
            .setRecordSerializer(serializerBuilder.build())
            .setBootstrapServers(KAFKA_SERVERS)
            .build();
    }

    @Override
    protected PipelineConfig buildPipeline() {
        return PipelineConfig.builder()
            .name(plugin + "-destination-pipeline-" + appId)
            .connector(ConnectorConfig.builder()
                .id("kafka-source")
                .type("source")
                .plugin("kafka")
                .settings(Map.of(
                    "servers", KAFKA_SERVERS_INTERNAL_ADDRESS,
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
                    // todo needed because the serialization library
                    // translates empty maps into null, which Conduit cannot handle
                    .settings(Map.of(
                        "field", ".Payload.After"
                    ))
                    .build())
                .build()
            )
            .build();
    }
}
