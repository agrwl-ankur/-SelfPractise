package com.demoaut.newtours.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoaut.newtours.base.BaseTest;
import com.demoaut.newtours.pages.MainPage;
import com.demoaut.newtours.pages.SignUpPage;

public class MainPageTest extends BaseTest{
	
	// object creation of all required main classes
	MainPage mainPage_obj;
	SignUpPage signUpPage_obj;
	
	
	// call constructor of BaseTest class so that properties files are initialized 
	
	public MainPageTest()
	{ super();
	
	}
	
	
	@BeforeMethod
	public void setUp()
	{   initialization();
		mainPage_obj = new MainPage();
	
	}
	
	@Test(priority =1)
	public void validateTitle() throws InterruptedException
	{   
		String title= mainPage_obj.validateLoginpageTitle();
		Assert.assertEquals(title, "Free CRM #1 cloud software for any business large or small");
	}
	
//	@Test(priority =2)
//	public void validateLogo()
//	{  Assert.assertEquals(mainpage_obj.validateLogo(), true);
//	}
	
	@Test(priority =2)
	public void signupTest() throws InterruptedException
	{
		signUpPage_obj= mainPage_obj.clickon_signUpBtn();
		//mainpage_obj.clickon_signUpBtn();
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
