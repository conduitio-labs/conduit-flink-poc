package io.conduit.flink;

import java.nio.charset.StandardCharsets;

import io.conduit.opencdc.RawData;
import io.conduit.opencdc.Record;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class RecordDeserializerTest {
    @Test
    void test() {
        String data = "{\n" +
            "    \"position\": \"MQ==\",\n" +
            "    \"operation\": \"create\",\n" +
            "    \"metadata\":\n" +
            "    {\n" +
            "        \"conduit.source.connector.id\": \"source-pipeline-15398109-1eb3-4fdb-92fb-23801c346eeb:file-source\",\n" +
            "        \"file.path\": \"/tmp/file-source.txt\",\n" +
            "        \"opencdc.readAt\": \"1710258047224266472\",\n" +
            "        \"opencdc.version\": \"v1\"\n" +
            "    },\n" +
            "    \"key\": \"dGVzdCBrZXk=\",\n" +
            "    \"payload\":\n" +
            "    {\n" +
            "        \"before\": null,\n" +
            "        \"after\": \"\"\n" +
            "    }\n" +
            "}";

        try (var underTest = new RecordDeserializer()) {
            Record record = underTest.deserialize(
                "irrelevant-topic",
                data.getBytes(StandardCharsets.UTF_8)
            );
            assertInstanceOf(RawData.class, record.getKey());
            assertArrayEquals(
                "test key".getBytes(StandardCharsets.UTF_8),
                ((RawData) record.getKey()).getBytes()
            );
        }
    }
}