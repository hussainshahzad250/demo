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
package com.example.demo.utils;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

public class Utils {

	public static final Logger LOGGER = LoggerFactory.getLogger(Utils.class);

	/**
	 * parse string to integer
	 *
	 * @param value    the value to be parse
	 * @param defValue default value to be pass
	 * @return parsed value
	 */
	public static int parseToInteger(String value, int defValue) {
		if (!StringUtils.isEmpty(value)) {
			try {
				return Integer.parseInt(value);
			} catch (NumberFormatException exception) {
				// LOGGER.error("Error parsing string to integer.", exception);
			}
		}
		return defValue;
	}

	/**
	 * parse string to long
	 * 
	 * @param value
	 * @param defValue
	 * @return
	 */
	public static long parseToLong(String value, long defValue) {
		if (!StringUtils.isEmpty(value)) {
			try {
				return Long.parseLong(value);
			} catch (NumberFormatException exception) {
				// LOGGER.error("Error parsing string to integer.", exception);
			}
		}
		return defValue;
	}

	/**
	 * parse string to float
	 *
	 * @param value    the value to be parse
	 * @param defValue default value to be pass
	 * @return parsed value
	 */
	public static float parseToFloat(String value, float defValue) {
		if (!StringUtils.isEmpty(value)) {
			try {
				return Float.parseFloat(value);
			} catch (NumberFormatException exception) {
				// LOGGER.error("Error parsing string to integer.", exception);
			}
		}
		return defValue;
	}

	/**
	 * parse string to float
	 *
	 * @param value    the value to be parse
	 * @param defValue default value to be pass
	 * @return parsed value
	 */
	public static double parseToDouble(String value, double defValue) {
		if (!StringUtils.isEmpty(value)) {
			try {
				return Double.parseDouble(value);
			} catch (NumberFormatException exception) {
				// LOGGER.getLogger().("Error parsing string to integer.", exception);
			}
		}
		return defValue;
	}

	/**
	 * parse string to bigdecimal
	 *
	 * @param value    the value to be parse
	 * @param defValue default value to be pass
	 * @return parsed value
	 */
	public static BigDecimal parseToBigDecimal(String value, BigDecimal defValue) {
		if (!StringUtils.isEmpty(value)) {
			try {
				return new BigDecimal(value);
			} catch (NumberFormatException exception) {
				// LOGGER.error("Error parsing string to integer.", exception);
			}
		}
		return defValue;
	}

	/**
	 * get a rounded number
	 *
	 * @param number       number to be rounded
	 * @param decimalPoint the decimal point value
	 * @return rounded number
	 */
	public static double roundNumber(double number, int decimalPoint) {
		try {
			if (decimalPoint < 0) {
				return 0.00d;
			}
			long multiplier = (long) Math.pow(10, decimalPoint);
			double mulNumber = number * multiplier;

			// get fraction of the rounded digit
			int fraction = (int) ((mulNumber * 10) % 10);
			// add fraction value in existing number if greater than 5
			mulNumber += fraction >= 5 ? 1 : 0;
			// round the number in integer value

			double roundedNumber = (long) mulNumber;
			return roundedNumber / multiplier;
		} catch (Exception e) {
			e.printStackTrace();
			return 0.00d;
		}
	}

	/**
	 * get a rounded number
	 *
	 * @param number       number to be rounded
	 * @param decimalPoint the decimal point value
	 * @return rounded number
	 */
	public static double truncateNumber(double number, int decimalPoint) {
		try {
			if (decimalPoint < 0) 
				return 0.00d;
			long multiplier = (long) Math.pow(10, decimalPoint);
			double mulNumber = number * multiplier;
			double roundedNumber = (long) mulNumber;
			return roundedNumber / multiplier;
		} catch (Exception e) {
			e.printStackTrace();
			return 0.00d;
		}
	}

	/**
	 * parse the integer value into boolean
	 *
	 * @param value    int value
	 * @param defValue default value in case of some error
	 * @return true if 1 else false
	 */
	public static boolean parseIntToBoolean(int value, boolean defValue) {
		try {
			switch (value) {
			case 0:
				return false;
			case 1:
				return true;
			}
			return defValue;
		} catch (Exception e) {
			e.printStackTrace();
			return defValue;
		}
	}

}
