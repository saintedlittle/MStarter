package com.github.leanfe.json.types.forge;

import com.fasterxml.jackson.annotation.JsonProperty;

@lombok.Data
public class ForgeDownloads {
    @lombok.Getter(onMethod_ = {@JsonProperty("artifact")})
    @lombok.Setter(onMethod_ = {@JsonProperty("artifact")})
    private ForgeArtifact forgeArtifact;
}
