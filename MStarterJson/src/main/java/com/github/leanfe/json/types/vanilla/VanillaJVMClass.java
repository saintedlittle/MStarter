package com.github.leanfe.json.types.vanilla;

import com.fasterxml.jackson.annotation.*;

import java.util.List;

@lombok.Data
public class VanillaJVMClass {
    @lombok.Getter(onMethod_ = {@JsonProperty("rules")})
    @lombok.Setter(onMethod_ = {@JsonProperty("rules")})
    private List<VanillaJVMRule> rules;
    @lombok.Getter(onMethod_ = {@JsonProperty("value")})
    @lombok.Setter(onMethod_ = {@JsonProperty("value")})
    private VanillaValue value;
}
