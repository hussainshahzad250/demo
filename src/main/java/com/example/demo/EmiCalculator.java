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
package com.example.demo;

import java.math.BigDecimal;
import java.text.Format;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

public class EmiCalculator {

	public static void main(String[] args) throws ParseException {

		calculateIntrest();

//		String s = null;
//		s= s.replaceAll(",", "");
//		System.out.println(s);
//		numberformat();
//		Scanner scanner = new Scanner(System.in);
//		Date dateBeforeOneYear = DateUtil.getDateBeforeXDays(new Date(), DateUtil.DD_MM_YYYY, 365);
//		System.out.println("dateBeforeOneYear [] " + dateBeforeOneYear);
//		System.out.println("Plz enter Date");
//		String nextLine = scanner.nextLine();
//		Date parseDate = DateUtil.parseDate(nextLine, DateUtil.DD_MM_YYYY);
//		if (parseDate.after(dateBeforeOneYear) || DateUtil.format(parseDate, DateUtil.DD_MM_YYYY)
//				.equalsIgnoreCase(DateUtil.format(dateBeforeOneYear, DateUtil.DD_MM_YYYY))) {
//			System.out.println(true);
//			System.out.println(parseDate + " comes after " + dateBeforeOneYear);
//		} else {
//			System.out.println(false);
//		}

	}

	private static void numberformat() {
		NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
		System.out.println(format.format(10000 / 100.0));
		Format format1 = NumberFormat.getCurrencyInstance(new Locale("en", "in"));
		System.out.println(format1.format(new BigDecimal("100000000")));

	}

	private static void calculateIntrest() {
		Scanner X = new Scanner(System.in);
		double principal, rate, time;
		long emi = 0;

		do {
			System.out.print("Enter principal: ");
			principal = X.nextFloat();

			System.out.print("Enter rate: ");

			rate = X.nextFloat();

			System.out.print("Enter time in month: ");

			time = X.nextFloat();

			rate = rate / (12 * 100); /* one month interest */

			/* one month period */

			emi = emi + Math.round((principal * rate * Math.pow(1 + rate, time)) / (Math.pow(1 + rate, time) - 1));
			System.out.println("do you want to insert one more row(1/0)");
		} while (1 == X.nextFloat());

		System.out.print("Monthly EMI is= " + emi + "\n");

	}

}
