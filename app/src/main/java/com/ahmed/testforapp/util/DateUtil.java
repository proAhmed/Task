package com.ahmed.testforapp.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

    public static String convertDate(String inputDate){
        Date parsed;
        String outputDate;
         String inputFormat = "yyyy-MM-dd";
        String outputFormat = "dd-MMM-yyyy";
        SimpleDateFormat df_input = new SimpleDateFormat(inputFormat, Locale.getDefault());
        SimpleDateFormat df_output = new SimpleDateFormat(outputFormat, Locale.getDefault());
        try {
            parsed = df_input.parse(inputDate);
            outputDate = df_output.format(parsed);
        } catch (Exception e) {
            return inputDate;
         }
        return outputDate;
    }
}
