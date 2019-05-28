package com.shahzad.hussain;

import org.springframework.util.StringUtils;

/**
 * 
 * @author shahzad.hussain
 *
 */
public enum Gender {

	MALE("M"), FEMALE("F"), UNKNOWN("U");

	private String value;

	private Gender(String gender) {
		this.value = gender;
	}

	public String getValue() {
		return value;
	}

	public static Gender findByName(String name) {
		try {
			if (StringUtils.isEmpty(name)) {
				return UNKNOWN;
			} else {
				return Gender.valueOf(name);
			}

		} catch (IllegalArgumentException ex) {
			return UNKNOWN;
		}
	}
}
