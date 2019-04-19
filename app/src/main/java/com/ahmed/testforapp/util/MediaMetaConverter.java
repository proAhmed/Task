package com.ahmed.testforapp.util;


import com.ahmed.testforapp.model.entity.MediaMetadatum;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

import androidx.room.TypeConverter;

public class MediaMetaConverter {
    private Gson gson = new Gson();

    @TypeConverter
    public List<MediaMetadatum> stringToSomeObjectList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<MediaMetadatum>>() {}.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public String someObjectListToString(List<MediaMetadatum> someObjects) {
        return gson.toJson(someObjects);
    }
}

