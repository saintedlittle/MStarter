package com.github.leanfe.json.types.vanilla;

import com.fasterxml.jackson.annotation.JsonProperty;

@lombok.Data
public class LibraryRule {
    @lombok.Getter(onMethod_ = {@JsonProperty("action")})
    @lombok.Setter(onMethod_ = {@JsonProperty("action")})
    private VanillaAction action;
    @lombok.Getter(onMethod_ = {@JsonProperty("os")})
    @lombok.Setter(onMethod_ = {@JsonProperty("os")})
    private FluffyOS os;
}
