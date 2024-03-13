package io.conduit.flink;

import java.util.Map;

import io.conduit.ConnectorConfig;
import io.conduit.PipelineConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.flink.connector.kafka.source.KafkaSource;
import org.apache.flink.connector.kafka.source.reader.deserializer.KafkaRecordDeserializationSchema;
import org.apache.kafka.common.serialization.StringDeserializer;

@Slf4j
public class ConduitSource extends Connector {
    private static final String KAFKA_TOPIC = "flink-topic-source";

    public ConduitSource(String appId, String plugin, Map<String, String> settings) {
        super(appId, Type.source, plugin, settings);
    }

    public KafkaSource<String> buildKafkaSource() {
        createPipeline();

        // todo auto-create topic
        return KafkaSource.<String>builder()
            .setTopics(KAFKA_TOPIC)
            .setBootstrapServers(KAFKA_SERVERS)
            .setGroupId("conduit-" + appId + "-source")
            .setDeserializer(KafkaRecordDeserializationSchema.valueOnly(StringDeserializer.class))
            .build();
    }

    @Override
    protected PipelineConfig buildPipeline() {
        PipelineConfig pipeline = PipelineConfig.builder()
            .name(plugin + "-source-pipeline-" + appId)
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

        return pipeline;
    }
}
