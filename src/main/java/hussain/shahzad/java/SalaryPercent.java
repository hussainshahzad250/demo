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

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class SalaryPercent {

	public static void main(String[] args) throws ParseException {

		int salary = 38000;
		System.out.println("salary " + salary);
		System.out.println("Min-Sal ==> " + salaryMin(salary) + " & " + "Max-Sal ==> " + salaryMax(salary));
		Date dateAfterXDays = DateUtil.getDateAfterXDays(new Date(), 5);
		System.out.println(DateUtil.format(dateAfterXDays, DateUtil.DD_MM_YYYY));
		
		Date date = new Date();
		 String stringDate = DateFormat.getDateTimeInstance().format(date);
		 System.out.println(stringDate);

	}

	private static int salaryMin(int salary) {
		return salary = salary - salary * 10 / 100;
	}

	private static int salaryMax(int salary) {
		return salary = salary + salary * 10 / 100;
	}
}
