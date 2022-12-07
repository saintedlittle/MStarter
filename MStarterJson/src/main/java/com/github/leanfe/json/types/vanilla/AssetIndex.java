package com.github.leanfe.json.types.vanilla;

import com.fasterxml.jackson.annotation.JsonProperty;

@lombok.Data
public class AssetIndex {
    @lombok.Getter(onMethod_ = {@JsonProperty("id")})
    @lombok.Setter(onMethod_ = {@JsonProperty("id")})
    private String id;
    @lombok.Getter(onMethod_ = {@JsonProperty("sha1")})
    @lombok.Setter(onMethod_ = {@JsonProperty("sha1")})
    private String sha1;
    @lombok.Getter(onMethod_ = {@JsonProperty("size")})
    @lombok.Setter(onMethod_ = {@JsonProperty("size")})
    private long size;
    @lombok.Getter(onMethod_ = {@JsonProperty("totalSize")})
    @lombok.Setter(onMethod_ = {@JsonProperty("totalSize")})
    private Long totalSize;
    @lombok.Getter(onMethod_ = {@JsonProperty("url")})
    @lombok.Setter(onMethod_ = {@JsonProperty("url")})
    private String url;
}
