module MStarterJson {
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.datatype.jsr310;
    
    requires lombok;

    requires MStarterAPI;

    exports com.github.leanfe.json;
}