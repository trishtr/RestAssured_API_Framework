package com.apitesting.testbase;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import io.restassured.response.Response;


public class TestBase {
	
	public static Response response;
	public Logger logger;
	
	public static void sendPDFReportByGMail() {
		final String username = "reonatr123@gmail.com";
 		final String password = "Aa12345678Bb";
 			 	 				
		Properties props = new Properties();
				
		props.put("mail.smtp.auth", true);
	
		props.put("mail.smtp.starttls.enable", true);
	
		props.put("mail.smtp.host", "smtp.gmail.com");
	
		props.put("mail.smtp.port", "587");
			
		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication()
					{
						return new PasswordAuthentication(username, password);
					}
		});
		
		try {
			 	Message message = new MimeMessage(session);
		        message.setFrom(new InternetAddress("reonatr123@gmail.com"));
		        message.setRecipients(Message.RecipientType.TO,
		                InternetAddress.parse("trantrang.ip@gmail.com"));
		        message.setSubject("Testing Subject");
		        message.setText("PFA");
		        
		        MimeBodyPart messageBodyPart = new MimeBodyPart();

		        Multipart multipart = new MimeMultipart();
		        
		        String file = System.getProperty("user.dir")+ "\\Test.pdf";
		        String fileName = "Test.pdf";
		        DataSource source = new FileDataSource(file);
		        messageBodyPart.setDataHandler(new DataHandler(source));
		        messageBodyPart.setFileName(fileName);
		        multipart.addBodyPart(messageBodyPart);
		        message.setContent(multipart);
		        
		        
		       
		        System.out.println("Sending");

		        Transport.send(message);

		        System.out.println("Done");

		    } catch (MessagingException e) {
		        e.printStackTrace();
		    }
			
		
		}
	
	@BeforeClass
	public void setup() {
		
		logger = Logger.getLogger("API_restAssuredFramework");
		PropertyConfigurator.configure("./log4j.properties"); //location of log4j properties
		logger.setLevel(Level.INFO);
	}
		
	@AfterSuite
		
	public void tearDown() {
			
			sendPDFReportByGMail();
	   }


}
