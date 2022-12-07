package com.github.leanfe.json.types.vanilla;

import com.fasterxml.jackson.annotation.JsonProperty;

@lombok.Data
public class LoggingClient {
    @lombok.Getter(onMethod_ = {@JsonProperty("argument")})
    @lombok.Setter(onMethod_ = {@JsonProperty("argument")})
    private String argument;
    @lombok.Getter(onMethod_ = {@JsonProperty("file")})
    @lombok.Setter(onMethod_ = {@JsonProperty("file")})
    private AssetIndex file;
    @lombok.Getter(onMethod_ = {@JsonProperty("type")})
    @lombok.Setter(onMethod_ = {@JsonProperty("type")})
    private String type;
}
