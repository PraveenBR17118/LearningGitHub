package com.test;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


@SuppressWarnings("deprecation")
public class OrangeHRMTest 
{
	ChromeDriver driver ;
		
	
	@Test(priority =1)
	public void loginToApplication() 
	{
		// Launch browser
		System.setProperty("webdriver.chrome.driver","/Users/praveenbr/IdeaProjects/JavaUdemy/Selenium/QA-Automation/Drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
		// open login page
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		// enter username
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		
		
		
		// enter password
		
		driver.findElement(By.name("password")).sendKeys("admin123");
		
		
		
		// click on login button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	@Test(priority = 2)
	public void testAdmin() 
	{
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//h5[text()='System Users']")).isDisplayed());
	}
	
	
	
	

	
	
	
	@Test(priority = 3)
	public void logout() 
	{
		driver.findElement(By.xpath("//img[@alt='profile picture']")).click();
		
		driver.findElement(By.linkText("Logout")).click();
	}
	
	
	//@Test(priority = 4 , enabled = false)
	@Test(priority = 4)
	public void closeBrowser() 
	{
		driver.quit();	
	}

}
