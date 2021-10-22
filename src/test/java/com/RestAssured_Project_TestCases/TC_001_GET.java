package com.RestAssured_Project_TestCases;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;


public class TC_001_GET extends Baseclass {


	@BeforeClass
	public void test_Setup() {
		logger.info("TC_001_GET Test Started");
		RestAssured.baseURI = "https://reqres.in";
		httprequest = RestAssured.given();
		response = httprequest.request(Method.GET, "/api/users/"+empid);
	}

	@Test
	public void check_responseBody() {

		String responsebody=response.getBody().asString();
		Assert.assertTrue(responsebody.contains(empid));
		logger.info("CHECKED_RESPONSEBODY");
		

	}

	@Test
	public void check_statuscode() {

		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("CHECKED_STATUSCODE");

	}
	
	@Test
	public void check_responsetime() {
		if (response.getTime()>2000) {
			logger.info("STATUS TIME MORE THAN 2000");
		}

		Assert.assertTrue(response.getTime()<2000);
		logger.info("CHECKED_RESPONSETIME");

	}

	@Test
	public void check_statusLINE() {

		Assert.assertEquals(response.statusLine(), "HTTP/1.1 200 OK");
		logger.info("CHECKED_STATUSLINE");

	}
	
	@Test
	public void check_Contenttype() {

		Assert.assertEquals(response.header("Content-Type"),"application/json; charset=utf-8");
		logger.info("CHECKED_CONTENT-TYPE");

	}
	
	@Test
	public void check_server() {

		Assert.assertEquals(response.header("Server"), "cloudflare");
		logger.info("CHECKED_SERVER");

	}
	
	@Test
	public void check_contentEncoding() {

		Assert.assertEquals(response.header("Content-Encoding"), "gzip");
		logger.info("CHECKED_CONTENT-ENCODING");

	}
	
	
	@AfterClass
	public void teardown() {
		logger.info("TC_001_GET Testing FINISHED");

		

	}
	
	
	
	
	
	
	




}


