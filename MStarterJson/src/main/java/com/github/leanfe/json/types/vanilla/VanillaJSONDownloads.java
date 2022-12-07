package com.github.leanfe.json.types.vanilla;

import com.fasterxml.jackson.annotation.JsonProperty;

@lombok.Data
public class VanillaJSONDownloads {
    @lombok.Getter(onMethod_ = {@JsonProperty("client")})
    @lombok.Setter(onMethod_ = {@JsonProperty("client")})
    private ClientMappingsClass client;
    @lombok.Getter(onMethod_ = {@JsonProperty("client_mappings")})
    @lombok.Setter(onMethod_ = {@JsonProperty("client_mappings")})
    private ClientMappingsClass clientMappings;
    @lombok.Getter(onMethod_ = {@JsonProperty("server")})
    @lombok.Setter(onMethod_ = {@JsonProperty("server")})
    private ClientMappingsClass server;
    @lombok.Getter(onMethod_ = {@JsonProperty("server_mappings")})
    @lombok.Setter(onMethod_ = {@JsonProperty("server_mappings")})
    private ClientMappingsClass serverMappings;
}
