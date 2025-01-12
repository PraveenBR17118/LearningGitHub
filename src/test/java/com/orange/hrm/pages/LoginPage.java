package com.orange.hrm.pages;




import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orange.hrm.test.BaseTest;
import com.report.ExtentReportUtils;

public class LoginPage 
{
	
	// username
	@FindBy(name = "username")
	WebElement userNameTextBox;

	// password
	@FindBy(name = "password")
	WebElement passwordTextBox;

	// login button
	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginBTn;
	
	public LoginPage() 
	{
		PageFactory.initElements(BaseTest.driver, this);
	}
	
	
	//BaseTest.log = LogManager.getLogger(LoginPage.class);
	
	public void loginToApplication(String userName , String password) {
		userNameTextBox.sendKeys(userName);
		BaseTest.log.info("userName entered in username textbox");
		ExtentReportUtils.addStep("userName entered in username textbox","No");
		passwordTextBox.sendKeys(password);
		BaseTest.log.info("password entered in password textbox");
		ExtentReportUtils.addStep("password entered in password textbox", "yes");
		loginBTn.click();
		BaseTest.log.info("Login button clicked");
		ExtentReportUtils.addStep("Login button clicked", "No");
	}

}
