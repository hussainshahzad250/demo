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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.example.demo.utils.DateUtil;

public class GetWeekData {

	public static void main(String[] args) throws ParseException {
		String startDate = "01-03-2019";
		String endDate = "31-03-2019";

//		List<List<String>> makeWeekDataFromMondatToSunday = makeWeekDataFromMondatToSunday(
//				DateUtil.getLocalDateFromDate(DateUtil.parseDate(startDate, DateUtil.DD_MM_YYYY)),
//				DateUtil.parseDate(endDate, DateUtil.DD_MM_YYYY));
//		System.out.println(makeWeekDataFromMondatToSunday);

		makeWeek(new Date());

	}

	private static void makeWeek(Date date) throws ParseException {
		int fromWeek = 1;
		int totalweeks = 5;
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		List<String> dates = new ArrayList<>();
		LocalDate localDateFromDate = DateUtil.getLocalDateFromDate(date);
		for (int i = fromWeek; i <= totalweeks; i++) {
			Calendar c = Calendar.getInstance();
			c.set(Calendar.YEAR, localDateFromDate.getYear());
			c.set(Calendar.MONTH, localDateFromDate.getMonthValue() - 1);
			c.set(Calendar.DAY_OF_MONTH, localDateFromDate.getDayOfMonth());
			dates.add(df.format(c.getTime()));
			System.out.print("Week no. " + i + " start from " + df.format(c.getTime()) + " to ");
			date = c.getTime();
			c.add(Calendar.DAY_OF_YEAR, 6);
			Date weekEndDate = c.getTime();
			System.out.println(("End Date " + df.format(weekEndDate)));

			localDateFromDate = DateUtil.getLocalDateFromDate(weekEndDate).plusDays(1);
			c.add(Calendar.DAY_OF_MONTH, localDateFromDate.getDayOfMonth());
		}
		System.out.println("done");
	}

	private static List<List<String>> makeWeekDataFromMondatToSunday(LocalDate date, Date parseDate) {
		SimpleDateFormat format = new SimpleDateFormat(DateUtil.DD_MM_YYYY);
		List<List<String>> weekdates = new ArrayList<>();
		System.out.println(date.getMonth().getValue());
		int month = date.getMonth().getValue() - 1;

		List<String> dates = new ArrayList<>();
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, date.getYear());
		c.set(Calendar.MONTH, month);
		c.set(Calendar.DAY_OF_MONTH, date.getDayOfMonth());
		dates.add(format.format(c.getTime()));
		while (c.getTime().before(parseDate) || DateUtil.format(c.getTime(), DateUtil.DD_MM_YYYY)
				.equals(DateUtil.format(parseDate, DateUtil.DD_MM_YYYY))) {
			if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
				dates.add(format.format(c.getTime()));
				weekdates.add(dates);
			} else if (c.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
				dates = new ArrayList<>();
				dates.add(format.format(c.getTime()));
			} else if (DateUtil.format(c.getTime(), DateUtil.DD_MM_YYYY)
					.equals(DateUtil.format(parseDate, DateUtil.DD_MM_YYYY))) {
				dates.add(format.format(parseDate));
				weekdates.add(dates);
			}
			c.add(Calendar.DAY_OF_MONTH, 1);
		}
		return weekdates;
	}

}
