package io.conduit.flink;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.conduit.opencdc.Record;
import lombok.SneakyThrows;
import org.apache.kafka.common.serialization.Deserializer;

public class RecordDeserializer implements Deserializer<Record> {
    public static final ObjectMapper mapper = JsonMapper.builder()
        .enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS)
        .build();

    @SneakyThrows
    @Override
    public Record deserialize(String topic, byte[] data) {
        return mapper.readValue(data, Record.class);
    }
}
