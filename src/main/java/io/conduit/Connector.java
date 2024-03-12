package io.conduit;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Map;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.zeroturnaround.exec.ProcessExecutor;
import org.zeroturnaround.exec.StartedProcess;
import org.zeroturnaround.exec.stream.slf4j.Slf4jStream;

@Slf4j
abstract class Connector {
    private static final String CONDUIT_EXEC = "/home/haris/projects/conduitio/conduit/conduit";
    private static final String BASE_DIR = "/home/haris/Desktop/conduit/flink-apps";
    protected static final String KAFKA_SERVERS = "localhost:9092";

    enum Type {
        source,
        destination;
    }

    protected final String appId;
    protected final Type type;
    protected final String plugin;
    protected final Map<String, String> settings;
    private final Path conduitDir;

    protected StartedProcess process;

    public Connector(String appId, Type type, String plugin, Map<String, String> settings) {
        this.appId = appId;
        this.type = type;
        this.plugin = plugin;
        this.settings = settings;
        this.conduitDir = makeConduitDir();
    }

    protected abstract PipelineConfig buildPipeline(String appId);

    @SneakyThrows
    protected String writeConfigFile() {
        PipelineConfig pipeline = buildPipeline(appId);

        PipelinesConfig cfg = new PipelinesConfig(List.of(pipeline));

        Path path = conduitDir.resolve("pipeline.yaml");
        Files.write(path, cfg.yamlBytes(), StandardOpenOption.CREATE);

        log.info("pipeline written at {}", path);
        return path.toString();
    }

    @SneakyThrows
    protected void startPipeline(String path, Logger log) {
        this.process = new ProcessExecutor()
            .command(CONDUIT_EXEC, "--pipelines.path=" + path, "--api.enabled=false")
            .redirectOutput(Slf4jStream.of(log).asInfo())
            .directory(conduitDir.toFile())
            .start();
    }

    private Path makeConduitDir() {
        Path path = Path.of(BASE_DIR, String.format("%s/%s", appId, type));
        if (!path.toFile().mkdirs()) {
            throw new IllegalStateException("failed creating directory structure: " + path);
        }

        return path;
    }
}
