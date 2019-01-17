package com.kerb.core.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.kerb.core.base.SupportTest;
import com.kerb.core.utils.TestUtil;

public class HomePage extends SupportTest {
	
	@FindBy(xpath="//input[@class= 'google-place-search-input form-control']")
	WebElement searchInput;

	@FindBy(xpath="//div[@class='pac-container pac-logo']/descendant::div[@class='pac-item']")
	List<WebElement> searchList;
	
	@FindBy(xpath="//button[text()='Find a space']")
	WebElement findSpaceBtn;

	@FindBy(xpath="//a[@href='/india/spaces']")
	WebElement findSpaceIcon;
	
	List<WebElement> list;
	WebElement Element;
	
	//Initialize Element
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void waitUntilSearchAppears() throws InterruptedException {
		Element = TestUtil.waitUntilClickable(searchInput, "xpath");
		
		searchInput.sendKeys("Brisbane");
	}
	
	public void findSpaceByUsingSearchOption() throws InterruptedException {
		for (int i = 0; i < searchList.size(); i++) {
			String expectedValue = searchList.get(i).getText();
			System.out.println("expectedValue="+searchList.get(i).getText());
			if( i==0 && expectedValue.equalsIgnoreCase("Brisbane CityQLD, Australia") ) {
				searchList.get(i).click();
				findSpaceBtn.click();
				break;
			}	
		}
		
	}
	
}
