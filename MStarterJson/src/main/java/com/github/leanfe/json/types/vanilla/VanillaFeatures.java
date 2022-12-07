package com.github.leanfe.json.types.vanilla;

import com.fasterxml.jackson.annotation.*;

@lombok.Data
public class VanillaFeatures {
    @lombok.Getter(onMethod_ = {@JsonProperty("is_demo_user")})
    @lombok.Setter(onMethod_ = {@JsonProperty("is_demo_user")})
    private Boolean isDemoUser;
    @lombok.Getter(onMethod_ = {@JsonProperty("has_custom_resolution")})
    @lombok.Setter(onMethod_ = {@JsonProperty("has_custom_resolution")})
    private Boolean hasCustomResolution;
}

