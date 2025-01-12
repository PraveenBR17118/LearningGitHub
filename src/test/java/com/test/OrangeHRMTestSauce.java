package com.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrangeHRMTestSauce 
{
	RemoteWebDriver driver;
		
	
	@Test(priority =1)
	public void loginToApplication() throws MalformedURLException 
	{
		
		
		
		// Launch browser
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setPlatformName("Windows 11");
		browserOptions.setBrowserVersion("latest");
		Map<String, Object> sauceOptions = new HashMap();
		sauceOptions.put("username", "oauth-tanvitkashyap-a1595");
		sauceOptions.put("accessKey", "0f7eee7e-95c9-45f6-90b4-0cb841add3de");
		sauceOptions.put("build", "Test Automation");
		sauceOptions.put("name", "Sanity test");
		browserOptions.setCapability("sauce:options", sauceOptions);
		
		URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
		driver = new RemoteWebDriver(url, browserOptions);
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
