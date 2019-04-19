package com.ahmed.testforapp.util.convertor;

import java.util.ArrayList;
import java.util.List;

import androidx.room.TypeConverter;

public class OrgFactConverter {

    @TypeConverter
    public OrgFact getOrgFact(String genreIds) {
        List<String> list = new ArrayList<>();
        String[] array = genreIds.split(",");
        for (String s : array) {
            if (!s.isEmpty()) {
                list.add(s);
            }
        }
        return new OrgFact(list);
    }

    @TypeConverter
    public String writingDesFact(OrgFact orgFact) {
        StringBuilder genreIds = new StringBuilder();
        for (String i : orgFact.getOrgFact()) {
            genreIds.append(",").append(i);
        }
        return genreIds.toString();
    }


}

