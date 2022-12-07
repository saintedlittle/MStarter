package com.github.leanfe.json.types.vanilla;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.IOException;

public enum Name {
    OSX;

    @JsonValue
    public String toValue() {
        switch (this) {
            case OSX:
                return "osx";
        }
        return null;
    }

    @JsonCreator
    public static Name forValue(String value) throws IOException {
        if (value.equals("osx")) return OSX;
        throw new IOException("Cannot deserialize Name");
    }
}
