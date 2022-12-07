package com.github.leanfe.json.types.vanilla;

import java.io.IOException;
import java.io.IOException;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import com.fasterxml.jackson.core.type.*;
import java.util.List;

@JsonDeserialize(using = VanillaValue.Deserializer.class)
@JsonSerialize(using = VanillaValue.Serializer.class)
public class VanillaValue {
    public List<String> stringArrayValue;
    public String stringValue;

    static class Deserializer extends JsonDeserializer<VanillaValue> {
        @Override
        public VanillaValue deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            VanillaValue value = new VanillaValue();
            switch (jsonParser.currentToken()) {
                case VALUE_STRING -> value.stringValue = jsonParser.readValueAs(String.class);
                case START_ARRAY -> value.stringArrayValue = jsonParser.readValueAs(new TypeReference<List<String>>() {
                });
                default -> throw new IOException("Cannot deserialize Value");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<VanillaValue> {
        @Override
        public void serialize(VanillaValue obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.stringArrayValue != null) {
                jsonGenerator.writeObject(obj.stringArrayValue);
                return;
            }
            if (obj.stringValue != null) {
                jsonGenerator.writeObject(obj.stringValue);
                return;
            }
            throw new IOException("Value must not be null");
        }
    }
}

