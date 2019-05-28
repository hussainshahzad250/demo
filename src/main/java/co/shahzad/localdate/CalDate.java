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
/**
 * 
 */
package co.shahzad.localdate;

import static java.time.temporal.TemporalAdjusters.firstDayOfYear;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Date;

import com.example.demo.utils.ConstructDate;

import hussain.shahzad.java.DateUtil;

/**
 * @author shahzad.hussain
 *
 */
public class CalDate {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
//		getFirstDayOfYear(LocalDate.now());
//		dateCal();
		
//		GetDate();

		Date dateBeforeXDays2 = DateUtil.getDateBeforeXDays(new Date(), 90);
		System.out.println(dateBeforeXDays2);
	}

	private static void GetDate() {
		String dateToString = ConstructDate.dateToString(LocalDate.now(), ConstructDate.YYYY_MM_DD_23_59_59);
		System.out.println(dateToString);
		LocalDate stringToDate = ConstructDate.stringToDate(ConstructDate.dateToString(LocalDate.now(), ConstructDate.YYYY_MM_DD_23_59_59), ConstructDate.YYYY_MM_DD_23_59_59);
		System.out.println(stringToDate);
		
	}

	private static void dateCal() {
		// Get the current date and time
		LocalDateTime currentTime = LocalDateTime.now();
		System.out.println("Current DateTime: " + currentTime);

		LocalDate date1 = currentTime.toLocalDate();
		System.out.println("date1: " + date1);

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
		System.out.println("date4: " + date4);

		// parse a string
		LocalTime date5 = LocalTime.parse("20:15:30");
		System.out.println("date5: " + date5);
	}

	private static void getFirstDayOfYear(LocalDate now) {
		LocalDate firstDayYears = now.with(firstDayOfYear());
		System.out.println(firstDayYears);
		LocalDate minusYears = firstDayYears.minusYears(1);
		System.out.println(minusYears);

		LocalDate plusDays = LocalDate.now().plusDays(1);
		System.out.println(plusDays);

	}

}
