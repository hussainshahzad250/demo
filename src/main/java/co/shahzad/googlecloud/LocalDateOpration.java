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
package co.shahzad.googlecloud;

import java.time.LocalDate;

import hussain.shahzad.java.DateUtil;

/**
 * @author shahzad.hussain
 *
 */
public class LocalDateOpration {

	public static void main(String[] args) {
		try {
			LocalDate localDate = LocalDate.now();
			for (int i = 1; i <= 12; i++) {
				System.out.println(localDate.getMonth() + "-" + localDate.getYear());
				localDate = DateUtil.getNextMonth(localDate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
