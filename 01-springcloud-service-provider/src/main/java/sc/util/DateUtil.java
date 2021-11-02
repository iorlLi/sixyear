package sc.util;

import com.google.common.collect.Lists;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

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
        String str = "head";
        List<String> list = Lists.newArrayList();
        for (int i = 0; i < 5; i++) {
            add(list, "a" + i);
            str = add(str);
        }
        System.out.println(list);
        System.out.println(str);
    }

    private static String add(String src){
        return src.concat("a");
    }
    private static void add(List<String> list, String add) {
        list.add(add);
    }

    static String getLast(LocalDate localDate) {
        if (localDate == null) {
            localDate = LocalDate.now();
        }
        int year = localDate.getYear();
        int month = localDate.getMonth().getValue();
        switch (month) {
            case 1:
            case 2:
            case 3:
                int lastYear = year - 1;
                return lastYear + "-12-30";
            case 4:
            case 5:
            case 6:
                return year + "-03-31";
            case 7:
            case 8:
            case 9:
                return year + "-06-30";
            case 10:
            case 11:
            case 12:
                return year + "-09-30";
        }
        return "";
    }
}
