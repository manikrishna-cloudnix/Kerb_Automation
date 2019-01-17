package com.kerb.test.Scenarios;
import org.testng.annotations.Test;
import com.kerb.core.base.SupportTest;
import com.kerb.core.pages.HomePage;

public class HomePageTest extends SupportTest {
	@Test
	public void HomeTest() throws InterruptedException{
		HomePage HP=new HomePage(driver);
		HP.waitUntilSearchAppears();
		HP.findSpaceByUsingSearchOption();
		Thread.sleep(5000);
	}
	

}
