package com.github.leanfe.json.types.forge;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@lombok.Data
public class ForgeArguments {
    @lombok.Getter(onMethod_ = {@JsonProperty("game")})
    @lombok.Setter(onMethod_ = {@JsonProperty("game")})
    private List<String> game;
    @lombok.Getter(onMethod_ = {@JsonProperty("jvm")})
    @lombok.Setter(onMethod_ = {@JsonProperty("jvm")})
    private List<String> jvm;
}
