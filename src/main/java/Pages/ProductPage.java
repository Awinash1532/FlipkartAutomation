package Pages;

import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProductPage {
	String ProPrice, FinalPrice = null;
	
	WebDriver driver;
	
	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver= driver;
	}
	
	/***************************************************LOCATORS**********************************************************/

	@FindBy(how=How.XPATH, using= "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/input[1]")
	private WebElement search;
	
	@FindBy(how=How.XPATH, using= "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/button[1]")
	private WebElement clicksearch;
	
	@FindBy(how=How.XPATH, using= "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/span[1]/span[1]")
	public WebElement verify;
	
	@FindBy(how=How.XPATH, using= "//div[contains(text(),'APPLE iPhone 12 (Green, 128 GB)')]")
	private WebElement product;
	
	@FindBy(how=How.XPATH, using= "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/button[1]")
	private WebElement addtocart;
	
	@FindBy(how=How.XPATH, using= "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[2]/div[1]/div[4]/div[1]/div[1]/div[1]")
	public WebElement productPrice;
	
	@FindBy(how=How.XPATH, using= "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[5]/div[1]/div[1]/a[1]/span[1]")
	private WebElement cart;
	
	@FindBy(how=How.XPATH, using= "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[5]/div[1]/div[1]/a[1]/div[1]")
	private WebElement d_cart;
	
	@FindBy(how=How.XPATH, using= "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[4]"
			+ "/div[1]/span[1]/div[1]/div[1]/span[1]")
	public WebElement billPrice;
	
	@FindBy(how=How.XPATH, using= "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]")
	private WebElement dlt;
	
	@FindBy(how=How.XPATH, using= "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]")
	private WebElement remov;
	
	
	/**********Page Actions for Product Page**********/
	
	/*****this is used to type in search bar*****/
	public void Enter_search(String type) {
		search.sendKeys(type,Keys.ENTER);
	}
	
	/*****this is used to assert searched product*****/
	public void assert_product() {
		Assert.assertTrue(verify.getText().contains("watch"));
	}
	
	//**Swipe DOWN, Hover & Multiple Windows Handle Functionality**/
	public void AddToCart() {
		String parentWindow = driver.getWindowHandle();
		Actions act = new Actions(driver);
		act.moveToElement(product);
		act.click().build().perform();
		Set<String> childWindow = driver.getWindowHandles();
		for(String child:childWindow) {
			if (!parentWindow.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
				ProPrice = productPrice.getText();
				act.moveToElement(addtocart);
				act.click().build().perform();
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
		cart.click();
		FinalPrice = billPrice.getText();
	}
	
	/*****this is used to verify initial & final price*****/
	public void assert_price() {
		Assert.assertTrue(ProPrice.equals(FinalPrice));
	}
	
	/*****this is used to click cart*****/
	public void click_cart() {
		d_cart.click();
	}
	
	/*****this is used to delete product*****/
	public void delete_product() {
		dlt.click();
	}
	
	/*****this is used to accept remove*****/
	public void Alert_remove() {
		remov.click();
	}
}
