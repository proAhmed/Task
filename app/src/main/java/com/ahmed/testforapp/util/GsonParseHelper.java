package com.ahmed.testforapp.util;


import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GsonParseHelper implements JsonSerializer<List<String>>,
        JsonDeserializer<List<String>> {

    @Override
    public JsonElement serialize(List<String> list, Type t,
                                 JsonSerializationContext jsc) {
        if (list.size() == 1) {
            return jsc.serialize(list.get(0));
        } else {
            return jsc.serialize(list);
        }
    }

    @Override
    public List<String> deserialize(JsonElement json, Type typeOfT,
                                    JsonDeserializationContext jsc)
            throws JsonParseException {
        List<String> result;

        if (json.isJsonArray()) {
            result = jsc.deserialize(json, typeOfT);
        } else {
            result = new ArrayList<>();
            result.add((String) jsc.deserialize(json, String.class));
        }
        return result;
    }
}