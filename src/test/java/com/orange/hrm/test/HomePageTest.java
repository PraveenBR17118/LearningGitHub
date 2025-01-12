package com.orange.hrm.test;

import org.testng.annotations.Test;

import com.orange.hrm.pages.HomePage;

public class HomePageTest extends BaseTest 
{
	
	@Test
	public void logout() 
	{
		HomePage homePage = new HomePage();
		homePage.clickOnAdminLInk();
		
		homePage.logoutFromApplication();
	}

}
