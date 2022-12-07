package com.github.leanfe.json.types.vanilla;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@lombok.Data
public class Library {
    @lombok.Getter(onMethod_ = {@JsonProperty("downloads")})
    @lombok.Setter(onMethod_ = {@JsonProperty("downloads")})
    private LibraryDownloads downloads;
    @lombok.Getter(onMethod_ = {@JsonProperty("name")})
    @lombok.Setter(onMethod_ = {@JsonProperty("name")})
    private String name;
    @lombok.Getter(onMethod_ = {@JsonProperty("rules")})
    @lombok.Setter(onMethod_ = {@JsonProperty("rules")})
    private List<LibraryRule> rules;
    @lombok.Getter(onMethod_ = {@JsonProperty("natives")})
    @lombok.Setter(onMethod_ = {@JsonProperty("natives")})
    private Natives natives;
    @lombok.Getter(onMethod_ = {@JsonProperty("extract")})
    @lombok.Setter(onMethod_ = {@JsonProperty("extract")})
    private Extract extract;
}
