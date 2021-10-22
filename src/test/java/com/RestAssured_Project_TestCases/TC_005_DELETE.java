package com.RestAssured_Project_TestCases;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;




public class TC_005_DELETE extends Baseclass {


	@BeforeClass
	public void test_DELETE() {

		logger.info("TC_005_DELETE Testing FINISHED");
		RestAssured.baseURI="https://reqres.in";

		httprequest=RestAssured.given();

		response=httprequest.request(Method.DELETE,"/api/users/"+empid);


	}

	@Test()
	public void check_responseBody() {

		String responsebody=response.getBody().asString();
		Assert.assertEquals(responsebody.isEmpty(),true);
		logger.info("CHECKED_RESPONSEBODY");
		

	}

	@Test
	public void check_statuscode() {

		Assert.assertEquals(response.getStatusCode(), 204);
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

		Assert.assertEquals(response.statusLine(), "HTTP/1.1 204 No Content");
		logger.info("CHECKED_STATUSLINE");
	}




	@AfterClass
	public void teardown() {
		logger.info("TC_005_DELETE Testing FINISHED");


	}




}
