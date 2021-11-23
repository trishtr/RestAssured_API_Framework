package com.apitesting.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtilis {

	public static String userName() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("John" + generatedString);
		
	}
	
	public static String userId() {
		String generatedString = RandomStringUtils.randomNumeric(5);
		return (generatedString);
	}
	
	public static String userAge() {
		String generatedString = RandomStringUtils.randomNumeric(2);
		return (generatedString);
	}
}
