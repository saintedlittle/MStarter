package com.github.leanfe.json.types.vanilla;

import com.fasterxml.jackson.annotation.JsonProperty;

@lombok.Data
public class PurpleOS {
    @lombok.Getter(onMethod_ = {@JsonProperty("name")})
    @lombok.Setter(onMethod_ = {@JsonProperty("name")})
    private String name;
    @lombok.Getter(onMethod_ = {@JsonProperty("version")})
    @lombok.Setter(onMethod_ = {@JsonProperty("version")})
    private String version;
    @lombok.Getter(onMethod_ = {@JsonProperty("arch")})
    @lombok.Setter(onMethod_ = {@JsonProperty("arch")})
    private String arch;
}
