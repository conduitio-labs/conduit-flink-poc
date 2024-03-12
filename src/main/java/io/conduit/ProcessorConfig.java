package io.conduit;


import java.util.HashMap;
import java.util.Map;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProcessorConfig {
    private String id;
    private String plugin;
    private Map<String, String> settings = new HashMap<>();
}
