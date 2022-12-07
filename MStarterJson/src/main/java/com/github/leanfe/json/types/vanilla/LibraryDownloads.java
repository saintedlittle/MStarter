package com.github.leanfe.json.types.vanilla;

import com.fasterxml.jackson.annotation.JsonProperty;

@lombok.Data
public class LibraryDownloads {
    @lombok.Getter(onMethod_ = {@JsonProperty("artifact")})
    @lombok.Setter(onMethod_ = {@JsonProperty("artifact")})
    private ClientMappingsClass artifact;
    @lombok.Getter(onMethod_ = {@JsonProperty("classifiers")})
    @lombok.Setter(onMethod_ = {@JsonProperty("classifiers")})
    private Classifiers classifiers;
}
