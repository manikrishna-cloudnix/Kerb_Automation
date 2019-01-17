package com.kerb.core.pages;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.kerb.core.base.SupportTest;
import com.kerb.core.utils.TestUtil;

public class BookingsPage extends SupportTest {
	@FindBy(xpath="//span[text()='Bookings']")
	WebElement bookings;
	
	@FindBy(xpath="//*[contains(text(),'made any bookings')]")
	WebElement mainHeaderTxt;
	
	public BookingsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnBookingsTab() throws InterruptedException {
		bookings.click();
		TestUtil.showLog(BookingsPage.class.getName(), "Booking Tab Clicked");
		Thread.sleep(5000);
	}
	
	public void verifyBookingsHeadingisAppearOrNot() {
		System.out.println("Main Header ->>"+mainHeaderTxt.getText());
		SoftAssert s=new SoftAssert();
		s.assertEquals(mainHeaderTxt.getText(), "You haven't made any bookings");
		s.assertAll();
	}

}
