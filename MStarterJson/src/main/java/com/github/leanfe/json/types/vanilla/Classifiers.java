package com.github.leanfe.json.types.vanilla;

import com.fasterxml.jackson.annotation.JsonProperty;

@lombok.Data
public class Classifiers {
    @lombok.Getter(onMethod_ = {@JsonProperty("natives-macos")})
    @lombok.Setter(onMethod_ = {@JsonProperty("natives-macos")})
    private ClientMappingsClass nativesMacos;
    @lombok.Getter(onMethod_ = {@JsonProperty("natives-linux")})
    @lombok.Setter(onMethod_ = {@JsonProperty("natives-linux")})
    private ClientMappingsClass nativesLinux;
    @lombok.Getter(onMethod_ = {@JsonProperty("natives-windows")})
    @lombok.Setter(onMethod_ = {@JsonProperty("natives-windows")})
    private ClientMappingsClass nativesWindows;
    @lombok.Getter(onMethod_ = {@JsonProperty("natives-osx")})
    @lombok.Setter(onMethod_ = {@JsonProperty("natives-osx")})
    private ClientMappingsClass nativesOsx;
}
