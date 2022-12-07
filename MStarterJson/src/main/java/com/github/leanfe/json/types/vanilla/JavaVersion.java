package com.github.leanfe.json.types.vanilla;

import com.fasterxml.jackson.annotation.JsonProperty;

@lombok.Data
public class JavaVersion {
    @lombok.Getter(onMethod_ = {@JsonProperty("component")})
    @lombok.Setter(onMethod_ = {@JsonProperty("component")})
    private String component;
    @lombok.Getter(onMethod_ = {@JsonProperty("majorVersion")})
    @lombok.Setter(onMethod_ = {@JsonProperty("majorVersion")})
    private long majorVersion;
}
