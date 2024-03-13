package io.conduit.flink;

import java.nio.charset.StandardCharsets;
import java.util.Map;

import io.conduit.opencdc.RawData;
import io.conduit.opencdc.Record;
import io.conduit.opencdc.StructuredData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class RecordDeserializerTest {
    @Test
    void testRawData() {
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

    @Test
    void testStructuredData() {
        String data = "{\n" +
            "    \"position\": \"ZjAzYTUzYTItZjdjNS00NjFlLTlmMTYtMTg1NGI4ZjNkOTYy\",\n" +
            "    \"operation\": \"create\",\n" +
            "    \"metadata\":\n" +
            "    {\n" +
            "        \"conduit.source.connector.id\": \"a7165629-605e-44ea-8832-9d439df68a71\",\n" +
            "        \"opencdc.readAt\": \"1710366134234277477\",\n" +
            "        \"opencdc.version\": \"v1\"\n" +
            "    },\n" +
            "    \"key\": \"MDI5MWZjMzYtNjgwYi00ZDljLWIyNDYtNzVjMzE1Y2M3Y2Yx\",\n" +
            "    \"payload\":\n" +
            "    {\n" +
            "        \"before\": null,\n" +
            "        \"after\":\n" +
            "        {\n" +
            "            \"id\": 1535796160,\n" +
            "            \"name\": \"string b2a659f8-a4ab-41a2-9479-4531356da012\"\n" +
            "        }\n" +
            "    }\n" +
            "}";


        try (var underTest = new RecordDeserializer()) {
            Record record = underTest.deserialize(
                "irrelevant-topic",
                data.getBytes(StandardCharsets.UTF_8)
            );
            assertInstanceOf(StructuredData.class, record.getPayload().getAfter());
            assertEquals(
                new StructuredData(Map.of(
                    "id", 1535796160,
                    "name", "string b2a659f8-a4ab-41a2-9479-4531356da012"
                )),
                record.getPayload().getAfter()
            );
        }
    }
}