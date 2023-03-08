package com.hussain.utils;

import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static java.time.temporal.TemporalAdjusters.firstDayOfYear;

public class DateUtil {

    public static final String HH_MM = "HH:mm";
    public static final String YYYY_MM = "yyyy-MM";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String DD_MM_YYYY = "dd-MM-yyyy";

    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String DD_MM_YYYY_HH_MM_SS = "dd-MM-yyyy HH:mm:ss";

    public static Date parseDate(String date, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setLenient(false);
        return sdf.parse(date);
    }

    public static String format(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static Date getDateFromMillis(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }

    public static Date getDateBeforeXDays(Date date, String pattern, int dateBeforeXDays) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, -dateBeforeXDays);
        return sdf.parse(sdf.format(c.getTime()));
    }

    public static int periodDifferenceInMonths(String startDate, String endDate) {
        Period between = Period.between(LocalDate.parse(startDate), LocalDate.parse(endDate));
        return between.getMonths();
    }

    public static long localDateDifferenceInMonths(String startDate, String endDate) {
        return ChronoUnit.MONTHS.between(LocalDate.parse(startDate), LocalDate.parse(endDate));
    }

    public static long localDateDifferenceInMonths(LocalDate startDate, LocalDate endDate) {
        return ChronoUnit.MONTHS.between(startDate, endDate);
    }

    public static Date getLocalDateToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDate getLocalDateFromDate(Date date) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault()).toLocalDate();
    }

    public static LocalDate getFirstDayOfNextMonth(LocalDate localDate) {
        return localDate.with(TemporalAdjusters.firstDayOfNextMonth());
    }

    public static LocalDate getFirstDayOfMonth(LocalDate localDate) {
        return localDate.with(TemporalAdjusters.firstDayOfMonth());
    }

    public static Date getNextMonthFirstDayFromDate(Date date) {
        LocalDate dateToLocalDate = getLocalDateFromDate(date);
        LocalDate firstDayOfNextMonth = getFirstDayOfNextMonth(dateToLocalDate);
        return getLocalDateToDate(firstDayOfNextMonth);
    }

    public static Date getLastDateOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DATE, -1);
        Date lastDayOfMonth = calendar.getTime();
        return lastDayOfMonth;
    }

    public static List<LocalDate> getDateRange(String startDate, String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        List<LocalDate> totalDates = new ArrayList<>();
        while (!start.isAfter(end)) {
            totalDates.add(start);
            start = start.plusDays(1);
        }
        return totalDates;
    }

    public static Date instantToDate(Instant instant) {
        return Date.from(instant);
    }

    public static String getDateFromInstant(Instant instantDate, String format) {
        LocalDateTime datetime = LocalDateTime.ofInstant(instantDate, ZoneOffset.UTC);
        return DateTimeFormatter.ofPattern(format).format(datetime);
    }

    public static long daysBetweenDates(Date d1, Date d2) {
        Instant instant1 = d1.toInstant();
        Instant instant2 = d2.toInstant();
        return ChronoUnit.DAYS.between(instant1, instant2);
    }

    public static List<LocalDate> getDateRange(Date startDate, Date endDate) {
        System.out.println("From " + startDate + "\nToDate" + endDate);
        LocalDate start = getLocalDateFromDate(startDate);
        LocalDate end = getLocalDateFromDate(endDate);
        List<LocalDate> totalDates = new ArrayList<>();
        while (!start.isAfter(end)) {
            totalDates.add(start);
            start = start.plusDays(1);
        }
        return totalDates;
    }

    public static Date getDateBeforeXDays(Date date, int numberOfDays) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, -numberOfDays);
        return c.getTime();
    }

    public static Date getDateAfterXDays(Date date, int numberOfDays) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, numberOfDays);
        return c.getTime();
    }

    public static int periodDifference(String startDate, String endDate) {
        return Period.between(LocalDate.parse(startDate), LocalDate.parse(endDate)).getMonths();
    }

    public static long localDateDifference(String startDate, String endDate) {
        return ChronoUnit.MONTHS.between(LocalDate.parse(startDate), LocalDate.parse(endDate));
    }

    public static long localDateDifference(LocalDate startDate, LocalDate endDate) {
        return ChronoUnit.MONTHS.between(startDate, endDate);
    }

    public static Date localDateToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static Date getDateFromInstant(Instant instant) {
        return Date.from(instant);
    }

    public static LocalDate getLocalDateFromInstant(Instant instant) {
        return getLocalDateFromDate(Date.from(instant));
    }

    public static String getDateStringFromInstant(Instant instantDate, String format) {
        LocalDateTime datetime = LocalDateTime.ofInstant(instantDate, ZoneOffset.UTC);
        return DateTimeFormatter.ofPattern(format).format(datetime);
    }

    public static Instant getInstantFromString(String date, String format) throws ParseException {
        return parseDate(date, format).toInstant();
    }

    public static Instant getInstantFromLocalDate(LocalDate date) {
        return Instant.from(date);
    }

    public static LocalDate getNextMonth(LocalDate localDate) {
        if (localDate == null)
            return null;
        return localDate.plusMonths(1);
    }

    public static long getTotalDaysFromDateDifference(Date fromDate, Date toDate) {
        return ChronoUnit.DAYS.between(getLocalDateFromDate(fromDate), getLocalDateFromDate(toDate)) + 1;
    }

    public static LocalDate stringToLocalDate(String date) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DD_MM_YYYY);
        return StringUtils.hasText(date) ? LocalDate.parse(date, dtf) : null;
    }

    public static LocalDate stringToLocalDate(String date, String format) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
        return StringUtils.hasText(date) ? LocalDate.parse(date, dtf) : null;
    }

    public static String localDateToString(LocalDate localDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DD_MM_YYYY);
        return localDate != null ? localDate.format(formatter) : null;
    }

    public static String localDateToString(LocalDate localDate, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return localDate != null ? localDate.format(formatter) : null;
    }

    public static LocalDate getFirstDayOfYear(LocalDate localDate) {
        return localDate.with(firstDayOfYear());
    }

    public static int getAge(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
}
