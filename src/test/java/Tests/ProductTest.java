package Tests;

import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;

import Pages.LoginPage;
import Pages.ProductPage;
import Utils.CheckTestExecution;

public class ProductTest extends BaseTest {
	
	//---------------------------------SEARCH PRODUCT WITH LOGIN SCENARIO
	
	@Test(dataProvider = "ProductData",priority=1,groups= {"product"},enabled=true)
	public void SearchProduct(String usrnme,String passwrd,String product, String check) {
		
		log.info("...Execution Required...");
		CheckTestExecution.toCheckExecution(check);
		log.info("--------------Product Search Started--------------");
		extentTest= extent.startTest("Product Functionality");
		LoginPage l = new LoginPage(driver);
		l.Enter_email(usrnme);
		l.Enter_passwrd(passwrd);
		l.clickLogin();
		ProductPage pro = new ProductPage(driver);
		pro.Enter_search(product);
		pro.assert_product();
		extentTest.log(LogStatus.PASS, "Product Searched");
		extent.endTest(extentTest);
		log.info("--------------Product Found--------------");
		
	}
	
	//---------------------------------ADD PRODUCT TO CART WITH LOGIN SCENARIO
	
	@Test(dataProvider = "ADDtoCartData",priority=2,groups= {"product"},enabled=true)
	public void ADDtoCart(String usrnme,String passwrd,String product, String check) {
		
		log.info("...Execution Required...");
		CheckTestExecution.toCheckExecution(check);
		log.info("--------------Product Search Started--------------");
		extentTest= extent.startTest("Product Functionality");
		LoginPage l = new LoginPage(driver);
		l.Enter_email(usrnme);
		l.Enter_passwrd(passwrd);
		l.clickLogin();
		ProductPage pro = new ProductPage(driver);
		pro.Enter_search(product);
		pro.AddToCart();
		pro.assert_price();
		extentTest.log(LogStatus.PASS, "Product Added to Cart");
		extent.endTest(extentTest);
		log.info("--------------Product Found--------------");
		
	}
	
	//---------------------------------DELETE PRODUCT FROM CART WITH LOGIN SCENARIO
	
	@Test(dataProvider = "DeleteFromCartData",priority=3,groups= {"product"},enabled=true)
	public void DeleteFromCart(String usrnme,String passwrd,String check) {
		
		log.info("...Execution Required...");
		CheckTestExecution.toCheckExecution(check);
		log.info("--------------Product Deletion Started--------------");
		extentTest= extent.startTest("Cart Deletion Functionality");
		LoginPage l = new LoginPage(driver);
		l.Enter_email(usrnme);
		l.Enter_passwrd(passwrd);
		l.clickLogin();
		ProductPage pro = new ProductPage(driver);
		pro.click_cart();
		pro.delete_product();
		pro.Alert_remove();
		extentTest.log(LogStatus.PASS, "Product Deleted");
		extent.endTest(extentTest);
		log.info("--------------Product Deleted--------------");
		
	}
}