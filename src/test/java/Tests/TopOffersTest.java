package Tests;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Pages.TopOffersPage;

public class TopOffersTest extends BaseTest {
	
	//---------------------------------TOPOFFERS CHECK SCENARIO
	
	@Test(priority=1,groups= {"offers"},enabled=true)
	public void TopOffers_check() {
		
		log.info("--------------TopOffers Check--------------");
		extentTest= extent.startTest("TopOffers Check Functionality");
		TopOffersPage top = new TopOffersPage(driver);
		top.Click_cancel();
		top.Click_offers();
		top.assert_page();
		extentTest.log(LogStatus.PASS, "TopOffers Running");
		extent.endTest(extentTest);
		log.info("--------------TopOffers Running and verified--------------");
		
	}
	
	//---------------------------------ELECTRONICS CHECK SCENARIO
	
	@Test(priority=2,groups= {"offers"},enabled=true)
	public void Check_Electronics() {
		
		log.info("--------------Electronics Menu Check--------------");
		extentTest= extent.startTest("Electronics Menu Click Functionality");
		TopOffersPage to = new TopOffersPage(driver);
		to.Click_cancel();
		to.hover_Electronics();
		to.hover_electronic_Submenu();
		to.Click_electronic_Submenu();
		to.assert_Camerapage();
		extentTest.log(LogStatus.PASS, "Electronics Click Verified");
		extent.endTest(extentTest);
		log.info("--------------Electronics Menu Running and verified--------------");
		
	}
}
