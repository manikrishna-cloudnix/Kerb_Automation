package com.kerb.core.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.kerb.core.base.SupportTest;
import com.kerb.core.utils.TestUtil;

public class FindSpacePage extends SupportTest {
	@FindBy(xpath="//span[text()='Find a space']")
	WebElement findASpaceIcon;
	
	@FindBy(xpath="//h1[text()='Find a space in Bengaluru, India']")
	WebElement mainHeaderTxt;
	
	@FindBy(xpath="//a[@href='/india/lease-space']")
	WebElement leaseSpaceIcon;
	
	public FindSpacePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnFindASpaceTab() throws InterruptedException {
		findASpaceIcon.click();
		TestUtil.showLog(FindSpacePage.class.getName(), "Find a Space Tab Clicked");
		Thread.sleep(5000);
	TestUtil.scrollTill(driver,mainHeaderTxt);
	
	}
	
	public void verifyFindSpaceHeadingisAppearOrNot() {
		SoftAssert s=new SoftAssert();
		System.out.println("Heading of this page --->"+mainHeaderTxt.getText());
		s.assertEquals(mainHeaderTxt.getText(), "Find a space in Bengaluru, India");
		s.assertAll();
		
	}
	
}
