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
package com.shahzad.hussain;

/**
 * @author shahzad.hussain
 *
 */
import java.util.*;

public class Addition {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);

		System.out.println(sum(list));
		System.out.println(add(list));

		System.out.println(avg(list));
	}

	private static double avg(List<Integer> list) {
		OptionalDouble doube = list.stream().filter(o -> o > 5).mapToDouble(o -> o).average();
		return doube.getAsDouble();
	}

	private static int add(List<Integer> list) {
		Iterator<Integer> it = list.iterator();
		int result = 0;
		while (it.hasNext()) {
			Integer num = (Integer) it.next();
			if (num > 5) {
				result = result + num;
			}
		}
		return result;
	}

	public static int sum(List<Integer> list) {
		return list.stream().filter(i -> i > 5).filter(o->o<9).mapToInt(i -> i).sum();
	}
}