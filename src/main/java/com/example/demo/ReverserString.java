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

import java.util.Scanner;

/**
 * @author shahzad.hussain
 *
 */
public class ReverserString {

	public static void main(String[] args) {
		System.out.println("Please Input String ");
		Scanner sc = new Scanner(System.in);
		String nextLine = sc.nextLine();
		String reverseString = reverseString(nextLine);
		System.out.println("Reverse String " + reverseString);

	}

	public static String reverseString(String myStr) {
		if (myStr.isEmpty()) {
			System.out.println("String in now Empty");
			return myStr;
		}
		// Calling Function Recursively
		System.out.println("String to be passed in Recursive Function: " + myStr.substring(1));
		return reverseString(myStr.substring(1)) + myStr.charAt(0);
	}

}
