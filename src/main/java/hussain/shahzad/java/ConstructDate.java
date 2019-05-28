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

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ConstructDate {

	private ConstructDate() {
	}

	public static LocalDate stringToDate(String date) {
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			LocalDate dt = LocalDate.now();
			dt = LocalDate.parse(date, dtf);
			return dt;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public static String dateToString(LocalDate date) throws DateTimeException {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			return date.format(formatter);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
