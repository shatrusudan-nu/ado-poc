package com.nu.poc.util;

import java.util.Random;

public class UtilityService {

	private final String LETTERS = "abcdefghijklmnopqrstuvwxyz";
	private final char[] ALPHANUMERIC = (LETTERS.toUpperCase() + "0123456789").toCharArray();
	
	public String generateBookingId(int length) {
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < length; i++) {
			result.append(ALPHANUMERIC[new Random().nextInt(ALPHANUMERIC.length)]);
		}
		return result.toString();
	}
}
