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
package com.example.jdbc;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.example.demo.utils.DateUtil;

/**
 * @author shahzad.hussain
 *
 */
public class TestStr {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter No of Token to consider");
//		int nextInt = sc.nextInt();
//		System.out.println(getCeilValue(nextInt).intValue());

		TransactionResponse convertFileToPojo = JsonUtil.convertFileToPojo(
				new File("C:\\Users\\Shahzad.Hussain\\Desktop\\perfios-transaction-history.json"),
				TransactionResponse.class);
		String employmentType = "SALARIED";
		getSal(employmentType, convertFileToPojo.getXn());
	}

	private static void getSal(String employmentType, List<Xn> trans) throws ParseException {

		double totalSalary = 0d;
		Date nextMonthDate = null;
		int monthCount = 0;
		Date salaryDate = null;
		double salary = 40000;
		for (Xn o : trans) {
			String date = o.getDate();
			double amount = o.getAmount();
			String category = o.getCategory();
			boolean dosomething = true;
			Date transactionDate = DateUtil.parseDate(date, DateUtil.YYYY_MM_DD);
			if (nextMonthDate == null)
				dosomething = true;
			if (nextMonthDate != null && transactionDate.before(nextMonthDate))
				dosomething = false;
			if (nextMonthDate != null && transactionDate.after(nextMonthDate)
					&& transactionDate.before(DateUtil.getLastDateOfMonth(nextMonthDate)))
				dosomething = true;
			if (dosomething) {
				if (o.getCategory().contains("Salary")) {
					nextMonthDate = DateUtil.getNextMonthFirstDayFromDate(transactionDate);
					totalSalary = totalSalary + o.getAmount();
					salaryDate = transactionDate;
					System.out.println(
							"[SAL_DATE]\t=> " + o.getDate() + "\t[AMOUNT]=> " + amount + "\t[CATEGORY]=>" + category);
					monthCount++;
				} else {
					if ("SALARIED".equals(employmentType)
							&& (o.getCategory().contains("Transfer in") || o.getCategory().contains("Transfer from"))
							&& (o.getAmount() >= salaryMin(salary, 10) && o.getAmount() <= salaryMax(salary, 10))) {
						nextMonthDate = DateUtil.getNextMonthFirstDayFromDate(transactionDate);
						salaryDate = transactionDate;
						System.out.println("[SAL_DATE]\t=> " + o.getDate() + "\t[AMOUNT]=> " + amount + "\t[CATEGORY]=>"
								+ category);
						monthCount++;
						if (transactionDate.before(nextMonthDate))
							totalSalary = totalSalary + o.getAmount();
					}
				}
			}
		}
		if (salaryDate != null)
			System.out.println(salaryDate.getDay());
		System.out.println("[TOTAL_AMOUNT] ==>> " + totalSalary + " Salary found for " + monthCount + " Months");
		double avgSal = roundOff(totalSalary / monthCount, 2);
		if (monthCount >= 3) {
			System.out.println("ACTUAL SALRY[AVG_SAL] ==>>" + avgSal);
		}
	}

	private static double roundOff(double value, int decimalValue) {
		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(decimalValue, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	public static double salaryMin(double salary, int percentage) {
		return salary = salary - salary * percentage / 100;
	}

	public static double salaryMax(double salary, int percentage) {
		return salary = salary + salary * percentage / 100;
	}

	private static Double getCeilValue(int tokens) {
		double token = tokens * 2 / 3;
		return Math.ceil(token);

	}

}
