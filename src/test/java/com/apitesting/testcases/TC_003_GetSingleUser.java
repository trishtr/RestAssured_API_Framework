package com.apitesting.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.apitesting.services.ServicesHelper;
import com.apitesting.testbase.TestBase;

public class TC_003_GetSingleUser extends TestBase {

	ServicesHelper sh = new ServicesHelper();
	@BeforeClass
	void getAllEmployees() throws InterruptedException 
	{
		logger.info("**********Started_TC003_GET_SingleUser********");
		response = ServicesHelper.get_Single_User(2);
	}
	
	@Test
	void checkResponseBody() 
	{
		logger.info("******************TC003_Checking Response Body*************");
		
		String responseBody = response.getBody().asString();
		logger.info("Response Body:  " + responseBody);
		assertTrue(responseBody.contains("Janet"));
		assertTrue(responseBody.contains("Weaver"));
	}
	
	@Test
	void checkStatusCode()
	{
		logger.info("************TC003_Checking Status Code************");
		
		int statusCode = response.getStatusCode();
		logger.info("Status Code is  " + statusCode);
		assertEquals(statusCode, 200);
				
	}
	
	@AfterClass
	public void tearDown()
	{
		logger.info("************* Finished TC003_Get_SingleUsers***************");
		
	}

	
}
