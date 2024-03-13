package io.conduit;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.SneakyThrows;

@Builder
@Getter
public class PipelineConfig {
    public enum Status {
        running, stopped
    }

    private String id;
    private Status status;
    private String name;
    private String description;
    @Singular
    private List<ConnectorConfig> connectors;
    private DLQConfig DLQ;
}
