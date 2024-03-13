package io.conduit.flink;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.cfg.EnumFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.conduit.opencdc.Record;
import lombok.SneakyThrows;
import org.apache.kafka.common.serialization.Serializer;

public class RecordSerializer implements Serializer<Record> {
    public static final ObjectMapper mapper = JsonMapper.builder()
        .enable(EnumFeature.WRITE_ENUMS_TO_LOWERCASE)
        .build();

    @SneakyThrows
    @Override
    public byte[] serialize(String topic, Record data) {
        return mapper.writeValueAsBytes(data);
    }
}
