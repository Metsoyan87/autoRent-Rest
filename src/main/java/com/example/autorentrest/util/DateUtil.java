package com.example.autorentrest.util;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DateUtil {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public Date textToDate(String date) throws ParseException {
        if (date == null) {
            return null;
        }
        return sdf.parse(date);
    }

    public String dateToText(Date date) {
        return sdf.format(date);
    }

}
