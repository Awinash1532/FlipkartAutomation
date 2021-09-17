package Tests;

import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import Pages.AddressPage;
import Pages.LoginPage;
import Pages.LogoutPage;
import Utils.CheckTestExecution;

public class AddressTest extends BaseTest {
	
	//---------------------------------ADD ADDRESS SCENARIO
	
	@Test(dataProvider = "Add_Address",priority = 1,groups= {"address"},enabled=true)
	public void add_Address(String usrnme,String passwrd,String check,String name,String locality, String area) {
		
		log.info("...Execution Required...");	
		CheckTestExecution.toCheckExecution(check);
		log.info("--------------Add Address--------------");
		extentTest= extent.startTest("Add Address Functionality");
		LoginPage lo = new LoginPage(driver);
		lo.Enter_email(usrnme);
		lo.Enter_passwrd(passwrd);
		lo.clickLogin();
		LogoutPage l = new LogoutPage(driver);
		l.Hover_accountMenu();
		AddressPage ad = new AddressPage(driver);
		ad.click_profile();
		ad.click_addresses();
		ad.click_Addaddress();
		ad.Enter_name(name);
		ad.Enter_number(prop.getProperty("number"));
		ad.Enter_pincode(prop.getProperty("pincode"));
		ad.Enter_locality(locality);
		ad.Enter_area(area);
		ad.click_home();
		ad.click_save();
		extentTest.log(LogStatus.PASS, "Address added Successful");
		extent.endTest(extentTest);
		log.info("--------------Address Added--------------");
		
	}
	
	//---------------------------------DELETE ADDRESS SCENARIO
	
	@Test(dataProvider = "Delete_Address",priority = 2,groups= {"address"},enabled=true)
	public void delete_address(String usernme,String paswrd,String check) {
		
		log.info("...Execution Required...");		
		CheckTestExecution.toCheckExecution(check);
		log.info("--------------Address Deletion--------------");
		extentTest= extent.startTest("Address Functionality");
		LoginPage lo = new LoginPage(driver);
		lo.Enter_email(usernme);
		lo.Enter_passwrd(paswrd);
		lo.clickLogin();
		LogoutPage l = new LogoutPage(driver);
		l.Hover_accountMenu();
		AddressPage ad = new AddressPage(driver);
		ad.click_profile();
		ad.click_addresses();
		ad.dot_hover();
		ad.click_delete();
		ad.accept_delete();
		extentTest.log(LogStatus.PASS, "Address deleted Successful");
		extent.endTest(extentTest);
		log.info("--------------Address Deleted--------------");
		
	}
}
