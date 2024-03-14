package io.conduit.flink;

import java.util.Map;

import io.conduit.ConnectorConfig;
import io.conduit.PipelineConfig;
import io.conduit.opencdc.Record;
import lombok.extern.slf4j.Slf4j;
import org.apache.flink.connector.kafka.source.KafkaSource;
import org.apache.flink.connector.kafka.source.reader.deserializer.KafkaRecordDeserializationSchema;

@Slf4j
public class ConduitSource extends Connector {
    private static final String KAFKA_TOPIC = "flink-topic-source";

    public ConduitSource(String appId, String plugin, Map<String, String> settings) {
        super(appId, Type.source, plugin, settings);
    }

    public KafkaSource<Record> buildKafkaSource() {
        createPipeline();

        // todo auto-create topic
        return KafkaSource.<Record>builder()
            .setTopics(KAFKA_TOPIC)
            .setBootstrapServers(KAFKA_SERVERS)
            .setGroupId("conduit-" + appId + "-source")
            .setDeserializer(KafkaRecordDeserializationSchema.valueOnly(RecordDeserializer.class))
            .build();
    }

    @Override
    protected PipelineConfig buildPipeline() {
        return PipelineConfig.builder()
            .name(plugin + "-source-pipeline-" + appId)
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
