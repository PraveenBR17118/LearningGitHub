package com.orange.hrm.test;

import java.time.Duration;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.report.ExtentReportUtils;



public class BaseTest 
{
	public static WebDriver driver ;
	public static Logger log ;
	
	@BeforeSuite
	public void initDriver() 
	{
		ExtentReportUtils.setUpReport();
		System.setProperty("webdriver.chrome.driver","/Users/praveenbr/IdeaProjects/JavaUdemy/Selenium/QA-Automation/Drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		log = LogManager.getLogger("Orange HRM");
		PropertyConfigurator.configure("Log4j.properties");
		
		
	}
	
	@AfterSuite
	public void closeDriver() 
	{
		driver.quit();
	}

}
