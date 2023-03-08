package com.hussain.utils;

import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Test {

    public static void main(String[] args) throws ParseException {

        Date dateBeforeXDays2 = DateUtil.getDateBeforeXDays(new Date(), 90);

//        LocalDate fromDate = DateUtil.stringToLocalDate("12-01-2019");
//        LocalDate toDate = LocalDate.now();
//        System.out.println(toDate.getMonth());
//        System.out.println(ChronoUnit.DAYS.between(fromDate, toDate));


        Date date = DateUtil.parseDate("12-01-2019", DateUtil.DD_MM_YYYY);
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        List<LocalDate> list = new ArrayList<>();
        LocalDate date1 = DateUtil.stringToLocalDate("01-01-2019");
        LocalDate date2 = DateUtil.stringToLocalDate("02-01-2019");
        LocalDate date3 = DateUtil.stringToLocalDate("03-01-2019");
        LocalDate date4 = DateUtil.stringToLocalDate("04-01-2019");
        LocalDate date5 = DateUtil.stringToLocalDate("05-01-2019");
        LocalDate date6 = DateUtil.stringToLocalDate("06-01-2019");
        LocalDate date7 = DateUtil.stringToLocalDate("07-01-2019");
        LocalDate date8 = DateUtil.stringToLocalDate("08-01-2019");
        LocalDate date9 = DateUtil.stringToLocalDate("09-01-2019");
        LocalDate date10 = DateUtil.stringToLocalDate("21-01-2019");
        LocalDate date11 = DateUtil.stringToLocalDate("22-01-2019");
        LocalDate date12 = DateUtil.stringToLocalDate("23-01-2019");
        LocalDate date13 = DateUtil.stringToLocalDate("24-01-2019");
        LocalDate date14 = DateUtil.stringToLocalDate("25-01-2019");
        LocalDate date15 = DateUtil.stringToLocalDate("26-01-2019");
        LocalDate date16 = DateUtil.stringToLocalDate("27-01-2019");
        LocalDate date17 = DateUtil.stringToLocalDate("28-01-2019");
        LocalDate date18 = DateUtil.stringToLocalDate("29-01-2019");
        LocalDate date19 = DateUtil.stringToLocalDate("30-01-2019");
        list.add(date1);
        list.add(date2);
        list.add(date3);
        list.add(date4);
        list.add(date5);
        list.add(date6);
        list.add(date7);
        list.add(date8);
        list.add(date9);
        list.add(date10);
        list.add(date11);
        list.add(date12);
        list.add(date13);
        list.add(date14);
        list.add(date15);
        list.add(date16);
        list.add(date17);
        list.add(date18);
        list.add(date19);

        Date dateBeforeXDays = DateUtil.getDateBeforeXDays(new Date(), 7);
        System.out.println("Date before 7" + dateBeforeXDays);
        List<LocalDate> dateRange = DateUtil.getDateRange(dateBeforeXDays, new Date());

        System.out.println("Date List " + dateRange);
        if (CollectionUtils.isEmpty(dateRange))
            System.out.println("No Data");
        for (LocalDate localDate : dateRange) {

            System.out.println(DateUtil.localDateToString(localDate));
            long count = list.stream().filter(result -> result.isEqual(localDate)).count();
            System.out.println(count);
        }

//		LocalDate startDate = DateUtil.stringToLocalDate("09-01-2019");
//		LocalDate endDate = DateUtil.stringToLocalDate("18-01-2019");

//		DateUtil.getLocalDateFromDate(weekStartDate).isAfter(o.getCreatedOn())
//		long count = list.stream().filter(o -> startDate.isBefore(o)).filter(o -> endDate.isAfter(o)).count();
//		List<LocalDate> collect = list.stream().filter(o -> startDate.isBefore(o)).filter(o -> endDate.isAfter(o))
//				.collect(Collectors.toList());
//		o.getCreatedOn().isBefore(DateUtil.getLocalDateFromDate(weekEndDate))
//		Map<Integer, List<LocalDate>> collect = list.stream()
//				.collect(Collectors.groupingBy(element -> element.getYear()));
//		Set<Entry<Integer, List<LocalDate>>> entrySet = collect.entrySet();
//		long yearcount = 0, weekcount = 0, monthcount = 0;
//		for (Entry<Integer, List<LocalDate>> entry : entrySet) {
//			List<LocalDate> value = entry.getValue();
//			yearcount = value.stream().filter(o -> o.getYear() == entry.getKey()).count();
//			Map<Month, List<LocalDate>> collect1 = value.stream()
//					.collect(Collectors.groupingBy(element -> element.getMonth()));
//			Set<Entry<Month, List<LocalDate>>> entrySet2 = collect1.entrySet();
//			for (Entry<Month, List<LocalDate>> entry1 : entrySet2) {
//				Month month = entry1.getKey();
//				monthcount = value.stream().filter(o -> o.getMonth().equals(month)).count();
//				Map<DayOfWeek, List<LocalDate>> collect2 = value.stream()
//						.collect(Collectors.groupingBy(element -> element.getDayOfWeek()));
//
//				Set<Entry<DayOfWeek, List<LocalDate>>> entrySet3 = collect2.entrySet();
//				for (Entry<DayOfWeek, List<LocalDate>> entry2 : entrySet3) {
//					DayOfWeek week = entry2.getKey();
//					weekcount = value.stream().filter(o -> o.getDayOfWeek().equals(week)).count();
//
//				}
//
//			}
//		}
//		System.out.println("yearCount : " + yearcount);
//		System.out.println("yearCount : " + monthcount);
//		System.out.println("weekcount " + weekcount);

////		int start = c.get(Calendar.WEEK_OF_MONTH);
//		int actualMaximum = c.getActualMaximum(Calendar.WEEK_OF_MONTH);
//		for (int i = 1; i <= actualMaximum; i++) {
//			System.out.println(i);
//		}

//		for (int i = 1; i < 20; i++) {
//			System.out.print("list.add(date" + i + ");");
//		}

//		Calendar calendar = Calendar.getInstance();
//		for (int i = 0; i < 7; i++) {
//			calendar.add(Calendar.DAY_OF_WEEK, 1);
//			System.out.println(calendar.getTime());
//		}
//
//		calendar = Calendar.getInstance();
//		for (int i = 0; i < 7; i++) {
//			calendar.add(Calendar.DAY_OF_WEEK_IN_MONTH, 1);
//			System.out.println(calendar.getTime());
//		}
//
//		Date d1 = new Date();
//		Calendar cl = Calendar.getInstance();
//		cl.setTime(d1);
//
//		System.out.println("today is " + cl.WEEK_OF_YEAR + "week of the year");
//		System.out.println("today is a " + cl.DAY_OF_MONTH + "month of the year");
//		System.out.println("today is a " + cl.WEEK_OF_MONTH + "week of the month");

        int year = 2020;
        Month months = Month.FEBRUARY;
//
        int month = months.getValue();
        YearMonth of = YearMonth.of(year, month);
        System.out.println(of);

        Date parseDate = DateUtil.parseDate(of.toString(), DateUtil.YYYY_MM);

        LocalDate localDateFromDate = DateUtil.getLocalDateFromDate(parseDate);
        System.out.println(localDateFromDate.getDayOfWeek().getValue());
//
        System.out.println(DateUtil.format(parseDate, DateUtil.DD_MM_YYYY));
        Date toDate = DateUtil.getLastDateOfMonth(parseDate);
        System.out.println(DateUtil.getLastDateOfMonth(parseDate));
        long number_of_days = DateUtil.getTotalDaysFromDateDifference(parseDate, toDate);
        System.out.println(number_of_days);
        if (number_of_days == 28)
            System.out.println("4");
        else
            System.out.println("5");

        long weeks, dayss;
        long years = number_of_days / Year.of(year).length();
        weeks = (number_of_days % year) / 7;
        dayss = (number_of_days % year) % 7;
        System.out.println(years + " " + weeks + " " + dayss);

        int daysInYear = Year.of(2016).length();
        System.out.println("daysInYear " + daysInYear);
        Boolean isLeapYear = Year.isLeap(2016);
        System.out.println("isLeapYear " + isLeapYear);


    }
}
