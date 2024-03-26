package io.conduit.flink;

import java.util.Map;

import io.conduit.ConnectorConfig;
import io.conduit.PipelineConfig;
import io.conduit.opencdc.Record;
import lombok.extern.slf4j.Slf4j;
import org.apache.flink.connector.kafka.source.KafkaSource;
import org.apache.flink.connector.kafka.source.enumerator.initializer.OffsetsInitializer;
import org.apache.flink.connector.kafka.source.reader.deserializer.KafkaRecordDeserializationSchema;
import org.apache.kafka.clients.consumer.OffsetResetStrategy;

@Slf4j
public class ConduitSource extends Connector {
    public ConduitSource(String appId, String plugin, Map<String, String> settings) {
        super(appId, Type.SOURCE, plugin, settings);
    }

    public KafkaSource<Record> buildKafkaSource() {
        createPipeline();

        // todo auto-create topic
        return KafkaSource.<Record>builder()
            .setTopics(kafkaSourceTopic())
            .setBootstrapServers(kafkaServers())
            .setGroupId("conduit-source-" + appId)
            .setStartingOffsets(OffsetsInitializer.committedOffsets(OffsetResetStrategy.EARLIEST))
            .setDeserializer(KafkaRecordDeserializationSchema.valueOnly(RecordDeserializer.class))
            .build();
    }

    private String kafkaSourceTopic() {
        return System.getProperty("conduit.source.pipeline.topic", "flink-topic-source");
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
                    "servers", kafkaServers(),
                    "topic", kafkaSourceTopic()
                ))
                .build()
            )
            .build();
    }
}
