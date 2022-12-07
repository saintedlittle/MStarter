package com.github.leanfe.json.types.vanilla;

import com.fasterxml.jackson.annotation.*;

import java.util.List;

@lombok.Data
public class VanillaArguments {
    @lombok.Getter(onMethod_ = {@JsonProperty("game")})
    @lombok.Setter(onMethod_ = {@JsonProperty("game")})
    private List<VanillaGameElement> game;
    @lombok.Getter(onMethod_ = {@JsonProperty("jvm")})
    @lombok.Setter(onMethod_ = {@JsonProperty("jvm")})
    private List<VanillaJVMElement> jvm;
}
