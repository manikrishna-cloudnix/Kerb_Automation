package com.kerb.core.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.kerb.core.base.SupportTest;

public class TestUtil extends SupportTest {


	static Workbook book;
	static Sheet sheet;
	static JavascriptExecutor js;
	static int i = 0;
	WebDriverWait wait;
//	public void switchToFrame() {
//		driver.switchTo().frame("mainpanel");
//	}
	
	public static void scrollTill(WebDriver driver, WebElement element) {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		
	}
	
	
	public static WebElement waitUntilClickable(WebElement Element, String type) throws InterruptedException {
		
		String ElementValue = Element.toString().split(type+":")[1];
		ElementValue = ElementValue.substring(0, ElementValue.length() - 1);
		System.out.println("ElementValue="+ElementValue);
		Element = new WebDriverWait( driver, 50).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ElementValue)));
		while(true) {
			if(Element.isDisplayed()) break;
			driver.navigate().refresh();
			Element = new WebDriverWait( driver, 50).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ElementValue)));
			i++;
			Thread.sleep(1000);
		}
		
		return Element;
	}
	
	public static Workbook wb;
	public static String getCellValue(String sheet, int row, int column)
	{
		String getCellValue = "";
		
		try {
		 wb=WorkbookFactory.create(new FileInputStream(EXCEL_PATH));
		getCellValue=	wb.getSheet(sheet).getRow(row).getCell(column).toString();
		} catch (Exception e)
		{
			
		}
		return getCellValue;
	
	
	}
	public static int getRowCount(String sheet)
	{
		int rowcount = 0;
		
		try {
		 wb=WorkbookFactory.create(new FileInputStream(EXCEL_PATH));
		rowcount=	wb.getSheet(sheet).getLastRowNum();
		} catch (Exception e)
		{
			
		}
		return rowcount;
	
	
	}
	
	public static void showLog(String className, String message)
	{
		Logger log = Logger.getLogger(className);
		log.info(message);
	}
	
public static void captureScreenShot(WebDriver driver, String testMethodName) 
	
	{
		
		try {
			Date d=new Date();
			String currentDate=d.toString().replaceAll(":", "_");
			TakesScreenshot ts=(TakesScreenshot) driver;
			File srcFile=ts.getScreenshotAs(OutputType.FILE);
			File destFile=new File(SNAPSHOT_PATH+testMethodName+"_"+currentDate+".png");
			FileUtils.copyFile(srcFile, destFile);
		} catch (Exception e) {
			
			
		}
		
	}

	public static String getPropertyValue(String key) {
		String propertyValue = "";
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(CONFIG_PATH));
			propertyValue = prop.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return propertyValue;
	}

}
