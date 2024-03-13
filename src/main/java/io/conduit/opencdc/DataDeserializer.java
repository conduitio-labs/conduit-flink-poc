package io.conduit.opencdc;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class DataDeserializer extends StdDeserializer<Data> {
    protected DataDeserializer() {
        this(null);
    }

    protected DataDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Data deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        if (p.currentToken() == JsonToken.VALUE_STRING) {
            return new RawData(Base64.getDecoder().decode(p.getValueAsString()));
        } else if (p.currentToken() == JsonToken.START_OBJECT) {
            HashMap map = p.getCodec().readValue(p, HashMap.class);
            return new StructuredData(map);
        }

        throw new IllegalArgumentException("unexpected token: " + p.currentToken());
    }
}
