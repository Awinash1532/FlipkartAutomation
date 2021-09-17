package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver= driver;
	}
	
	/***************************************************LOCATORS**********************************************************/

	@FindBy(how=How.XPATH, using= "//body/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/input[1]")
	private WebElement lognum;
	
	@FindBy(how=How.XPATH, using= "//body/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/input[1]")
	private WebElement logpas;
	
	@FindBy(how=How.XPATH, using= "//body/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[4]/button[1]")
	private WebElement login;
	
	@FindBy(how=How.XPATH, using= "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]")
	private WebElement verifylogin;
	
	@FindBy(how=How.XPATH, using= "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/span[2]/span[1]")
	public WebElement confirm;
	
	@FindBy(how=How.XPATH, using= "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/span[2]/span[1]")
	public WebElement finalconfirm;
	
		
	/**********Page Actions for Login Page**********/
	
	/*****this is used to enter Email/number*****/
	public void Enter_email(String num) {
		lognum.sendKeys(num);
	}
	
	/*****this is used to enter password*****/
	public void Enter_passwrd(String pass) {
		logpas.sendKeys(pass);
	}
	
	/*****this is used to click Login*****/
	public void clickLogin() {
		login.click();
	}
	
	/*****this is used to assert valid login*****/
	public void assert_login() {
		Assert.assertTrue(verifylogin.getText().equals("Awinash"));
	}
	
	/*****this is used to assert invalid Password login*****/
	public void assert_invalidpasswrd() {
		Assert.assertTrue(confirm.getText().contains("Your username or password is incorrect"));
	}
	
	/*****this is used to assert invalid Email & Password login*****/
	public void assert_allinvalid() {
		Assert.assertTrue(finalconfirm.getText().contains("Please enter valid Email ID/Mobile number"));
	}
}
