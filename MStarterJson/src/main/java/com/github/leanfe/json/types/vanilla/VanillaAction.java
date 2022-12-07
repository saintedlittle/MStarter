package com.github.leanfe.json.types.vanilla;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum VanillaAction {
    ALLOW, DISALLOW;

    @JsonValue
    public String toValue() {
        return switch (this) {
            case ALLOW -> "allow";
            case DISALLOW -> "disallow";
        };
    }

    @JsonCreator
    public static VanillaAction forValue(String value) throws IOException {
        if (value.equals("allow")) return ALLOW;
        if (value.equals("disallow")) return DISALLOW;
        throw new IOException("Cannot deserialize Action");
    }
}
