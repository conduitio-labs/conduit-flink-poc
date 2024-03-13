package io.conduit.flink;

import java.time.LocalDateTime;
import java.util.Map;

import io.conduit.ConnectorConfig;
import io.conduit.PipelineConfig;
import io.conduit.client.ApiClient;
import io.conduit.client.api.ConnectorServiceApi;
import io.conduit.client.api.PipelineServiceApi;
import io.conduit.client.model.V1Connector;
import io.conduit.client.model.V1ConnectorConfig;
import io.conduit.client.model.V1ConnectorType;
import io.conduit.client.model.V1CreateConnectorRequest;
import io.conduit.client.model.V1CreatePipelineRequest;
import io.conduit.client.model.V1Pipeline;
import io.conduit.client.model.V1PipelineConfig;
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

    private final PipelineServiceApi pipelineService;
    private final ConnectorServiceApi connectorService;

    protected Connector(String appId, Type type, String plugin, Map<String, String> settings) {
        this.appId = appId;
        this.type = type;
        this.plugin = plugin;
        this.settings = settings;
        ApiClient apiClient = new ApiClient().setBasePath("http://localhost:8080");
        this.pipelineService = new PipelineServiceApi(apiClient);
        this.connectorService = new ConnectorServiceApi(apiClient);
    }

    protected abstract PipelineConfig buildPipeline();

    @SneakyThrows
    protected void createPipeline() {
        PipelineConfig pipeline = buildPipeline();

        V1CreatePipelineRequest req = new V1CreatePipelineRequest()
            .config(new V1PipelineConfig()
                .name(pipeline.getName())
                .description(pipeline.getDescription())
            );

        V1Pipeline pipelineResp = pipelineService.pipelineServiceCreatePipeline(req);

        for (ConnectorConfig conn : pipeline.getConnectors()) {
            V1Connector connResp = connectorService.connectorServiceCreateConnector(
                makeConnectorRequest(pipelineResp.getId(), conn)
            );
        }

        pipelineService.pipelineServiceStartPipeline(pipelineResp.getId());

        LocalDateTime deadline = LocalDateTime.now().plusSeconds(30);

        var status = V1PipelineStatus.STOPPED;

        while (status == V1PipelineStatus.STOPPED && LocalDateTime.now().isBefore(deadline)) {
            Thread.sleep(1_000);

            V1Pipeline p = pipelineService.pipelineServiceGetPipeline(pipelineResp.getId());
            status = p.getState().getStatus();
        }

        if (status == V1PipelineStatus.DEGRADED) {
            throw new IllegalStateException("pipeline is degraded");
        }
    }

    private V1CreateConnectorRequest makeConnectorRequest(String pipelineId, ConnectorConfig conn) {
        return new V1CreateConnectorRequest()
            .pipelineId(pipelineId)
            .type(toV1ConnectorType(conn.getType()))
            .plugin(conn.getPlugin())
            .config(new V1ConnectorConfig()
                .name(conn.getId())
                .settings(conn.getSettings())
            );
    }

    private V1ConnectorType toV1ConnectorType(String type) {
        return V1ConnectorType.fromValue("TYPE_" + type.toUpperCase());
    }
}
