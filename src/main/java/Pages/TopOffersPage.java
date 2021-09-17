package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TopOffersPage {
	
	WebDriver driver;
	
	public TopOffersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver= driver;
	}
	
	/***************************************************LOCATORS**********************************************************/

	@FindBy(how=How.XPATH, using= "//button[contains(text(),'✕')]")
	private WebElement cancel;
	
	@FindBy(how=How.XPATH, using= "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]/div[2]")
	private WebElement topOffer;
	
	@FindBy(how=How.XPATH, using= "//h2[contains(text(),'Deals of the Day')]")
	private WebElement v_top;
	
	//****************Electronics Check
	@FindBy(how=How.XPATH, using= "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[5]/a[1]/div[2]/div[1]/div[1]")
	private WebElement elec;
	
	@FindBy(how=How.LINK_TEXT, using= "Cameras & Accessories")
	private WebElement cameraMenu;
	
	@FindBy(how=How.LINK_TEXT, using= "DSLR & Mirrorless")
	private WebElement Clicksubmenu;
	
	@FindBy(how=How.XPATH, using= "//h1[contains(text(),'DSLR & Mirrorless')]")
	private WebElement v_page;
	
	
	/**********Page Actions for TopOffers Page**********/
	
	/*****this is used to click cancel*****/
	public void Click_cancel() {
		cancel.click();
	}
	
	/*****this is used to click TopOffers*****/
	public void Click_offers() {
		topOffer.click();
	}
	
	/*****this is used to verify the page*****/
	public void assert_page() {
		Assert.assertTrue(v_top.getText().equals("Deals of the Day"));
	}
	
	//****************Electronics Check
	
	/*****this is used to Hover Electronics*****/
	public void hover_Electronics() {
		Actions act = new Actions(driver);
		act.moveToElement(elec).perform();
	}
	
	/*****this is used to Hover SubMenu*****/
	public void hover_electronic_Submenu() {
		Actions act = new Actions(driver);
		act.moveToElement(cameraMenu).perform();
	}
	
	/*****this is used to Click SubMenu*****/
	public void Click_electronic_Submenu() {
		Actions act = new Actions(driver);
		act.moveToElement(Clicksubmenu).click().build().perform();
	}
	
	/*****this is used to verify page*****/
	public void assert_Camerapage() {
		Assert.assertTrue(v_page.getText().equals("DSLR & Mirrorless"));
	}

}
