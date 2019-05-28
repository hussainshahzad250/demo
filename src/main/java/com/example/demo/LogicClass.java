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

import com.example.demo.utils.DateUtil;

public class LogicClass {
	
	public static void main(String[] args) throws ParseException {
		
		String startDate = "01-01-2018";
		String endDate = "31-01-2018";
		
		getWeekNumber(startDate,endDate);
		
		
		System.out.println(DateUtil.getDateAfterXDays(DateUtil.parseDate(startDate, DateUtil.DD_MM_YYYY), DateUtil.DD_MM_YYYY, 7));
	}

	private static void getWeekNumber(String startDate, String endDate) {
		
		
	}

}
