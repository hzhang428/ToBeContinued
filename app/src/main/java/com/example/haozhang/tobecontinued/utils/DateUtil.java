package com.example.haozhang.tobecontinued.utils;

import android.support.annotation.NonNull;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.zip.DataFormatException;

/**
 * Created by haozhang on 3/27/17.
 */

public class DateUtil {

    private static DateFormat dateFormat= new SimpleDateFormat("yyyy MM dd HH:mm", Locale.getDefault());

    public static String dateToString(@NonNull Date date) {
        return dateFormat.format(date);
    }

    public static Date stringToDate(@NonNull String string) {
        try {
            return dateFormat.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
            return Calendar.getInstance().getTime();
        }
    }
}