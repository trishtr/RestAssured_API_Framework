package com.apitesting.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.apitesting.services.ServicesHelper;
import com.apitesting.testbase.TestBase;

import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

public class TC_001_Get_All_Users extends TestBase {

	ServicesHelper sh = new ServicesHelper();
	@BeforeClass
	void getAllEmployees() throws InterruptedException 
	{
		logger.info("**********Started_TC001_GET_allusers********");
		response = sh.get_All_Users(2);
	}
	@Test
	void checkResponseBody() 
	{
		logger.info("******************Checking Response Body*************");
		
		String responseBody = response.getBody().asString();
		logger.info("Response Body:  " + responseBody);
		JsonPath jpath = response.jsonPath();
		int page = jpath.get("page");
		assertEquals(page, 2);
		assertEquals(responseBody.contains("Michael"), true);
	}
	
	@Test
	void checkStatusCode()
	{
		logger.info("************Checking Status Code************");
		
		int statusCode = response.getStatusCode();
		logger.info("Status Code is  " + statusCode);
		assertEquals(statusCode, 200);
		
		
	}
	
	@Test
	void checkResponseTime()
	{
		logger.info("**************Checking Response Time*************");
		
		long responseTime = response.getTime();
		logger.info("Response Time is  " + responseTime);
		
		if(responseTime >2000)
			logger.warn("Response Time is greater than 2000");
		
		assertTrue(responseTime < 2000);
		
	}
	
	@Test
	void checkStatusLine()
	{
		logger.info("************Checking Status Line***********");
		
		String statusLine = response.getStatusLine();
		logger.info("Status Line is   " + statusLine);
		assertEquals(statusLine, "HTTP/1.1 200 OK");
		
	}
	
	@Test
	void checkContentType()
	{
		logger.info("**************Checking Content Type*********");
		
		String contentType = response.header("Content-Type");
		
		assertEquals(contentType, "application/json; charset=utf-8");
		
		
	}
		
	@Test
	void checkcontentEncoding()
	{
		logger.info("********Checking Content Encoding***************");
		
		String serverType = response.header("Content-Encoding");
		assertEquals(serverType, "gzip");
	}
	
	
	
	@Test
	void checkCookies()
	{
		logger.info("********Checking Cookies***************");
		
		String cookies = response.getCookie("PHPSESSID");
		//Assert.assertEquals(cookies, "");
	}
	@AfterClass
	public void tearDown()
	{
		logger.info("************* Finished TC001_Get_All_users***************");
		
	}

	
}
