package com.wenqi.demo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
 
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:dd");
        Calendar date = Calendar.getInstance();
        date.set(Calendar.DATE, date.get(Calendar.DATE) - 1);
        String lastDay = sdf.format(date.getTime()) + " 08:00:00";
        System.out.println(lastDay);
    }

    /**
     * 获取昨天早上8点的时间
     * @return
     */
    public static Date getYesterday8() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        Calendar date = Calendar.getInstance();
        date.set(Calendar.DATE, date.get(Calendar.DATE) - 1);

        String lastDay = sdf.format(date.getTime()) + " 08:00:00";
        System.out.print(sdf2.parse(lastDay));
        return sdf2.parse(lastDay);
    }

    /**
     * 获取昨天下午6点的时间
     * @return
     */
    public static Date getYesterday16() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        Calendar date = Calendar.getInstance();
        date.set(Calendar.DATE, date.get(Calendar.DATE) - 1);
        String lastDay = sdf.format(date.getTime()) + " 18:00:00";

        return sdf2.parse(lastDay);
    }
    /**
     * 获取昨天的日期
     * @return
     */
    public static Date getYesterday() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:dd");
        Calendar date = Calendar.getInstance();
        date.set(Calendar.DATE, date.get(Calendar.DATE) - 1);
        String lastDay = sdf.format(date.getTime());

        return sdf.parse(lastDay);
    }
}