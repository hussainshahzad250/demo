package com.hussain.utils;

import java.time.LocalDate;

public class CalculateBirth {

    public static void main(String[] args) {
        LocalDate dateOfBirth = DateUtil.stringToLocalDate("07-02-1992", DateUtil.DD_MM_YYYY);
        System.out.println("Age " + DateUtil.getAge(dateOfBirth));
    }
}
