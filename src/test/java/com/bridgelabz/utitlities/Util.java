package com.bridgelabz.utitlities;

import org.apache.commons.lang3.RandomStringUtils;

public class Util {
	
	public static String randomestring(int number)
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(number);
		return(generatedstring);
	}
	
	public static String randomeNum(int number) {
		String generatedString2 = RandomStringUtils.randomNumeric(number);
		return (generatedString2);
	}
	

}
