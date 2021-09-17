package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ExtraFeaturesPage {
	
	WebDriver driver;
	
	public ExtraFeaturesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver= driver;
	}
	
	/***************************************************LOCATORS**********************************************************/

	@FindBy(how=How.LINK_TEXT, using= "Security")
	private WebElement sec;
	
	//---------------------------------Flipkart Stories
	@FindBy(how=How.LINK_TEXT, using= "Flipkart Stories")
	private WebElement story;
	
	//---------------------------------Sign UP
	@FindBy(how=How.LINK_TEXT, using= "Login")
	private WebElement login;
	
	@FindBy(how=How.XPATH, using= "//div[contains(@class, '_3wJI0x')]")
	private WebElement signup;
	
	@FindBy(how=How.XPATH, using= "//span[contains(text(),\"Looks like you're new here!\")]")
	private WebElement v_login;
	
	//---------------------------------Customer Care
	@FindBy(how=How.XPATH, using= "//div[contains(@class, 'exehdJ')]")
	private WebElement more;
	
	@FindBy(how=How.XPATH, using= "//div[contains(text(),'24x7 Customer Care')]")
	private WebElement cust;
	
	@FindBy(how=How.XPATH, using= "//span[contains(text(),'Help with other issues')]")
	private WebElement issue;
	
	/**********Page Actions for ExtraFeatures Page**********/
	
	/*****this is used to click Security Policy from end of the page*****/
	public void Click_security() {
		Actions act = new Actions(driver);
		act.moveToElement(sec).click().build().perform();
	}
	
	//---------------------------------Flipkart Stories
	
	/*****this is used to click Flipkart Stories from end of the page*****/
	public void Click_Story() {
		Actions act = new Actions(driver);
		act.moveToElement(story).click().build().perform();
	}
	
	//---------------------------------Sign UP
	
	/*****this is used to hover login Menu*****/
	public void hover_login() {
		Actions act = new Actions(driver);
		act.moveToElement(login).perform();
	}
	
	/*****this is used to click signup*****/
	public void Click_Signup() {
		Actions act = new Actions(driver);
		act.moveToElement(signup).click().build().perform();
	}
	
	/*****this is used to verify signup*****/
	public void assert_Signup() {
		Assert.assertTrue(v_login.getText().contains("Looks like you're new here!"));
	}
	
	//---------------------------------Customer Care
	
	/*****this is used to hover More Menu*****/
	public void hover_More() {
		more.click();
	}
	
	/*****this is used to hover click Customer Care*****/
	public void Click_Customer_Care() {
		Actions act = new Actions(driver);
		act.moveToElement(cust).click().build().perform();
	}
	
	/*****this is used to Click Other Issue*****/
	public void Click_Other_Issue() {
		issue.click();
	}
	
}
