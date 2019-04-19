package com.ahmed.testforapp.util.convertor;

import java.util.ArrayList;
import java.util.List;

import androidx.room.TypeConverter;

public class DesFactConverter {
    @TypeConverter
    public DesFact getDesFact(String genreIds) {
        List<String> list = new ArrayList<>();
        String[] array = genreIds.split(",");
        for (String s : array) {
            if (!s.isEmpty()) {
                list.add(s);
            }
        }
        return new DesFact(list);
    }

    @TypeConverter
    public String writingDesFact(DesFact desFact) {
        StringBuilder genreIds = new StringBuilder();
        for (String i : desFact.getDesFact()) {
            genreIds.append(",").append(i);
        }
        return genreIds.toString();
    }
}

