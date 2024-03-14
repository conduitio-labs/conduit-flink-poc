package io.conduit;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

@Builder
@Getter
public class PipelineConfig {
    private String id;
    private String name;
    private String description;
    @Singular
    private List<ConnectorConfig> connectors;
    private DLQConfig DLQ;
}
