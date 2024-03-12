package io.conduit;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ConnectorConfig {
    private String id;
    private String type;
    private String plugin;
    private Map<String, String> settings;
}
