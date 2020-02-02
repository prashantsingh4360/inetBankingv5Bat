 package com.inetbanking.testcases;


import org.testng.annotations.Test;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass
{

	

	@Test
	public void loginTest() throws 	Exception  
	{
		
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		//logger.info("Entered username");
		lp.setPassword(password);
		//logger.info("Entered password");
		lp.clickSubmit();
		
//		
//		 if (driver.getTitle().equals("Demo Site"))
//		 {
//		 Assert.assertTrue(true);
//		 //logger.info("Login test passed");
//		 }
//		 else 
//		 { 
//			 captureScreen(driver,"loginTest");
//			 Assert.assertTrue(false); 
//			// logger.info("Login test failed");
//			 }
//		 
//		
	}
}
