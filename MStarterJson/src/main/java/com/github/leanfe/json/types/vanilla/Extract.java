package com.github.leanfe.json.types.vanilla;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@lombok.Data
public class Extract {
    @lombok.Getter(onMethod_ = {@JsonProperty("exclude")})
    @lombok.Setter(onMethod_ = {@JsonProperty("exclude")})
    private List<String> exclude;
}
