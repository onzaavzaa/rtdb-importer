package com.pch.firebase.demo.firebasedemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TestMain {

    public static void main(String[] args) throws ParseException {

        System.out.println("Hello World");
        String testStrDT = "Sat Mar 14 2020 08:41:43 GMT+0700 (Indochina Time)"; //Sat Mar 14 2020 15:41:50 GMT+0000 (UTC)
        String strTimezone = testStrDT.substring(testStrDT.indexOf("+")-2, testStrDT.indexOf("+"));

        if(!strTimezone.contains(" ") ){
            testStrDT = testStrDT.replace("+", " +");
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE MMM d yyyy HH:mm:ss z Z (zzzz)");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

        Date dd = simpleDateFormat.parse(testStrDT);

        System.out.println(dd);
        System.out.println(simpleDateFormat.format(new Date()));
    }
}
