package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RegisterPage {
	
	WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver= driver;
	}
	
	/***************************************************LOCATORS**********************************************************/

	@FindBy(how=How.XPATH, using= "//a[contains(text(),'New to Flipkart? Create an account')]")
	private WebElement create;
	
	@FindBy(how=How.XPATH, using= "//input[@class='_2IX_2- VJZDxU']")
	private WebElement number;
	
	@FindBy(how=How.XPATH, using= "//span[contains(text(),'CONTINUE')]")
	private WebElement contnue;
	
	@FindBy(how=How.XPATH, using= "//button[contains(text(),'✕')]")
	private WebElement cancel;
	
	@FindBy(how=How.LINK_TEXT, using= "Login")
	private WebElement verify;
	
	
	/**********Page Actions for Register Page**********/
	
	/*****this is used to click Create an Account*****/
	public void Click_create() {
		create.click();
	}
	
	/*****this is used to enter number*****/
	public void Enter_number(String num) {
		number.sendKeys(num);
	}
	
	/*****this is used to click continue*****/
	public void Click_continue() {
		contnue.click();
	}
	
	/*****this is used to click cancel*****/
	public void Click_cross() {
		cancel.click();
	}
	
	/*****this is used to assert cancel Login*****/
	public void assert_Registration() {
		Assert.assertTrue(verify.getText().contains("Login"));
	}
}
