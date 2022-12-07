package com.github.leanfe.json.types.vanilla;

import com.fasterxml.jackson.annotation.*;

@lombok.Data
public class VanillaJVMRule {
    @lombok.Getter(onMethod_ = {@JsonProperty("action")})
    @lombok.Setter(onMethod_ = {@JsonProperty("action")})
    private VanillaAction action;
    @lombok.Getter(onMethod_ = {@JsonProperty("os")})
    @lombok.Setter(onMethod_ = {@JsonProperty("os")})
    private PurpleOS os;
}
