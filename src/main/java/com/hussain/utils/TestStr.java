package com.hussain.utils;

import java.time.*;
import java.util.Scanner;

public class TestStr {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter No of Token to consider");
        int nextInt = sc.nextInt();
        System.out.println(getCeilValue(nextInt).intValue());


    }

    private static Double getCeilValue(int tokens) {
        double token = tokens * 2 / 3;
        return Math.ceil(token);

    }

    public void hello() {
        LocalDate zeroEmiDt = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth().plus(1), 24);
        int days = Period.between(LocalDate.now(), zeroEmiDt).getDays();
        System.out.println("Days " + days);
    }

    private static void dateCal() {
        // Get the current date and time
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("Current DateTime: " + currentTime);

        LocalDate date1 = currentTime.toLocalDate();
        System.out.println("Current LocalDate: " + date1);

        Month month = currentTime.getMonth();
        int day = currentTime.getDayOfMonth();
        int seconds = currentTime.getSecond();

        System.out.println("Month: " + month + "\nday: " + day + "\nseconds: " + seconds);

        LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
        System.out.println("date2: " + date2);

        // 12 december 2014
        LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
        System.out.println("date3: " + date3);

        // 22 hour 15 minutes
        LocalTime date4 = LocalTime.of(22, 15);
        System.out.println("Date and Time: " + date4);

        // parse a string
        LocalTime date5 = LocalTime.parse("20:15:30");
        System.out.println("Parse Time: " + date5);
    }
}
