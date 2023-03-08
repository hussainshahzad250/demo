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
package com.hussain.utils;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * @author shahzad.hussain
 *
 */
public class LocalDateTest {

	public static void main(String[] args) throws ParseException {

		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		LocalDate localDate = DateUtil.getLocalDateFromDate(date);
		System.out.println(localDate);
		
		int i = calendar.get(Calendar.YEAR);
		System.out.println(i);
		System.out.println(calendar.get(Calendar.MONTH));
		System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
		
		System.out.println(localDate.getYear());
		System.out.println(localDate.getMonthValue());
		System.out.println(localDate.getDayOfMonth());
	}

}
