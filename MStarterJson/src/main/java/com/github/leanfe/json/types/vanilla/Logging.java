package com.github.leanfe.json.types.vanilla;

import com.fasterxml.jackson.annotation.JsonProperty;

@lombok.Data
public class Logging {
    @lombok.Getter(onMethod_ = {@JsonProperty("client")})
    @lombok.Setter(onMethod_ = {@JsonProperty("client")})
    private LoggingClient client;
}
