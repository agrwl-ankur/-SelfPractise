package com.demoaut.newtours.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demoaut.newtours.base.BaseTest;

public class MainPage extends BaseTest {
	
	// To initialize page objects  
	
	public MainPage()
	{
		PageFactory.initElements(driver, this); 
	}
	
	// Finding elements with help of Page Factory
	@FindBy(xpath="//a[@href= 'https://register.freecrm.com/register/' and @class='btn btn-sm btn-white btn-icon btn-icon-left btn-shadow btn-border btn-rect offset-sm-top-60 offset-top-30']" )
	WebElement signupBtn;
	
	//WebElement signupBtn = driver.findElement(By.xpath("//a[@href= 'https://register.freecrm.com/register/' and @class='btn btn-sm btn-white btn-icon btn-icon-left btn-shadow btn-border btn-rect offset-sm-top-60 offset-top-30']"));
	
	@FindBy(xpath="//a[@href='https://ui.freecrm.com' and @class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(@class,'brand-name')]")
	WebElement brandLogo;
	
	// Actions on this page
	
	public String validateLoginpageTitle()
	{
		return driver.getTitle();
	}
	
//	public boolean validateLogo()
//	{
//		//WebDriverWait wait = new WebDriverWait(driver,20);
//		//wait.until(ExpectedConditions.visibilityOf(brandLogo));
//		return brandLogo.isDisplayed();
//	}
	
	public SignUpPage clickon_signUpBtn() throws InterruptedException
	{   //WebDriverWait wait = new WebDriverWait(driver,20);
		//wait.until(ExpectedConditions.elementToBeClickable(signupBtn));
		
		try
		{
			signupBtn.click();
		} catch(NullPointerException e)
		{
			System.out.println("Null pointer exception thrown");
		}
		
		return new SignUpPage();
		
	}
	
	public LoginPage clickon_loginBtn()
	{
		loginBtn.click();
		return new LoginPage();
			
	}
} 
