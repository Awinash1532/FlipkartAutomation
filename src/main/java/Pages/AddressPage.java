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

public class AddressPage {
	
	WebDriver driver;
	
	public AddressPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver= driver;
	}
	
	/***************************************************LOCATORS**********************************************************/

	@FindBy(how=How.XPATH, using= "//div[contains(text(),'My Profile')]")
	private WebElement profile;
	
	@FindBy(how=How.XPATH, using= "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/a[2]/div[1]")
	private WebElement address;
	
	@FindBy(how=How.XPATH, using= "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")
	private WebElement Addaddress;
	
	@FindBy(how=How.XPATH, using= "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]"
			+ "/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/input[1]")
	private WebElement name;
	
	@FindBy(how=How.XPATH, using= "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]"
			+ "/div[1]/div[1]/form[1]/div[1]/div[2]/div[2]/input[1]")
	private WebElement number;
	
	@FindBy(how=How.XPATH, using= "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]"
			+ "/div[1]/div[1]/form[1]/div[1]/div[3]/div[1]/input[1]")
	private WebElement pin;
	
	@FindBy(how=How.XPATH, using= "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]"
			+ "/form[1]/div[1]/div[3]/div[2]/input[1]")
	private WebElement locality;
	
	@FindBy(how=How.XPATH, using= "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]"
			+ "/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/textarea[1]")
	private WebElement area;
	
	@FindBy(how=How.XPATH, using= "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]"
			+ "/div[1]/form[1]/div[1]/div[7]/div[1]/div[1]/label[1]/div[1]")
	private WebElement home;
	
	@FindBy(how=How.XPATH, using= "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]"
			+ "/form[1]/div[1]/div[8]/button[1]")
	private WebElement save;
	
	//---------------------------------Address Delete
	@FindBy(how=How.XPATH, using= "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]")
	private WebElement dothover;
	
	@FindBy(how=How.XPATH, using= "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]"
			+ "/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/span[1]")
	private WebElement delete;
	
	
	@FindBy(how=How.XPATH, using= "//button[contains(text(),'YES, DELETE')]")
	private WebElement accept;
	
	/**********Page Actions for Address Page**********/
	
	/*****this is used to click profile*****/
	public void click_profile() {
		profile.click();
	}
	
	/*****this is used to click address*****/
	public void click_addresses() {
		address.click();
	}
	
	/*****this is used to click Add address*****/
	public void click_Addaddress() {
		Addaddress.click();
	}
	
	/*****this is used to enter name*****/
	public void Enter_name(String nme) {
		name.sendKeys(nme);
	}
	
	/*****this is used to enter number*****/
	public void Enter_number(String num) {
		number.sendKeys(num);
	}
	
	/*****this is used to enter pincode*****/
	public void Enter_pincode(String pncd) {
		pin.sendKeys(pncd);
	}
	
	/*****this is used to enter locality*****/
	public void Enter_locality(String loc) {
		locality.sendKeys(loc);
	}
	
	/*****this is used to enter area & street*****/
	public void Enter_area(String arst) {
		area.sendKeys(arst);
	}
	
	/*****this is used to click home*****/
	public void click_home() {
		Actions act = new Actions(driver);
		act.moveToElement(home);
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]"
				+ "/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[7]/div[1]/div[1]/label[1]/div[1]")));
		act.click().build().perform();
	}
	
	/*****this is used to click save*****/
	public void click_save() {
		save.click();
	}
	
	//---------------------------------Address Delete
	
	/*****this is used to go to dots*****/
	public void dot_hover() {
		Actions act = new Actions(driver);
		act.moveToElement(dothover).perform();
	}
	
	/*****this is used to click delete*****/
	public void click_delete() {
		delete.click();
	}
	
	/*****this is used to accept delete*****/
	public void accept_delete() {
		accept.click();
	}
}
