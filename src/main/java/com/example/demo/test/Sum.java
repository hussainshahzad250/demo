/*************************************************************************
* 
* SATIN CREDITCARE NETWORK LIMITED CONFIDENTIAL
* __________________
* 
*  [2018] SATIN CREDITCARE NETWORK LIMITED
*  All Rights Reserved.
* 
* NOTICE:  All information contained herein is, and remains the property of SATIN CREDITCARE NETWORK LIMITED, and
* The intellectual and technical concepts contained herein are proprietary to SATIN CREDITCARE NETWORK LIMITED
* and may be covered by India and Foreign Patents, patents in process, and are protected by trade secret or copyright law.
* Dissemination of this information or reproduction of this material is strictly forbidden unless prior written permission
* is obtained from SATIN CREDITCARE NETWORK LIMITED.
*/
package com.example.demo.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.example.demo.utils.DateUtil;

public class Sum {

	public static void main(String[] args) throws ParseException {
//		List<List<String>> weekdates = getNumberOfWeeks(2018, Calendar.DECEMBER);
//		for (List<String> weekDatesLoop : weekdates) {
//			System.out.println("Start day: " + weekDatesLoop.get(0) + " End day: "+weekDatesLoop.get(1));
//		}
//		String stDate = "10-02-2019";
//		Date firstWeekDate = DateUtil.parseDate(stDate, DateUtil.DD_MM_YYYY);
//		LocalDate firstDayOfWeek = DateUtil.getLocalDateFromDate(firstWeekDate);
//		DayOfWeek dayOfWeek2 = firstDayOfWeek.getDayOfWeek();
//
//		String end = "05-03-2019";
//		Date endDate = DateUtil.parseDate(end, DateUtil.DD_MM_YYYY);
//		LocalDate endDt = DateUtil.getLocalDateFromDate(endDate);
//		DayOfWeek endDayOfWeek = endDt.getDayOfWeek();
//
//		LocalDate with = LocalDate.now().with(TemporalAdjusters.previousOrSame(dayOfWeek2));
//		LocalDate with2 = LocalDate.now().with(TemporalAdjusters.nextOrSame(endDayOfWeek));
//		System.out.println(with + " " + with2);

//		System.out.println(getWeekStartDate(DateUtil.parseDate("14-12-2018", DateUtil.DD_MM_YYYY)));

		LocalDate localDateFromDate = DateUtil
				.getLocalDateFromDate(DateUtil.parseDate("14-12-2018", DateUtil.DD_MM_YYYY));
		int year = localDateFromDate.getYear();
		Month month = localDateFromDate.getMonth();
		List<List<String>> numberOfWeeks = getNumberOfWeeksFromDate(year, month.getValue() - 1, localDateFromDate);
		System.out.println(numberOfWeeks);

//		localDateFromDate = DateUtil.getLocalDateFromDate(DateUtil.parseDate("12-01-2019", DateUtil.DD_MM_YYYY));
//		year = localDateFromDate.getYear();
//		month = localDateFromDate.getMonth();
//		
//		List<List<String>> numberOfWeeks2 = getNumberOfWeeks(year, month.getValue() - 1, "12-01-2019");
//		System.out.println(numberOfWeeks2);
//
//		Date weekEndDate = getWeekEndDate(new Date());
//		System.out.println(weekEndDate);
		
		

		/**
		 * 
		 */
//		getwek(DateUtil.parseDate("14-12-2018", DateUtil.DD_MM_YYYY));

	}

//	private static void getwek(Date date) {
//	    Calendar c = Calendar.getInstance();
//	    c.setTime(date);
//	    System.out.println(c.getFirstDayOfWeek());
//	    int i = c.get(Calendar.DAY_OF_WEEK) - c.getFirstDayOfWeek();
//	    c.add(Calendar.DATE, -i - 7);
//	    Date start = c.getTime();
//	    c.add(Calendar.DATE, 6);
//	    Date end = c.getTime();
//	    System.out.println(start + " - " + end);
//		
//	}

	public static  boolean getCurrentWeek(Date date) {
		Date currentWeekStart, currentWeekEnd;

		Calendar currentCalendar = Calendar.getInstance();
		currentCalendar.setFirstDayOfWeek(Calendar.MONDAY);
		while (currentCalendar.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
			currentCalendar.add(Calendar.DATE, -1);// go one day before
		}
		currentWeekStart = currentCalendar.getTime();

		currentCalendar.add(Calendar.DATE, 6); // add 6 days after Monday
		currentWeekEnd = currentCalendar.getTime();

		Calendar targetCalendar = Calendar.getInstance();
		targetCalendar.setFirstDayOfWeek(Calendar.MONDAY);
		targetCalendar.setTime(date);

		Calendar tempCal = Calendar.getInstance();
		tempCal.setTime(currentWeekStart);

		boolean result = false;
		while (!(tempCal.getTime().after(currentWeekEnd))) {
			if (tempCal.get(Calendar.DAY_OF_YEAR) == targetCalendar.get(Calendar.DAY_OF_YEAR)) {
				result = true;
				break;
			}
			tempCal.add(Calendar.DATE, 1);// advance date by 1
		}

		return result;
	}

	public static Date getWeekStartDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		System.out.println();
		while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
			calendar.add(Calendar.DATE, -1);
		}
		return calendar.getTime();
	}

	public static Date getWeekEndDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
			calendar.add(Calendar.DATE, 1);
		}
		calendar.add(Calendar.DATE, -1);
		return calendar.getTime();
	}

	public static List<List<String>> getNumberOfWeeks(int year, int month, String date) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat(DateUtil.DD_MM_YYYY);
		List<List<String>> weekdates = new ArrayList<>();
		List<String> dates = new ArrayList<>();

		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month);
		c.set(Calendar.DAY_OF_MONTH, 1);

		Date parseDate = DateUtil.parseDate(date, DateUtil.DD_MM_YYYY);

		boolean makeweek = true;
		dates.add(format.format(c.getTime()));
		while (c.get(Calendar.MONTH) == month) {
			if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
				if (c.getTime().after(parseDate)) {
					makeweek = false;
				}
				if (makeweek) {
					dates.add(format.format(c.getTime()));
					weekdates.add(dates);
				}
			} else if (c.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
				dates = new ArrayList<>();
				dates.add(format.format(c.getTime()));
			}
			c.add(Calendar.DAY_OF_MONTH, 1);
		}
		if (dates.size() < 2) {

			if (c.getTime().after(parseDate)) {
				makeweek = false;
			}
			if (makeweek) {
				c.add(Calendar.DAY_OF_MONTH, -1);
				dates.add(format.format(c.getTime()));
				weekdates.add(dates);
			}

		}

		return weekdates;
	}

	public static List<List<String>> getNumberOfWeeksFromDate(int year, int month, LocalDate localDateFromDate) {
		SimpleDateFormat format = new SimpleDateFormat(DateUtil.DD_MM_YYYY);
		List<List<String>> weekdates = new ArrayList<>();

		List<String> dates = new ArrayList<>();
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month);
		c.set(Calendar.DAY_OF_MONTH, localDateFromDate.getDayOfMonth());
		dates.add(format.format(c.getTime()));
		while (c.get(Calendar.MONTH) == month) {
			if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
				dates.add(format.format(c.getTime()));
				weekdates.add(dates);
			} else if (c.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
				dates = new ArrayList<>();
				dates.add(format.format(c.getTime()));
			}
			c.add(Calendar.DAY_OF_MONTH, 1);
		}
		if (dates.size() < 2) {
			c.add(Calendar.DAY_OF_MONTH, -1);
			dates.add(format.format(c.getTime()));
			weekdates.add(dates);
		}
		return weekdates;
	}
}
