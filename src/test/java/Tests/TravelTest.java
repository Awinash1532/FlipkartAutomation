package Tests;

import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import Pages.TravelPage;
import Pages.Without_LoginProductPage;

public class TravelTest extends BaseTest {
	
	//---------------------------------ONE WAY TRAVEL SCENARIO
	
	@Test(priority=1,groups= {"travel"},enabled=true)
	public void OneWAYTravel_Check() {
		
		log.info("--------------One Way Travel Check Started--------------");
		extentTest= extent.startTest("Travel Functionality");
		Without_LoginProductPage wp = new Without_LoginProductPage(driver);
		wp.keybord_Escape();
		TravelPage ev = new TravelPage(driver);
		ev.Click_Travel();
		ev.Click_OneWay();
		ev.Select_From();
		ev.Select_To();
		ev.Depart_on_date();
		ev.select_travellers();
		ev.Click_Search();
		ev.assert_Onewayproduct();
		extentTest.log(LogStatus.PASS, "Travel Passed");
		extent.endTest(extentTest);
		log.info("--------------Travel Check Verified--------------");
		
	}
	
	//---------------------------------ROUND WAY TRAVEL SCENARIO	
	
	@Test(priority=2,groups= {"travel"},enabled=true)
	public void RoundWAYTravel_Check() {
		
		log.info("--------------Round Way Travel Check Started--------------");
		extentTest= extent.startTest("Travel Functionality");
		Without_LoginProductPage wp = new Without_LoginProductPage(driver);
		wp.keybord_Escape();
		TravelPage ev = new TravelPage(driver);
		ev.Click_Travel();
		ev.Click_TwoWay();
		ev.Select_From();
		ev.Select_To();
		ev.Depart_on_date();
		ev.Return_on_date();
		ev.select_travellers();
		ev.Click_Search();
		ev.assert_Twowayproduct();
		extentTest.log(LogStatus.PASS, "Travel Passed");
		extent.endTest(extentTest);
		log.info("--------------Travel Check Verified--------------");
		
	}
}
