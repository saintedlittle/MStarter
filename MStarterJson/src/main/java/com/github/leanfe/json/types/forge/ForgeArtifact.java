package com.github.leanfe.json.types.forge;

import com.fasterxml.jackson.annotation.JsonProperty;

@lombok.Data
public class ForgeArtifact {
    @lombok.Getter(onMethod_ = {@JsonProperty("path")})
    @lombok.Setter(onMethod_ = {@JsonProperty("path")})
    private String path;
    @lombok.Getter(onMethod_ = {@JsonProperty("url")})
    @lombok.Setter(onMethod_ = {@JsonProperty("url")})
    private String url;
    @lombok.Getter(onMethod_ = {@JsonProperty("sha1")})
    @lombok.Setter(onMethod_ = {@JsonProperty("sha1")})
    private String sha1;
    @lombok.Getter(onMethod_ = {@JsonProperty("size")})
    @lombok.Setter(onMethod_ = {@JsonProperty("size")})
    private long size;
}
