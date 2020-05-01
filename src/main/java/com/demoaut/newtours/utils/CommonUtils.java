package com.demoaut.newtours.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demoaut.newtours.base.BaseTest;

public class CommonUtils extends BaseTest {

	public static boolean enterSafelyIn(WebElement ele, String text) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(ele));
			ele.sendKeys(text);
			return true;
		} catch (NoSuchElementException ex) {
			return false;
		}
	}

	public static boolean clickSafelyOn(WebElement ele) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(ele));
			ele.click();
			return true;
		} catch (NoSuchElementException ex) {
			return false;
		}

	}

	public static Object[][] getData(String filePath,String fileName, String sheetName) throws IOException
	{
//		String filePath ="C:\\Users\\AnkurDeep\\eclipse-workspace\\ProjectTest\\Data\\";
//		String fileName = "data1.xlsx";
//		String sheetName ="sheet1";
//		
		// create a virtual workbook so that compiler copies all the data from the file 
		File file= new File(filePath+fileName);
		FileInputStream inputStream =  new FileInputStream(file);
		
		// create a workbook
		Workbook wb = null;
		String extension = fileName.substring(fileName.indexOf("."));
		if(extension.equals(".xls")){
			  wb=new HSSFWorkbook(inputStream);// to handle .xls type of files
		}else{
		wb=new XSSFWorkbook(inputStream);//to handle .xlsx type of files
		}
		
		// create sheet 
		Sheet sheet=wb.getSheet(sheetName);

		int rowcount=sheet.getLastRowNum()-sheet.getFirstRowNum();
		int columncount = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[rowcount][columncount];
		
		// getting value from excel	
		
		for(int i=0; i<rowcount;i++)
			 	{
					Row row=sheet.getRow(i+1);
					for(int j=0;j<row.getLastCellNum();j++)
						{
							Cell cell=row.getCell(j);
			  	        	data[i][j] = cell.getStringCellValue();
						}
			  	 }
		return data;
	}
}
