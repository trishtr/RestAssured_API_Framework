package com.apitesting.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;



public class ReadConfig {
		
	static Properties pro;
	
	public ReadConfig(){
		
		File src = new File("./config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);	
			}
		catch (IOException e) 
		{
			System.out.println("Exception is " + e.getMessage());
		}
		
		}
	
	public static String getPageNumber()
	{
		String pagenumber = pro.getProperty("pagenumber");
		return pagenumber;
	}
	
	public static String getUserId()
	{
		String userid = pro.getProperty("userid");
		return userid;
	}
	

		
		
}
