package com.demoaut.newtours.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demoaut.newtours.base.BaseTest;
import com.demoaut.newtours.pages.HomePage;
import com.demoaut.newtours.pages.LoginPage;
import com.demoaut.newtours.pages.MainPage;
import com.demoaut.newtours.utils.CommonUtils;

public class LoginPageTest extends BaseTest{

	
	MainPage mainPage_obj;
	LoginPage loginPage_obj;
	HomePage homePage_obj;
	
	
	public LoginPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{   initialization();
		mainPage_obj = new MainPage();
		Thread.sleep(5000);
		loginPage_obj= mainPage_obj.clickon_loginBtn();
	
	}
	
	@DataProvider(name="Credentials")
	public Object[][] getCredentialsfromHere() throws IOException{
		
		return CommonUtils.getData(prop.getProperty("filePath"), prop.getProperty("fileName"), prop.getProperty("sheetName"));
		
		//return CommonUtils.getData("C:\\Users\\AnkurDeep\\eclipse-workspace\\SelfPractise\\src\\main\\java\\com\\demoaut\\newtours\\testdata\\", "FreeCRMTestData.xlsx", "Credentials");
			
//		return new Object[][] {
//			{"ankureuthenics0789@gmail.com","Test@1010"},
//			{"acbd@gmail.com", "abcabcba"}
//		};
	}
	
	@Test(dataProvider = "Credentials")
	public void loginTest(String usr, String pwd) throws InterruptedException
	{
		homePage_obj = loginPage_obj.login(usr,pwd);
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
}
