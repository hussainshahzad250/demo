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
package com.hussain.utils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class B {

	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			System.out.println("Enter Total Factor Value");
			int nextInt = sc.nextInt();
			BigDecimal totalFactor = BigDecimal.valueOf(nextInt);
			BigDecimal maxInterestRate = BigDecimal.valueOf(30);
			System.out.println(maxInterestRate.subtract(totalFactor.divide(BigDecimal.valueOf(10))));
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (sc != null) {
				sc.close();
			}
		}

	}

	private static void extracted() throws ParseException {
		TreeMap<Integer, List<Date>> dateHashMap = new TreeMap<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		List<Date> dates = new ArrayList<>();
		dates.add(sdf.parse("10/03/2017"));
		dates.add(sdf.parse("9/03/2017"));
		dates.add(sdf.parse("8/03/2017"));
		dates.add(sdf.parse("7/03/2017"));
		dates.add(sdf.parse("6/03/2017"));
		dates.add(sdf.parse("23/02/2017"));
		dates.add(sdf.parse("3/02/2017"));
		dates.add(sdf.parse("2/02/2017"));
		dates.add(sdf.parse("1/02/2017"));

		System.out.println(dates);
		for (int i = 0; i < dates.size(); i++) {
			List<Date> datesList = new ArrayList<>();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(dates.get(i));

			int weekOfMonth = calendar.get(Calendar.WEEK_OF_MONTH);

			for (Date dt : dates) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(dt);
				if (weekOfMonth == cal.get(Calendar.WEEK_OF_MONTH)) {
					datesList.add(dt);
				}
			}

			dateHashMap.put(weekOfMonth, datesList);

		}
		System.out.println(dateHashMap);
	}

}
