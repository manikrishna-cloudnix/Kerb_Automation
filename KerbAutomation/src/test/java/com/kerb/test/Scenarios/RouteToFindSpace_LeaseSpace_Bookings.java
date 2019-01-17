package com.kerb.test.Scenarios;

import org.testng.annotations.Test;

import com.kerb.core.base.SupportTest;
import com.kerb.core.pages.BookingsPage;
import com.kerb.core.pages.FindSpacePage;
import com.kerb.core.pages.LeaseSpacePage;

public class RouteToFindSpace_LeaseSpace_Bookings extends SupportTest {
	FindSpacePage FSP;
	LeaseSpacePage LSP;
	BookingsPage BP;
	
	@Test()
	public void routeToFindSpace_LeaseSpace_Bookings() throws InterruptedException{
		FSP = new FindSpacePage(driver);
		FSP.clickOnFindASpaceTab();
		FSP.verifyFindSpaceHeadingisAppearOrNot();
		LSP=new LeaseSpacePage(driver);
		LSP.clickOnLeaseASpaceTab();
		LSP.verifyLeaseHeadingisAppearOrNot();
		BP=new BookingsPage(driver);
		BP.clickOnBookingsTab();
		BP.verifyBookingsHeadingisAppearOrNot();
	}
	
	

}
