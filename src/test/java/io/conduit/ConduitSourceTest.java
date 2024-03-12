package io.conduit;

import java.util.Map;

import org.apache.flink.connector.kafka.source.KafkaSource;
import org.junit.jupiter.api.Test;

class ConduitSourceIT {
    @Test
    void test() {
        KafkaSource<String> result = new ConduitSource(
            "file",
            Map.of("path", "/tmp/file-source.txt")
        ).buildKafkaSource();

        System.out.println(result);
    }
}