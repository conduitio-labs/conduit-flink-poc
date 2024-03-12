package io.conduit;

import java.util.List;
import java.util.Map;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;

@Getter
@Setter
@Builder
public class ConnectorConfig {
    private String id;
    private String type;
    private String plugin;
    private Map<String, String> settings;
    @Singular
    private List<ProcessorConfig> processors;
}
