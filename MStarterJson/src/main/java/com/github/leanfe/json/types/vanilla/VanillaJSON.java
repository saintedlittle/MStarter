package com.github.leanfe.json.types.vanilla;

import com.fasterxml.jackson.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;

@lombok.Data
public class VanillaJSON {
    @lombok.Getter(onMethod_ = {@JsonProperty("arguments")})
    @lombok.Setter(onMethod_ = {@JsonProperty("arguments")})
    private VanillaArguments arguments;
    @lombok.Getter(onMethod_ = {@JsonProperty("assetIndex")})
    @lombok.Setter(onMethod_ = {@JsonProperty("assetIndex")})
    private AssetIndex assetIndex;
    @lombok.Getter(onMethod_ = {@JsonProperty("assets")})
    @lombok.Setter(onMethod_ = {@JsonProperty("assets")})
    private String assets;
    @lombok.Getter(onMethod_ = {@JsonProperty("complianceLevel")})
    @lombok.Setter(onMethod_ = {@JsonProperty("complianceLevel")})
    private long complianceLevel;
    @lombok.Getter(onMethod_ = {@JsonProperty("downloads")})
    @lombok.Setter(onMethod_ = {@JsonProperty("downloads")})
    private VanillaJSONDownloads downloads;
    @lombok.Getter(onMethod_ = {@JsonProperty("id")})
    @lombok.Setter(onMethod_ = {@JsonProperty("id")})
    private String id;
    @lombok.Getter(onMethod_ = {@JsonProperty("javaVersion")})
    @lombok.Setter(onMethod_ = {@JsonProperty("javaVersion")})
    private JavaVersion javaVersion;
    @lombok.Getter(onMethod_ = {@JsonProperty("libraries")})
    @lombok.Setter(onMethod_ = {@JsonProperty("libraries")})
    private List<Library> libraries;
    @lombok.Getter(onMethod_ = {@JsonProperty("logging")})
    @lombok.Setter(onMethod_ = {@JsonProperty("logging")})
    private Logging logging;
    @lombok.Getter(onMethod_ = {@JsonProperty("mainClass")})
    @lombok.Setter(onMethod_ = {@JsonProperty("mainClass")})
    private String mainClass;
    @lombok.Getter(onMethod_ = {@JsonProperty("minimumLauncherVersion")})
    @lombok.Setter(onMethod_ = {@JsonProperty("minimumLauncherVersion")})
    private long minimumLauncherVersion;
    @lombok.Getter(onMethod_ = {@JsonProperty("releaseTime")})
    @lombok.Setter(onMethod_ = {@JsonProperty("releaseTime")})
    private OffsetDateTime releaseTime;
    @lombok.Getter(onMethod_ = {@JsonProperty("time")})
    @lombok.Setter(onMethod_ = {@JsonProperty("time")})
    private OffsetDateTime time;
    @lombok.Getter(onMethod_ = {@JsonProperty("type")})
    @lombok.Setter(onMethod_ = {@JsonProperty("type")})
    private String type;
}