package com.ahmed.testforapp.util.convertor;

import com.ahmed.testforapp.model.entity.Medium;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

import androidx.room.TypeConverter;

public class MediaConverter {
    private Gson gson = new Gson();

    @TypeConverter
    public List<Medium> stringToSomeObjectList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<Medium>>() {}.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public String someObjectListToString(List<Medium> someObjects) {
        return gson.toJson(someObjects);
    }
}

