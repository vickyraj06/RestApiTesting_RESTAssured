package com.RestAssured_Project_TestCases;

import org.json.simple.JSONObject;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.RestAssured_Project_Utilities.RestUtilities;

import io.restassured.RestAssured;
import io.restassured.http.Method;


public class TC_002_POST  extends Baseclass{

	String firstname=RestUtilities.randaomname();
	String lastname=RestUtilities.randaomname1();
	String job=RestUtilities.randaomjob();
	
	@BeforeClass
	public void test_Setup() {
		logger.info("TC_002_POST Test Started");
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("first_name", firstname);
		jsonObject.put("last_name", lastname);
		jsonObject.put("job", job);
		


		RestAssured.baseURI="https://reqres.in";
		httprequest=RestAssured.given();
		httprequest.header("Content-Type","application/json");
		httprequest.body(jsonObject.toJSONString());
		response=httprequest.request(Method.POST,"/api/users");
	}

	@Test
	public void check_responseBody() {

		String responsebody=response.getBody().asString();
		Assert.assertTrue(responsebody!=null);
		logger.info("CHECKED_RESPONSEBODY");

	}

	@Test
	public void check_statuscode() {

		Assert.assertEquals(response.getStatusCode(), 201);
		logger.info("CHECKED_STATUSCODE");
	}

	@Test
	public void check_statusLINE() {

		Assert.assertEquals(response.statusLine(), "HTTP/1.1 201 Created");
		logger.info("CHECKED_STATUSLINE");
	}

	@Test
	public void check_responsetime() {
		if (response.getTime()>2000) {
			System.out.println("STATUS TIME MORE THAN 2000");
		}

		Assert.assertTrue(response.getTime()<2000);
		logger.info("CHECKED_RESPONSETIME");
	}



	@Test
	public void check_POSTDetails() {

		Assert.assertEquals(response.jsonPath().get("first_name"), firstname);
		Assert.assertEquals(response.jsonPath().get("last_name"), lastname);
		Assert.assertEquals(response.jsonPath().get("job"), job);
		logger.info("CHECKED_USERS-DETAILS");
	}




	@AfterClass
	public void teardown() {
		logger.info("TC_002_POST Testing FINISHED");


	}





}
