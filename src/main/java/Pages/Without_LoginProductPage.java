package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.openqa.selenium.interactions.Action;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;

public class Without_LoginProductPage {
	
	WebDriver driver;
	
	public Without_LoginProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver= driver;
	}
	
	/***************************************************LOCATORS**********************************************************/

	@FindBy(how=How.NAME, using= "q")
	private WebElement product;
	
	@FindBy(how=How.XPATH, using= "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/span[1]/span[1]")
	private WebElement verify;
	
	
	/**********Page Actions for Without_LoginProduct Page**********/
	
	/*****this is used to Escape Login Notification*****/
	public void keybord_Escape() {
		Actions act = new Actions(driver);
		Action sendEsc = act.sendKeys(Keys.ESCAPE).build();
		sendEsc.perform();
	}
	
	/*****this is used to search Product & Click Enter*****/
	public void Enter_Product(String name) {
		product.sendKeys(name,Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	/*****this is used to verify search product*****/
	public void assert_product() {
		Assert.assertTrue(verify.getText().contains("apple laptops"));
	}
}
