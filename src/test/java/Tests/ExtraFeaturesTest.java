package Tests;

import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import Pages.ExtraFeaturesPage;
import Pages.TopOffersPage;

public class ExtraFeaturesTest extends BaseTest {
	
	//---------------------------------SECURITY POLICY SCENARIO
	
	@Test(priority=1,groups= {"extra"},enabled=true)
	public void Security_Policy() {
		
		log.info("--------------Security Policy Check--------------");
		extentTest= extent.startTest("Security Check Functionality");
		TopOffersPage top = new TopOffersPage(driver);
		top.Click_cancel();
		ExtraFeaturesPage ef = new ExtraFeaturesPage(driver);
		ef.Click_security();
		extentTest.log(LogStatus.PASS, "Security Policy Verfied");
		extent.endTest(extentTest);
		log.info("--------------Security Policy Passed--------------");
	}
	
	//---------------------------------FLIPKART STORIES SCENARIO
	
	@Test(priority=2,groups= {"extra"},enabled=true)
	public void Flipkart_Stories() {
		
		log.info("--------------Flipkart Stories Check--------------");
		extentTest= extent.startTest("Flipkart Stories Functionality");
		TopOffersPage top = new TopOffersPage(driver);
		top.Click_cancel();
		ExtraFeaturesPage ef = new ExtraFeaturesPage(driver);
		ef.Click_Story();
		extentTest.log(LogStatus.PASS, "Flipkart Stories Verfied");
		extent.endTest(extentTest);
		log.info("--------------Flipkart Stories Passed--------------");
	}
	
	//---------------------------------SIGNUP UP SCENARIO
	
	@Test(priority=3,groups= {"extra"},enabled=true)
	public void Signup() {
		
		log.info("--------------Signup Check--------------");
		extentTest= extent.startTest("Signup Functionality");
		TopOffersPage top = new TopOffersPage(driver);
		top.Click_cancel();
		ExtraFeaturesPage ef = new ExtraFeaturesPage(driver);
		ef.hover_login();
		ef.Click_Signup();
		ef.assert_Signup();
		extentTest.log(LogStatus.PASS, "Signup Verfied");
		extent.endTest(extentTest);
		log.info("--------------Signup Passed--------------");
	}
	
	//---------------------------------CUSTOMER CARE (Other Issues) SCENARIO
	
	@Test(priority=4,groups= {"extra"},enabled=true)
	public void Other_Issue() {
		
		log.info("--------------Issue Check--------------");
		extentTest= extent.startTest("Issue Check Functionality");
		TopOffersPage top = new TopOffersPage(driver);
		top.Click_cancel();
		ExtraFeaturesPage ef = new ExtraFeaturesPage(driver);
		ef.hover_More();
		ef.Click_Customer_Care();
		ef.Click_Other_Issue();
		extentTest.log(LogStatus.PASS, "Issue Check Verfied");
		extent.endTest(extentTest);
		log.info("--------------Issue Passed--------------");
		
	}
}
