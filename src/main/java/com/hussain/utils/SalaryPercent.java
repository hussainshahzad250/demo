package com.hussain.utils;

import java.text.DateFormat;
import java.util.Date;

public class SalaryPercent {

    public static void main(String[] args) {

        int salary = 38000;
        System.out.println("salary " + salary);
        System.out.println("Min-Sal ==> " + salaryMin(salary) + " & " + "Max-Sal ==> " + salaryMax(salary));
        Date dateAfterXDays = DateUtil.getDateAfterXDays(new Date(), 5);
        System.out.println(DateUtil.format(dateAfterXDays, DateUtil.DD_MM_YYYY));

        Date date = new Date();
        String stringDate = DateFormat.getDateTimeInstance().format(date);
        System.out.println(stringDate);

    }

    private static int salaryMin(int salary) {
        return salary - salary * 10 / 100;
    }

    private static int salaryMax(int salary) {
        return salary + salary * 10 / 100;
    }
}
