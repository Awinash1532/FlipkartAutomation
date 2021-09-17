package Tests;

import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import Pages.LoginPage;
import Utils.CheckTestExecution;

public class LoginTest extends BaseTest {
	
	//---------------------------------VALID LOGIN SCENARIO
	
	@Test(dataProvider = "Logindata",priority = 1,groups= {"login"},enabled=true)
	public void ValidLogin(String Username, String Password, String check) {
		
		log.info("...Execution Required...");		
		CheckTestExecution.toCheckExecution(check);
		log.info("--------------Login Started--------------");
		extentTest= extent.startTest("Login Credentials");
		LoginPage l = new LoginPage(driver);
		l.Enter_email(Username);
		l.Enter_passwrd(Password);
		l.clickLogin();
		l.assert_login();
		extentTest.log(LogStatus.PASS, "Login Successful");
		extent.endTest(extentTest);
		log.info("--------------Login Complete--------------");
		
	}
	
	//-----------------------INVALID LOGIN SCENARIO (Case 1: Password Wrong (This is Negative Scenario, Assertion Pass))
	//--------------------------INVALID LOGIN SCENARIO (Case 2: Email Wrong (This is Negative Scenario, Assertion Fail))
	//----------INVALID LOGIN SCENARIO (Case 3: Email & Password Both Wrong (This is Negative Scenario, Assertion Fail))
	
	@Test(dataProvider = "InvalidData",priority = 2,groups= {"login"},enabled=true)
	public void InvalidLogin(String Username, String Password, String check) {
		
		log.info("...Execution Required...");		
		CheckTestExecution.toCheckExecution(check);
		log.warn("--------------Invalid Login Started--------------");
		extentTest= extent.startTest("Login Credentials");
		LoginPage l = new LoginPage(driver);
		l.Enter_email(Username);
		l.Enter_passwrd(Password);
		l.clickLogin();
		l.assert_invalidpasswrd();
		extentTest.log(LogStatus.PASS, "Invalid, Login Unsuccessful");
		extent.endTest(extentTest);
		log.info("--------------Invalid Login Verified--------------");
		
	}
	
	//---------------------------------INVALID LOGIN SCENARIO (NO ID/PASSWORD GIVEN)
	
	@Test(dataProvider = "No_ID_Passwrd_InvalidData",priority = 3,groups= {"login"},enabled=true)
	public void No_ID_Passwrd_InvalidLogin(String check) {
		
		log.info("...Execution Required...");		
		CheckTestExecution.toCheckExecution(check);
		log.warn("--------------Invalid Login Started--------------");
		extentTest= extent.startTest("Login Credentials");
		LoginPage l = new LoginPage(driver);
		l.clickLogin();
		l.assert_allinvalid();
		extentTest.log(LogStatus.PASS, "No Email & Password Passed, Login Unsuccessful");
		extent.endTest(extentTest);
		log.info("--------------Invalid Login Verified--------------");
		
	}
}
