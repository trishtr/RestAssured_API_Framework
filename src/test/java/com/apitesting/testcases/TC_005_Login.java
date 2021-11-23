package com.apitesting.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.apitesting.services.ServicesHelper;
import com.apitesting.testbase.TestBase;

import io.restassured.path.json.JsonPath;

public class TC_005_Login extends TestBase {

	ServicesHelper sh = new ServicesHelper();
	@BeforeClass
	void getAllEmployees() throws InterruptedException 
	{
		logger.info("**********Started_TC005_Login********");
		response = sh.Login();
	}
	
	@Test
	void checkResponseBody() 
	{
		logger.info("******************Checking Response Body*************");
		
		String responseBody = response.getBody().asString();
		logger.info("Response Body:  " + responseBody);
		JsonPath jpath = response.jsonPath();
		String token = jpath.get("token");
		assertEquals(token, "QpwL5tke4Pnpja7X4");
	}
	
	@Test
	void checkStatusCode()
	{
		logger.info("************Checking Status Code************");
		
		int statusCode = response.getStatusCode();
		logger.info("Status Code is  " + statusCode);
		assertEquals(statusCode, 200);
			
	}
	
	
	
}
