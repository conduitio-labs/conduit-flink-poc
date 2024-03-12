package io.conduit;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.Getter;
import lombok.SneakyThrows;

@Getter
public class PipelinesConfig {
    private static final ObjectMapper yamlMapper = new ObjectMapper(new YAMLFactory());

    private String version;
    private List<PipelineConfig> pipelines;

    public PipelinesConfig(List<PipelineConfig> pipelines) {
        this.version = "2.2";
        this.pipelines = pipelines;
    }

    @SneakyThrows
    public byte[] yamlBytes() {
        return yamlMapper.writeValueAsBytes(this);
    }

}
