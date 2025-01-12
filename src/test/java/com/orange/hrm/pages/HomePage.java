package com.orange.hrm.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orange.hrm.test.BaseTest;
import com.report.ExtentReportUtils;

public class HomePage 
{
	
	@FindBy(xpath = "//span[text()='Admin']")
	WebElement adminlink;
	
	@FindBy(xpath = "//img[@alt='profile picture']")
	WebElement profilePicture;
	
	@FindBy(linkText = "Logout")
	WebElement logoutLink;
	
	public HomePage() 
	{
		PageFactory.initElements(BaseTest.driver, this);
	}
	
	//Logger log = LogManager.getLogger(HomePage.class);
	public void clickOnAdminLInk() 
	{
		adminlink.click();
		BaseTest.log.info("Admin link clicked");
		ExtentReportUtils.addStep("Admin link clicked","No");
		
	}
	
	
	public void logoutFromApplication() 
	{
		profilePicture.click();
		BaseTest.log.info("Profile picture clicked");
		ExtentReportUtils.addStep("Profile picture clicked", "yes");
		logoutLink.click();
		BaseTest.log.info("Logout button clicked");
		ExtentReportUtils.addStep("Logout button clicked" ,"No");
	}

}
