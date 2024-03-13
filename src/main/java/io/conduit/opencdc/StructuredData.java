package io.conduit.opencdc;

import java.util.HashMap;
import java.util.Map;

public class StructuredData extends HashMap<String, Object> implements Data {
    public StructuredData(Map<String, Object> map) {
        super(map);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
