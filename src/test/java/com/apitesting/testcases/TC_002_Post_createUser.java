package com.apitesting.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.apitesting.payload.Users_Pojo;
import com.apitesting.services.ServicesHelper;
import com.apitesting.testbase.TestBase;

import junit.framework.Assert;

public class TC_002_Post_createUser extends TestBase {
	
	ServicesHelper sh = new ServicesHelper();
	@BeforeClass
	void getAllEmployees() throws InterruptedException 
	{
		logger.info("**********Started_TC002_POST********");
		response = sh.Post_Users();
	}
	
	@Test
	void checkResponseBody() 
	{
		logger.info("************Checking Response Body************");
		String responseBody = response.getBody().asString();
		assertEquals(responseBody.contains("morpheus"), true);
		assertEquals(responseBody.contains("leader"), true);
	}

	@Test
	void checkStatusCode()
	{
		logger.info("*************Checking Status Code************");
		int statusCode = response.getStatusCode();
		assertEquals(statusCode, 201);
	}
	@AfterClass
	public void tearDown() {
		logger.info("*************Finished TC002_POST********");
	}
}
	

