package com.github.leanfe.json.types.vanilla;


import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(using = VanillaJVMElement.Deserializer.class)
@JsonSerialize(using = VanillaJVMElement.Serializer.class)
public class VanillaJVMElement {
    public VanillaJVMClass jvmClassValue;
    public String stringValue;

    static class Deserializer extends JsonDeserializer<VanillaJVMElement> {
        @Override
        public VanillaJVMElement deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            VanillaJVMElement value = new VanillaJVMElement();
            switch (jsonParser.currentToken()) {
                case VALUE_STRING -> value.stringValue = jsonParser.readValueAs(String.class);
                case START_OBJECT -> value.jvmClassValue = jsonParser.readValueAs(VanillaJVMClass.class);
                default -> throw new IOException("Cannot deserialize JVMElement");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<VanillaJVMElement> {
        @Override
        public void serialize(VanillaJVMElement obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.jvmClassValue != null) {
                jsonGenerator.writeObject(obj.jvmClassValue);
                return;
            }
            if (obj.stringValue != null) {
                jsonGenerator.writeObject(obj.stringValue);
                return;
            }
            throw new IOException("JVMElement must not be null");
        }
    }
}

