package io.conduit.client.api;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import io.conduit.ConnectorConfig;
import io.conduit.PipelineConfig;
import io.conduit.ProcessorConfig;
import io.conduit.client.ApiClient;
import io.conduit.client.ApiException;
import io.conduit.client.model.*;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConduitServiceApi {
    private final PipelineServiceApi pipelineService;
    private final ConnectorServiceApi connectorService;
    private final ProcessorServiceApi processorService;

    public ConduitServiceApi(String basePath) {
        ApiClient apiClient = new ApiClient().setBasePath(basePath);
        this.pipelineService = new PipelineServiceApi(apiClient);
        this.connectorService = new ConnectorServiceApi(apiClient);
        this.processorService = new ProcessorServiceApi(apiClient);
    }

    public String createPipeline(PipelineConfig cfg) throws ApiException {
        V1CreatePipelineRequest req = new V1CreatePipelineRequest()
            .config(new V1PipelineConfig()
                .name(cfg.getName())
                .description(cfg.getDescription())
            );

        V1Pipeline pipeline = pipelineService.pipelineServiceCreatePipeline(req);

        for (ConnectorConfig conn : cfg.getConnectors()) {
            V1Connector connResp = connectorService.connectorServiceCreateConnector(
                makeConnectorRequest(pipeline.getId(), conn)
            );

            addConnProcessors(connResp.getId(), conn.getProcessors());
        }

        pipelineService.pipelineServiceStartPipeline(pipeline.getId());

        return pipeline.getId();
    }

    @SneakyThrows
    private void addConnProcessors(String connectorId, List<ProcessorConfig> processors) {
        for (ProcessorConfig proc : processors) {
            processorService.processorServiceCreateProcessor(new V1CreateProcessorRequest()
                .plugin(proc.getPlugin())
                .parent(new ProcessorParent().type(ProcessorParentType.CONNECTOR).id(connectorId))
                .config(new V1ProcessorConfig().settings(proc.getSettings()))
            );
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

    @SneakyThrows
    public V1PipelineStatus waitForPipeline(String id, Duration duration) {
        LocalDateTime deadline = LocalDateTime.now().plus(duration);

        var status = V1PipelineStatus.STOPPED;

        while (status == V1PipelineStatus.STOPPED && LocalDateTime.now().isBefore(deadline)) {
            Thread.sleep(1_000);

            V1Pipeline p = pipelineService.pipelineServiceGetPipeline(id);
            status = p.getState().getStatus();
        }

        return status;
    }

    @SneakyThrows
    public String getPipelineIdForName(String name) {
        List<V1Pipeline> pipelines = pipelineService.pipelineServiceListPipelines(name);
        if (pipelines.isEmpty()) {
            return null;
        }

        return pipelines.get(0).getId();
    }
}
