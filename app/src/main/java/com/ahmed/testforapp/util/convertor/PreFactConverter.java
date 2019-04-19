package com.ahmed.testforapp.util.convertor;

import java.util.ArrayList;
import java.util.List;

import androidx.room.TypeConverter;

public class PreFactConverter {
    @TypeConverter
    public PreFact getPreFact(String genreIds) {
        List<String> list = new ArrayList<>();
        String[] array = genreIds.split(",");
        for (String s : array) {
            if (!s.isEmpty()) {
                list.add(s);
            }
        }
        return new PreFact(list);
    }

    @TypeConverter
    public String writingPreFact(PreFact list) {
        StringBuilder genreIds = new StringBuilder();
        for (String i : list.getOrgFact()) {
            genreIds.append(",").append(i);
        }
        return genreIds.toString();
    }
}

