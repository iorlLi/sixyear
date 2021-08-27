package sc.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateUtil {
    private static String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss sss";
    private static String DATE_FORMAT = "yyyyMMdd";

    static Date TEST_DATE = new Date();

    private static String formatToday() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DEFAULT_FORMAT);
        return simpleDateFormat.format(new Date());
    }

    private static String formatTodayWithPar(String parameter) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern(parameter);
        return simpleDateFormat.format(new Date());
    }

    private static String formatToday(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DEFAULT_FORMAT);
        return simpleDateFormat.format(new Date());
    }

    private static String formatTodayWithPar(Date date, String parameter) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern(parameter);
        return simpleDateFormat.format(date);
    }

    public static void main(String[] args) {
        System.out.println(formatToday());
        System.out.println(formatTodayWithPar(DATE_FORMAT));
        System.out.println(formatToday(TEST_DATE));
        try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println(formatToday(TEST_DATE));
    }
}
