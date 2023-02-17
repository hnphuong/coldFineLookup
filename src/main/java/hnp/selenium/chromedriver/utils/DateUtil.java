package hnp.selenium.chromedriver.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateUtil {
    private static DateFormat dateFormatter = new SimpleDateFormat("HH:mm, dd/MM/yyyy");

    public static Date stringToDate(String dateString) {
        try {
            return dateFormatter.parse(dateString);
        } catch (Exception ex) {
            return null;
        }
    }

    public static Long stringToLong(String dateString) {
        try {
            return dateFormatter.parse(dateString).getTime();
        } catch (Exception ex) {
            return 0L;
        }
    }
}
