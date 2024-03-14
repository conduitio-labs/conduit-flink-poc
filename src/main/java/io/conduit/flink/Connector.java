package io.conduit.flink;

import java.time.Duration;
import java.util.Map;

import io.conduit.PipelineConfig;
import io.conduit.client.ApiException;
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
        String id;
        try {
            id = conduit.createPipeline(pipeline);
        } catch (ApiException e) {
            if (pipelineExists(e)) {
                log.info("pipeline already exists");
                id = conduit.getPipelineIdForName(pipeline.getName());
            } else {
                throw e;
            }
        }

        var status = conduit.waitForPipeline(id, Duration.ofSeconds(30));
        if (status != V1PipelineStatus.RUNNING) {
            throw new IllegalStateException(
                String.format("pipeline %s is in state %s", pipeline.getName(), status)
            );
        }
    }

    private boolean pipelineExists(ApiException e) {
        return e.getCode() == 409 && e.getResponseBody().contains("pipeline name already exists");
    }
}
