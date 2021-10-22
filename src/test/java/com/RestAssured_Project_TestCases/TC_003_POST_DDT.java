package com.RestAssured_Project_TestCases;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.RestAssured_Project_Utilities.XLUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC_003_POST_DDT extends Baseclass{

	
	public String name1;
	public String name2;
	public String job;
	public static JSONObject jsonObject;


	@DataProvider(name="biodata")
	String[][] getdata() throws IOException{


		String path="C:\\eclipse-workspace\\com.RestAssured_Project\\src\\test\\java\\com\\RestAssured_Project_TestData\\RESTAPI_POST.xlsx";

		int rowcount=XLUtils.getRowCount(path,"sheet1");
		int colcount=XLUtils.getCellCount(path, "sheet1", 1);
		String emp_data[][]= new String[rowcount][colcount];

		for(int i=1;i<=rowcount;i++) {
			for(int j=0;j<colcount;j++) {

				emp_data[i-1][j]=XLUtils.getCellData(path,"sheet1", i, j);
			}
		}


		return emp_data;
	}

	@Test(dataProvider = "biodata")
	public void test_POST_DDT(String name1,String name2,String job) {

		logger.info("TC_003_POST_DDT Test Started");
		jsonObject=new JSONObject();
		jsonObject.put("first_name", name1);
		jsonObject.put("last_name", name2);
		jsonObject.put("job", job);



		RestAssured.baseURI="https://reqres.in";
		httprequest=RestAssured.given();
		httprequest.header("Content-Type","application/json");
		httprequest.body(jsonObject.toJSONString());
		response=httprequest.request(Method.POST,"/api/users");
	}
	
	@AfterClass
	public void teardown() {
		logger.info("TC_003_POST_DDT Testing FINISHED");
	}
	




}