package com.RestAssured_Project_TestCases;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Baseclass {

	public static RequestSpecification httprequest;
	public static Response response;
	public String empid="3";
	public static Logger logger;

	@BeforeClass
	public void setup() {

		logger=Logger.getLogger(Baseclass.class);
		PropertyConfigurator.configure("log4j.properties");
		logger.info("REST ASSURED API TESTING PROJECT TESTING");

	}

	@AfterClass
	public void teardown() {
		
		logger.info("REST ASSURED API TESTING  FINISHED");
		
	}




}
