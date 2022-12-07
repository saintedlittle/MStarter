package com.github.leanfe.json.types.forge;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;
import java.util.List;

@lombok.Data
public class ForgeJSON {
    @lombok.Getter(onMethod_ = {@JsonProperty("id")})
    @lombok.Setter(onMethod_ = {@JsonProperty("id")})
    private String id;
    @lombok.Getter(onMethod_ = {@JsonProperty("time")})
    @lombok.Setter(onMethod_ = {@JsonProperty("time")})
    private OffsetDateTime time;
    @lombok.Getter(onMethod_ = {@JsonProperty("releaseTime")})
    @lombok.Setter(onMethod_ = {@JsonProperty("releaseTime")})
    private OffsetDateTime releaseTime;
    @lombok.Getter(onMethod_ = {@JsonProperty("type")})
    @lombok.Setter(onMethod_ = {@JsonProperty("type")})
    private String type;
    @lombok.Getter(onMethod_ = {@JsonProperty("mainClass")})
    @lombok.Setter(onMethod_ = {@JsonProperty("mainClass")})
    private String mainClass;
    @lombok.Getter(onMethod_ = {@JsonProperty("inheritsFrom")})
    @lombok.Setter(onMethod_ = {@JsonProperty("inheritsFrom")})
    private String inheritsFrom;
    @lombok.Getter(onMethod_ = {@JsonProperty("logging")})
    @lombok.Setter(onMethod_ = {@JsonProperty("logging")})
    private ForgeLogging logging;
    @lombok.Getter(onMethod_ = {@JsonProperty("arguments")})
    @lombok.Setter(onMethod_ = {@JsonProperty("arguments")})
    private ForgeArguments forgeArguments;
    @lombok.Getter(onMethod_ = {@JsonProperty("libraries")})
    @lombok.Setter(onMethod_ = {@JsonProperty("libraries")})
    private List<ForgeLibrary> libraries;
}
