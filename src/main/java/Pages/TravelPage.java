package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TravelPage {
	
	WebDriver driver;
	
	public TravelPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver= driver;
	}
	
	/***************************************************LOCATORS**********************************************************/

	@FindBy(how=How.XPATH, using= "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[8]/a[1]/div[2]")
	private WebElement clickTravel;
	
	@FindBy(how=How.XPATH, using= "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/label[1]/div[1]")
	private WebElement oneway;
	
	@FindBy(how=How.XPATH, using= "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/label[2]/div[1]")
	private WebElement twoway;
	
	@FindBy(how=How.XPATH, using= "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]"
			+ "/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	private WebElement fromdrop;
	
	@FindBy(how=How.XPATH, using= "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]"
			+ "/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/span[1]")
	private WebElement clickfromdrop;
	
	@FindBy(how=How.XPATH, using= "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]"
			+ "/form[1]/div[1]/div[1]/div[3]/div[1]/div[1]/input[1]")
	private WebElement todrop;
	
	@FindBy(how=How.XPATH, using= "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[6]")
	private WebElement clicktodrop;
	
	@FindBy(how=How.XPATH, using= "//tbody/tr[5]/td[4]/div[1]/button[1]")
	private WebElement d_date;
	
	@FindBy(how=How.XPATH, using= "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]"
			+ "/form[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/table[2]/tbody[1]/tr[2]/td[1]/div[1]/button[1]")
	private WebElement r_date;
	
	@FindBy(how=How.XPATH, using= "//button[contains(text(),'Done')]")
	private WebElement travellerdone;
	
	@FindBy(how=How.XPATH, using= "//span[contains(text(),'SEARCH')]")
	private WebElement search;
	
	@FindBy(how=How.XPATH, using= "//div[contains(text(),'27 Oct, Wed')]")
	private WebElement v_oneway;
	
	@FindBy(how=How.XPATH, using= "/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/span[2]")
	private WebElement v_twoway1;
	
	@FindBy(how=How.XPATH, using= "/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/span[2]")
	private WebElement v_twoway2;
		
	
	/**********Page Actions for Travel Page**********/
	
	/*****this is used to click Travel*****/
	public void Click_Travel() {
		clickTravel.click();
	}
	
	/*****this is used to click Two Way*****/
	public void Click_TwoWay() {
		twoway.click();
	}
	
	/*****this is used to click One Way*****/
	public void Click_OneWay() {
		oneway.click();
	}
	
	/*****this is used to Select From*****/
	public void Select_From() {
		fromdrop.click();
		clickfromdrop.click();
	}
	
	/*****this is used to Select To*****/
	public void Select_To() {
		todrop.click();
		clicktodrop.click();
	}
	
	/*****this is used to Depart On Date*****/
	public void Depart_on_date() {
		d_date.click();
	}
	
	/*****this is used to Return On Date*****/
	public void Return_on_date() {
		r_date.click();
	}
	
	/*****this is used to select Travellers*****/
	public void select_travellers() {
		travellerdone.click();
	}
	
	/*****this is used to click search*****/
	public void Click_Search() {
		search.click();
	}
	
	/*****this is used to OneWay verify*****/
	public void assert_Onewayproduct() {
		Assert.assertTrue(v_oneway.getText().contains("27 Oct, Wed"));
	}
	
	/*****this is used to Twoway verify*****/
	public void assert_Twowayproduct() {
		Assert.assertTrue(v_twoway1.getText().contains("27 Oct, Wed"));
		Assert.assertTrue(v_twoway2.getText().contains("07 Nov, Sun"));
	}
}
