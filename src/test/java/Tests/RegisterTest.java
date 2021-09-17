package Tests;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Pages.RegisterPage;
import Utils.CheckTestExecution;

public class RegisterTest extends BaseTest {
	
	//---------------------------------REGISTER SCENARIO
	
	@Test(dataProvider = "RegisterData",priority=1,groups= {"register"},enabled=true)
	public void Register(String check) {
		
		log.info("...Execution Required...");
		CheckTestExecution.toCheckExecution(check);
		log.info("--------------Registration Started--------------");
		extentTest= extent.startTest("Register Functionality");
		RegisterPage rp = new RegisterPage(driver);
		rp.Click_create();
		rp.Enter_number(prop.getProperty("anumber"));
		rp.Click_continue();
		rp.Click_cross();
		rp.assert_Registration();
		extentTest.log(LogStatus.PASS, "Registration Done");
		extent.endTest(extentTest);
		log.info("--------------Registration done till OTP Asked--------------");
		
	}
}
