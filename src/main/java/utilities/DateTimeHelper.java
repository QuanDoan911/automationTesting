package utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeHelper {
    public static String getCurrentDay(String format) {
        if(format.isEmpty()||format.equals(null)) format = "d/MMM/yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        //get current date time with Date()
        Date date = new Date();
        String dateFormatted= dateFormat.format(date);
        return dateFormatted;
    }

    public static String getDayFarFromCurrent(int numberOfDays, String format){
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
        return dateFormat.format(calendar.getTime());
    }

    public static String getDayFarFromCurrent(int numberOfDays){
        return getDayFarFromCurrent(numberOfDays,"d/MMM/yyyy");
    }
}
