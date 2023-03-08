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
package com.hussain.googlecloud;

import java.math.BigDecimal;

public class GetInsuranceAmount {

	public static void main(String[] args) {

		BigDecimal loanAmount = BigDecimal.valueOf(10000);
		int tenure = 4;
		BigDecimal calculateInsuranceFee = calculateInsuranceFee(loanAmount, tenure);
		System.out.println(calculateInsuranceFee);
	}

	public static BigDecimal calculateInsuranceFee(BigDecimal loanAmount, Integer tenure) {
		if (loanAmount == null || tenure == null)
			return null;
		if (tenure > 0 && tenure <= 12) {
			return loanAmount.multiply(new BigDecimal(0.431)).divide(BigDecimal.valueOf(100));
		} else if (tenure > 12 && tenure <= 24) {
//			return loanAmount.multiply(new BigDecimal(insurancePrps.getValue())).divide(BigDecimal.valueOf(1000));
		} else if (tenure > 24 && tenure <= 36) {
//			return loanAmount.multiply(new BigDecimal(insurancePrps.getValue())).divide(BigDecimal.valueOf(1000));
		}
		return loanAmount;
	}
}
