package com.github.leanfe.json.types.vanilla;

import com.fasterxml.jackson.annotation.JsonProperty;

@lombok.Data
public class Natives {
    @lombok.Getter(onMethod_ = {@JsonProperty("osx")})
    @lombok.Setter(onMethod_ = {@JsonProperty("osx")})
    private String osx;
    @lombok.Getter(onMethod_ = {@JsonProperty("linux")})
    @lombok.Setter(onMethod_ = {@JsonProperty("linux")})
    private String linux;
    @lombok.Getter(onMethod_ = {@JsonProperty("windows")})
    @lombok.Setter(onMethod_ = {@JsonProperty("windows")})
    private String windows;
}
