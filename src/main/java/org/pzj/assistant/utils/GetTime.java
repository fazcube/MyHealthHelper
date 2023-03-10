package org.pzj.assistant.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class GetTime {

    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String getNowTime() {
        Date date = new Date();
        return format.format(date);
    }

    public static String getHowManySecond(int second) {
        Calendar c = new GregorianCalendar();
        Date date = new Date();
        c.setTime(date);
        c.add(Calendar.SECOND,second);
        return format.format(c.getTime());
    }

    public static void main(String[] args) {
        System.out.println(getHowManySecond(60 * 10));
    }

}
