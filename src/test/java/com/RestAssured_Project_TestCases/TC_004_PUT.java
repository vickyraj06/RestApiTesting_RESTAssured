package com.RestAssured_Project_TestCases;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.RestAssured_Project_Utilities.RestUtilities;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC_004_PUT extends Baseclass {


	String firstname=RestUtilities.randaomname();
	String lastname=RestUtilities.randaomname1();
	String job=RestUtilities.randaomjob();
	
	@BeforeClass
	public void test_Setup() {

		
		logger.info("TC_004_PUT Test Started");
		JSONObject jsonObject=new JSONObject(); 
		jsonObject.put("first_name", firstname); 
		jsonObject.put("last_name", lastname); 
		jsonObject.put("job", job);
		 


		RestAssured.baseURI="https://reqres.in";
		httprequest=RestAssured.given();
		httprequest.header("Content-Type","application/json");
		httprequest.body(jsonObject.toJSONString());
		response=httprequest.request(Method.PUT,"/api/users/"+empid);
	}

	@Test
	public void check_responseBody() {

		String responsebody=response.getBody().asString();
		Assert.assertTrue(responsebody!=null);
		logger.info("CHECKED_RESPONSEBODY");
		

	}

	@Test
	public void check_statuscode() {

		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("CHECKED_STATUSCODE");
		
	}

	@Test
	public void check_statusLINE() {

		Assert.assertEquals(response.statusLine(), "HTTP/1.1 200 OK");
		logger.info("CHECKED_STATUSLINE");
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
	public void check_Contenttype() {

		Assert.assertEquals(response.header("Content-Type"),"application/json; charset=utf-8");
		logger.info("CHECKED_CONTENT-TYPE");
		
	}

	@Test
	public void check_POSTDetails() {

		Assert.assertEquals(response.jsonPath().get("first_name"), firstname);
		Assert.assertEquals(response.jsonPath().get("last_name"), lastname);
		Assert.assertEquals(response.jsonPath().get("job"), job);
		logger.info("USERDETAILS UPDATED SUCCESSFULLY");
	}




	@AfterClass
	public void teardown() {
		logger.info("TC_004_PUT Testing FINISHED");

	}


}
