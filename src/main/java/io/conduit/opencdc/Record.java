package io.conduit.opencdc;

import java.util.Map;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Record {
    private byte[] position;
    private Operation operation;
    Map<String, String> metadata;
    @JsonDeserialize(using = DataDeserializer.class)
    private Data key;
    private Change payload;
}
