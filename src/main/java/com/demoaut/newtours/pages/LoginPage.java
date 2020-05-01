package com.demoaut.newtours.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.demoaut.newtours.base.BaseTest;
import com.demoaut.newtours.utils.CommonUtils;

public class LoginPage extends BaseTest {

	@FindBy(xpath="//input[@type='text' and @name='email']")
	WebElement userName;
	
	@FindBy(xpath="//input[@type='password' and @name='password']")
	WebElement passWord;
	
	@FindBy(xpath= "//*[@class='ui fluid large blue submit button']")
	WebElement submitBtn;

	public LoginPage(){
		
		PageFactory.initElements(driver, this); 
	}

	public HomePage login(String user, String pwd ) throws InterruptedException
	{
		
		Thread.sleep(5000);
		Assert.assertTrue(CommonUtils.enterSafelyIn(userName, user), "Entering Username on LoginPage");
		Assert.assertTrue(CommonUtils.enterSafelyIn(passWord, pwd),"Entering Password on LoginPage");
		Assert.assertTrue(CommonUtils.clickSafelyOn(submitBtn), "Clicking on Login button");
		return new HomePage();
	}

}
