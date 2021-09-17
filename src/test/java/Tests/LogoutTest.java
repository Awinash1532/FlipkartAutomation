package Tests;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Pages.LoginPage;
import Pages.LogoutPage;
import Utils.CheckTestExecution;

public class LogoutTest extends BaseTest {
	
	//---------------------------------LOGOUT SCENARIO
	
	@Test(dataProvider = "LogoutData",priority=1,groups= {"logout"},enabled=true)
	public void logout(String usrnme,String passwrd,String check) {
		
		log.info("...Execution Required...");
		CheckTestExecution.toCheckExecution(check);
		log.warn("--------------Logout Started--------------");
		extentTest= extent.startTest("Logout Functionality");
		LoginPage l = new LoginPage(driver);
		l.Enter_email(usrnme);
		l.Enter_passwrd(passwrd);
		l.clickLogin();
		LogoutPage lo = new LogoutPage(driver);
		lo.Hover_accountMenu();
		lo.click_logout();
		lo.assert_logout();
		extentTest.log(LogStatus.PASS, "Logout Successful");
		extent.endTest(extentTest);
		log.info("--------------Logout Sucessful--------------");
		
	}
}
