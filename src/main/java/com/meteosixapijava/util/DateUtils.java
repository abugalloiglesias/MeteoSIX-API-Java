package com.meteosixapijava.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils {

    public static String formatDateInGaliciaTimeZone(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+1"));

        return dateFormat.format(date);
    }
}
