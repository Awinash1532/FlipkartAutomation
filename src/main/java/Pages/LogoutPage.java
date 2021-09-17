package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LogoutPage {
	
WebDriver driver;
	
	public LogoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver= driver;
	}
	
	/***************************************************LOCATORS**********************************************************/

	@FindBy(how=How.XPATH, using= "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]")
	private WebElement hover;
	
	@FindBy(how=How.XPATH, using= "//div[contains(text(),'Logout')]")
	private WebElement logout;
	
	@FindBy(how=How.LINK_TEXT, using= "Login")
	private WebElement verify;
	
	
	/**********Page Actions for Logout Page**********/
	
	/*****this is used to hover to logout*****/
	public void Hover_accountMenu() {
		Actions act = new Actions(driver);
		act.moveToElement(hover).perform();
	}
	
	/*****this is used to click logout*****/
	public void click_logout() {
		Actions act = new Actions(driver);
		act.moveToElement(logout);
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Logout')]")));
		act.click().build().perform();
	}
	
	/*****this is used to verify Logout*****/
	public void assert_logout() {
		Assert.assertTrue(verify.getText().contains("Login"));
	}
}
