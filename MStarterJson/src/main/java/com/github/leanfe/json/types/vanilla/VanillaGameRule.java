package com.github.leanfe.json.types.vanilla;

import com.fasterxml.jackson.annotation.*;

@lombok.Data
public class VanillaGameRule {
    @lombok.Getter(onMethod_ = {@JsonProperty("action")})
    @lombok.Setter(onMethod_ = {@JsonProperty("action")})
    private VanillaAction action;
    @lombok.Getter(onMethod_ = {@JsonProperty("features")})
    @lombok.Setter(onMethod_ = {@JsonProperty("features")})
    private VanillaFeatures features;
}
