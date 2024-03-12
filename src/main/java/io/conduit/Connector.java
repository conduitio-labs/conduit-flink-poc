package io.conduit;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Map;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.zeroturnaround.exec.ProcessExecutor;
import org.zeroturnaround.exec.StartedProcess;
import org.zeroturnaround.exec.stream.slf4j.Slf4jStream;

@RequiredArgsConstructor
@Slf4j
abstract class Connector {
    private static final String conduitExec = "/home/haris/projects/conduitio/conduit/conduit";

    protected static final String KAFKA_TOPIC = "internal-topic";
    protected static final String KAFKA_SERVERS = "localhost:9092";

    enum Type {
        source,
        destination;
    }

    protected final Type type;
    protected final String plugin;
    protected final Map<String, String> settings;

    protected abstract PipelineConfig buildPipeline();

    protected StartedProcess process;

    @SneakyThrows
    protected String writeConfigFile() {
        PipelineConfig pipeline = buildPipeline();

        PipelinesConfig cfg = new PipelinesConfig(List.of(pipeline));

        String path = String.format("/home/haris/Desktop/conduit/flink-pipelines/pipeline-%s.yaml", pipeline.getId());
        Files.write(Path.of(path), cfg.yamlBytes(), StandardOpenOption.CREATE);

        log.info("pipeline written at {}", path);
        return path;
    }

    @SneakyThrows
    protected void startPipeline(String path, Logger log) {
        this.process = new ProcessExecutor()
            .command(conduitExec, "--pipelines.path", path, "--api.enabled", "false")
            .redirectOutput(Slf4jStream.of(log).asInfo())
            .start();
    }
}
