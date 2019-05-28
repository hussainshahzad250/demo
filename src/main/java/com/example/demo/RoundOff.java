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
package com.example.demo;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author shahzad.hussain
 *
 */
public class RoundOff {

	public static void main(String[] args) {

		double d = 16.7898d;
		System.out.println(roundOff(d, 2));

	}

	private static double roundOff(double value, int decimalValue) {
		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(decimalValue, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

}
