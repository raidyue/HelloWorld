package com.raidyue.datedemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yuexiaodong on 16/6/28.
 */
public class DateTest {
    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
        Date now = new Date();
        try {
            Date old = format.parse("2016-06-10 10:11:50");
            long dayInterval = (now.getTime() - old.getTime()) / (24 * 60 * 60 * 1000);
            System.out.println(dayInterval);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
