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
package hussain.shahzad.java;

import java.text.ParseException;
import java.util.Calendar;

public class DateDiff {

	public static void main(String[] args) throws ParseException {

		String startDate = "2019-03-26";
		String endDate = "2020-03-29";

		Calendar sDate = Calendar.getInstance();
		sDate.setTime(DateUtil.parseDate(startDate, DateUtil.YYYY_MM_DD));

		Calendar eDate = Calendar.getInstance();
		eDate.setTime(DateUtil.parseDate(endDate, DateUtil.YYYY_MM_DD));

		int yearsInBetween = eDate.get(Calendar.YEAR) - sDate.get(Calendar.YEAR);
		int monthsDiff = eDate.get(Calendar.MONTH) - sDate.get(Calendar.MONTH);
		long ageInMonths = yearsInBetween * 12 + monthsDiff + 1;
		System.out.println(ageInMonths);

	}
}
