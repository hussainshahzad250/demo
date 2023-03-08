package com.hussain.utils;

import org.springframework.util.StringUtils;

import java.math.BigDecimal;

public class Utils {

    public static int parseToInteger(String value, int defValue) {
        if (!StringUtils.isEmpty(value)) {
            try {
                return Integer.parseInt(value);
            } catch (NumberFormatException exception) {
                // log.error("Error parsing string to integer.", exception);
            }
        }
        return defValue;
    }

    public static long parseToLong(String value, long defValue) {
        if (!StringUtils.isEmpty(value)) {
            try {
                return Long.parseLong(value);
            } catch (NumberFormatException exception) {
                // log.error("Error parsing string to integer.", exception);
            }
        }
        return defValue;
    }

    public static float parseToFloat(String value, float defValue) {
        if (!StringUtils.isEmpty(value)) {
            try {
                return Float.parseFloat(value);
            } catch (NumberFormatException exception) {
                // log.error("Error parsing string to integer.", exception);
            }
        }
        return defValue;
    }

    public static double parseToDouble(String value, double defValue) {
        if (!StringUtils.isEmpty(value)) {
            try {
                return Double.parseDouble(value);
            } catch (NumberFormatException exception) {
                // log.getlog().("Error parsing string to integer.", exception);
            }
        }
        return defValue;
    }

    public static BigDecimal parseToBigDecimal(String value, BigDecimal defValue) {
        if (!StringUtils.isEmpty(value)) {
            try {
                return new BigDecimal(value);
            } catch (NumberFormatException exception) {
                // log.error("Error parsing string to integer.", exception);
            }
        }
        return defValue;
    }

    public static double roundNumber(double number, int decimalPoint) {
        try {
            if (decimalPoint < 0) {
                return 0.00d;
            }
            long multiplier = (long) Math.pow(10, decimalPoint);
            double mulNumber = number * multiplier;

            // get fraction of the rounded digit
            int fraction = (int) ((mulNumber * 10) % 10);
            // add fraction value in existing number if greater than 5
            mulNumber += fraction >= 5 ? 1 : 0;
            // round the number in integer value

            double roundedNumber = (long) mulNumber;
            return roundedNumber / multiplier;
        } catch (Exception e) {
            e.printStackTrace();
            return 0.00d;
        }
    }


    public static double truncateNumber(double number, int decimalPoint) {
        try {
            if (decimalPoint < 0)
                return 0.00d;
            long multiplier = (long) Math.pow(10, decimalPoint);
            double mulNumber = number * multiplier;
            double roundedNumber = (long) mulNumber;
            return roundedNumber / multiplier;
        } catch (Exception e) {
            e.printStackTrace();
            return 0.00d;
        }
    }

    public static boolean parseIntToBoolean(int value, boolean defValue) {
        try {
            switch (value) {
                case 0:
                    return false;
                case 1:
                    return true;
            }
            return defValue;
        } catch (Exception e) {
            e.printStackTrace();
            return defValue;
        }
    }

}
