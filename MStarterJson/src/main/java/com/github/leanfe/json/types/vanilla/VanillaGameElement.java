package com.github.leanfe.json.types.vanilla;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;

@JsonDeserialize(using = com.github.leanfe.json.types.vanilla.VanillaGameElement.Deserializer.class)
@JsonSerialize(using = com.github.leanfe.json.types.vanilla.VanillaGameElement.Serializer.class)
public class VanillaGameElement {
    public VanillaGameClass gameClassValue;
    public String stringValue;

    static class Deserializer extends JsonDeserializer<VanillaGameElement> {
        @Override
        public VanillaGameElement deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            VanillaGameElement value = new VanillaGameElement();
            switch (jsonParser.currentToken()) {
                case VALUE_STRING -> value.stringValue = jsonParser.readValueAs(String.class);
                case START_OBJECT -> value.gameClassValue = jsonParser.readValueAs(VanillaGameClass.class);
                default -> throw new IOException("Cannot deserialize GameElement");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<VanillaGameElement> {
        @Override
        public void serialize(VanillaGameElement obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.gameClassValue != null) {
                jsonGenerator.writeObject(obj.gameClassValue);
                return;
            }
            if (obj.stringValue != null) {
                jsonGenerator.writeObject(obj.stringValue);
                return;
            }
            throw new IOException("GameElement must not be null");
        }
    }
}
