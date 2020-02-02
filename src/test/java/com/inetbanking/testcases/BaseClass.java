package com.inetbanking.testcases;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;


public class BaseClass {
	ReadConfig Read=new ReadConfig();

	public static LogManager Logger;
	public String baseURL=Read.baseURL();
	public String username=Read.username();
	public String password=Read.password();
	public static WebDriver driver;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{		
		
		Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome")){
		System.setProperty("webdriver.chrome.driver",Read.chromepath());
		driver = new ChromeDriver();
		}
		
		else if(br.equals("firefox")){
			System.setProperty("webdriver.gecko.driver",Read.firefoxpath());
			driver = new FirefoxDriver();
			}
			
		driver.get(baseURL);
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	
}
