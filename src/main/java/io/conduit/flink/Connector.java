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
    enum Type {
        SOURCE,
        DESTINATION
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
        this.conduit = new ConduitServiceApi(conduitUrl());
    }

    protected abstract PipelineConfig buildPipeline();

    private String conduitUrl() {
        return System.getProperty("conduit.url", "http://localhost:8080");
    }

    protected String kafkaServers() {
        return System.getProperty("conduit.kafka.servers", "localhost:9092");
    }

    @SneakyThrows
    protected void createPipeline() {
        PipelineConfig pipeline = buildPipeline();
        String id;
        try {
            log.debug("creating pipeline {}", pipeline.getName());
            id = conduit.createPipeline(pipeline);
        } catch (ApiException e) {
            if (pipelineExists(e)) {
                log.info("pipeline {} already exists", pipeline.getName());
                id = conduit.getPipelineIdForName(pipeline.getName());
            } else {
                throw e;
            }
        }

        log.debug("waiting for pipeline {} to transition into 'running'", id);
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
