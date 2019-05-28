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
import java.util.Scanner;

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

}
