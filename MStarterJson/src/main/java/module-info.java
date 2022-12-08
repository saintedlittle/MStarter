module MStarterJson {
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.datatype.jsr310;
    
    requires lombok;

    exports com.github.leanfe.json.types.vanilla;
    exports com.github.leanfe.json.types.forge;

    exports com.github.leanfe.json;
}