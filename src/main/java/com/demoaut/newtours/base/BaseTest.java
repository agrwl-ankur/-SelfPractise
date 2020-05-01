package com.demoaut.newtours.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class BaseTest {
	public static WebDriver driver;
	public static Properties prop;
	String prop_path;

	public BaseTest() {
		try {
			prop = new Properties();
			// Path of properties file
			prop_path = "C:\\Users\\AnkurDeep\\eclipse-workspace\\SelfPractise\\src\\main\\java\\com\\demoaut\\newtours\\config\\config.properties";
			// Open file input stream to load the file
			FileInputStream ip = new FileInputStream(prop_path);
			// Load the file
			prop.load(ip);
			;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			
			
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else
			System.out.println(" Browser is neither chrome nor Firefox");
	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		EventFiringWebDriver event = new EventFiringWebDriver(driver);
		
	
	
	}

}
