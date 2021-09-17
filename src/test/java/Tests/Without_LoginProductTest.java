package Tests;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Pages.Without_LoginProductPage;

public class Without_LoginProductTest extends BaseTest {
	
	//---------------------------------PRODUCT SEARCH WITHOUT LOGIN SCENARIO
	
	@Test(priority=1,groups= {"withoutProduct"},enabled=true)
	public void Product_Search() {
		
		log.warn("--------------WithOut Login Product Search--------------");
		extentTest= extent.startTest("WithOut Login Search Functionality");
		Without_LoginProductPage wp = new Without_LoginProductPage(driver);
		wp.keybord_Escape();
		wp.Enter_Product("apple laptops");
		wp.assert_product();
		extentTest.log(LogStatus.PASS, "Without Login Product searched");
		extent.endTest(extentTest);
		log.info("--------------Product searched and verified--------------");
		
	}
}
