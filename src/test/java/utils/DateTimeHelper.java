package utils;

import common.Constants;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateTimeHelper {
    public static String getCurrentDay(String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        //get current date time with Date()
        Date date = new Date();
        String dateFormatted = dateFormat.format(date);
        return dateFormatted;
    }

    public static String getDayFarFromCurrent(int numberOfDays, String format) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
        return convertDateFormat(calendar.getTime(),format);
    }

    public static String getDayFarFromCurrent(int numberOfDays) {
        return getDayFarFromCurrent(numberOfDays, Constants.DEFAULT_FORMAT);
    }

    public static String convertDateFormat(Date date, String format) {
        DateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }
}