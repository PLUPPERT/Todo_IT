package org.pluppert.serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

public class CustomSerializer implements JsonSerializer<Object>{
    public JsonElement serialize(Object someObject, Type type, JsonSerializationContext jsonSerializationContext) {
        return null;
    }
}
