package com.kerb.core.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.kerb.core.utils.TestUtil;

public class SupportTest implements IAutoConstant {
	
	public static WebDriver driver;
	public static Properties prop;
	public static String projDir = System.getProperty("user.dir");
	static {
		
		System.setProperty(GECKO_KEY, GECKO_PATH);
		System.setProperty(CHROME_KEY, CHROME_PATH);
	}
	
	@BeforeMethod
	public void initialization(){
		String browserName = TestUtil.getPropertyValue("browser");
		if(browserName.equals("chrome")){
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("FF")){
			driver = new FirefoxDriver(); 
		}
		
		String timeout=TestUtil.getPropertyValue("pageLoadTimout");
		driver.manage().timeouts().implicitlyWait(Long.parseLong(timeout), TimeUnit.SECONDS);
		driver.manage().window().maximize();
		String implicitWait = TestUtil.getPropertyValue("implicit_wait");
		driver.manage().timeouts().implicitlyWait(Long.parseLong(implicitWait), TimeUnit.SECONDS);
		String url = TestUtil.getPropertyValue("url");
		driver.get(url);
		
	}
	
	@AfterMethod
	public void closeApplication(ITestResult res)
	{
		if(ITestResult.FAILURE==res.getStatus()) 
		{
		TestUtil.captureScreenShot(driver, res.getName());	
		}
		driver.quit();
	}
}
