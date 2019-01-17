package com.kerb.core.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.kerb.core.base.SupportTest;
import com.kerb.core.utils.TestUtil;

public class LeaseSpacePage extends SupportTest {
	@FindBy(xpath="//span[text()='Lease a space']")
	WebElement leaseASpaceIcon;
	
	@FindBy(xpath="//h1[contains(text(),'Kerb to make income every month')]")
	WebElement mainHeaderTxt;
	

	@FindBy(xpath="//a[@href='/india/bookings']")
	WebElement bookingsIcon;
	
	public LeaseSpacePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnLeaseASpaceTab() throws InterruptedException {
		leaseASpaceIcon.click();
		TestUtil.showLog(LeaseSpacePage.class.getName(), "Lease space Tab Clicked");
		Thread.sleep(5000);
	}
	
	public void verifyLeaseHeadingisAppearOrNot() {
		System.out.println("Heading of this page -->"+mainHeaderTxt.getText());
		SoftAssert s=new SoftAssert();
		s.assertEquals(mainHeaderTxt.getText(), "List your empty parking space or boat mooring on Kerb to make income every month");
		s.assertAll();
		
	}
		
}
