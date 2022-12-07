package com.github.leanfe.json.types.forge;

import com.fasterxml.jackson.annotation.JsonProperty;

@lombok.Data
public class ForgeLibrary {
    @lombok.Getter(onMethod_ = {@JsonProperty("name")})
    @lombok.Setter(onMethod_ = {@JsonProperty("name")})
    private String name;
    @lombok.Getter(onMethod_ = {@JsonProperty("downloads")})
    @lombok.Setter(onMethod_ = {@JsonProperty("downloads")})
    private ForgeDownloads forgeDownloads;
}
