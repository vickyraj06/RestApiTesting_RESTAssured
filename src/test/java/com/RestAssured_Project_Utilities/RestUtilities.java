package com.RestAssured_Project_Utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtilities {

	
	
	public static String randaomname() {
		String name=RandomStringUtils.randomAlphabetic(5);
		return ("raj"+name);
			
	}
	public static String randaomname1() {
		String name=RandomStringUtils.randomAlphabetic(5);
		return ("vicky"+name);
			
	}
	public static String randaomjob() {
		String name=RandomStringUtils.randomAlphabetic(5);
		return (name);
			
	}
}
