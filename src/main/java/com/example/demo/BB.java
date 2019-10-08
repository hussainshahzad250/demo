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

import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class BB {

	public static void main(String[] args) throws ParseException {

		String startDate = "2018-08-16";
		String endDate = "2018-11-20";

//		System.out.println("Get Months From LocalDate\t =" + DateUtil.localDateDifference(startDate, endDate));
//		System.out.println("Get Months From Period \t\t =" + DateUtil.periodDifference(startDate, endDate));
//		System.out.println(DateUtil.localDateDifference(LocalDate.parse(startDate), LocalDate.now()));

//		System.out.println(DateUtil.getDateFromInstant(Instant.now(), DateUtil.DD_MM_YYYY));

//		Map<String, String> map = new HashMap<>();
		Map<String, String> map = new LinkedHashMap<>();
		map.put("JAN-2019", "01-01-2019");
		map.put("FEB-2019", "01-02-2019");
		map.put("MAR-2019", "01-03-2019");
		map.put("APR-2019", "01-04-2019");
		map.put("MAY-2019", "01-05-2019");
		map.put("JUNE-2019", "01-06-2019");
		Set<Entry<String, String>> entrySet = map.entrySet();

		for (Entry<String, String> entry : entrySet) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		
		
	}
}
