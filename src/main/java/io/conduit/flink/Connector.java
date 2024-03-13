package io.conduit.flink;

import java.time.Duration;
import java.util.Map;

import io.conduit.PipelineConfig;
import io.conduit.client.api.ConduitServiceApi;
import io.conduit.client.model.V1PipelineStatus;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
abstract class Connector {
    protected static final String KAFKA_SERVERS = "localhost:9092";

    enum Type {
        source,
        destination
    }

    protected final String appId;
    protected final Type type;
    protected final String plugin;
    protected final Map<String, String> settings;

    private final ConduitServiceApi conduit;

    protected Connector(String appId, Type type, String plugin, Map<String, String> settings) {
        this.appId = appId;
        this.type = type;
        this.plugin = plugin;
        this.settings = settings;
        this.conduit = new ConduitServiceApi();
    }

    protected abstract PipelineConfig buildPipeline();

    @SneakyThrows
    protected void createPipeline() {
        PipelineConfig pipeline = buildPipeline();
        var id = conduit.createPipeline(pipeline);

        var status = conduit.waitForPipeline(id, Duration.ofSeconds(30));
        if (status != V1PipelineStatus.RUNNING) {
            throw new IllegalStateException(
                String.format("pipeline %s is in state %s", pipeline.getName(), status)
            );
        }
    }
}
