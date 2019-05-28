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
package com.shahzad.hussain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;

import hussain.shahzad.java.DateUtil;

public class AA {

	public static void main(String[] args) {
		BigDecimal preEmiAmt  =BigDecimal.ZERO;
		LocalDate zeroEmiDt = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth().plus(1),24);

		int days = Period.between(LocalDate.now(), zeroEmiDt).getDays();

		if (days >= 30) {

			System.out.println(DateUtil.getLocalDateToString(zeroEmiDt, DateUtil.DD_MM_YYYY));

		} else {

			System.out.println(DateUtil.getLocalDateToString(zeroEmiDt, DateUtil.DD_MM_YYYY));
			System.out.println(DateUtil.getLocalDateToString(zeroEmiDt.plusMonths(1), DateUtil.DD_MM_YYYY));

			

		}

	}

}
