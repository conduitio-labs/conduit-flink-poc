package io.conduit.opencdc;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Change {
    @JsonDeserialize(using = DataDeserializer.class)
    private Data before;
    @JsonDeserialize(using = DataDeserializer.class)
    private Data after;
}
