package com.apitesting.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.apitesting.services.ServicesHelper;
import com.apitesting.testbase.TestBase;



public class TC_004_PatchUsers extends TestBase {

	ServicesHelper sh = new ServicesHelper();
	@BeforeClass
	void getAllEmployees() throws InterruptedException 
	{
		logger.info("**********Started_TC004_PATCH********");
		response = sh.Patch_Users(2);
	}
	
	@Test
	void checkResponseBody() 
	{
		logger.info("************Checking Response Body************");
		String responseBody = response.getBody().asString();
		assertTrue(responseBody != null);
		;
	}
		

	@Test
	void checkStatusCode()
	{
		logger.info("*************Checking Status Code************");
		int statusCode = response.getStatusCode();
		assertEquals(statusCode, 200);
	}
	@AfterClass
	public void tearDown() {
		logger.info("*************Finished TC004_PATCH********");
	}
}
