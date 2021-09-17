package Tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utils.Excel_DataProvider;
import Utils.Screenshots;

public class BaseTest extends Excel_DataProvider {
	
	// To initialize, select(Firefox(FF), chrome, IE), open and quit browser.
	public static WebDriver driver;
	
	public static Properties prop = new Properties();
	public static File file = new File(".\\Resources\\config.properties");
	public static FileInputStream fis = null;

	// Log4j logger
	public static Logger log = Logger.getLogger(BaseTest.class);

	// Extent Report
	public static ExtentReports extent = null;
	public static ExtentTest extentTest = null;

	// Creating and using properties file
	static { 

		// Exception Handling for FIS
		try {

			fis = new FileInputStream(file);
		}catch(FileNotFoundException e){

			log.error(e.getMessage());
		}

		// Exception Handling for Prop
		try {

			prop.load(fis);
		}catch(IOException e) {

			log.error(e.getMessage());
		}
	}
	
	/************************Extent Report***************************/
	@BeforeSuite(groups= {"address","extra","login","logout","product","register","offers","travel","withoutProduct"})
	public void setExtent() {
		extent= new ExtentReports(".\\Reports\\ExtentReport.html");
	}
	@AfterSuite(groups= {"address","extra","login","logout","product","register","offers","travel","withoutProduct"})
	public void  endReport() {
		extent.flush();
		extent.close();
	}
	
	/*************************Webdriver Initialized********************/
	@BeforeMethod(groups= {"address","extra","login","logout","product","register","offers","travel","withoutProduct"})
	public static void initWebdriver() {
		//For chromedriver (Google Chrome)
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			
			/************************************************Headless Mode***********************************************/
			if (prop.getProperty("Headless").equalsIgnoreCase("true")) {
				System.setProperty(prop.getProperty("chromeProperty"), prop.getProperty("chromeDriverPath"));
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				driver=new ChromeDriver(options);
				log.info("Chrome Initialized (Headless)");
			}
			else {
				
				/********************************************Non-Headless Mode*******************************************/
				System.setProperty(prop.getProperty("chromeProperty"), prop.getProperty("chromeDriverPath"));
				driver = new ChromeDriver();
				log.info("Chrome Opened");
				driver.manage().window().maximize();
			}
		}
		//for geckodriver (Firefox)
		else if (prop.getProperty("browser").equalsIgnoreCase("FF")) {
			
			/************************************************Headless Mode***********************************************/
			if (prop.getProperty("Headless").equalsIgnoreCase("true")) {
				System.setProperty(prop.getProperty("FirefoxProperty"), prop.getProperty("FirefoxDriverPath"));
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				driver = new FirefoxDriver(options);
				log.info("Firefox Initialized (Headless)");
			}
			else {
				
				/********************************************Non-Headless Mode*******************************************/
				System.setProperty(prop.getProperty("FirefoxProperty"), prop.getProperty("FirefoxDriverPath"));
				driver = new FirefoxDriver();
				log.info("Firefox Opened");
				driver.manage().window().maximize();
			}
		}
		//for IEDriverServer (Internet Explorer)
		else if (prop.getProperty("browser").equalsIgnoreCase("IE")) {
			
			/************************************************Headless Mode***********************************************/
			//Headless Mode Not Supported with Internet Explorer
			/********************************************Non-Headless Mode*******************************************/
			System.setProperty(prop.getProperty("IEProperty"), prop.getProperty("IEDriverPath"));
			driver = new InternetExplorerDriver();
			log.info("Internet Explorer Opened");
			driver.manage().window().maximize();
		}
		else
			System.out.println("Browser not supported. \nSuggested values are [chrome, FF, IE]");
			
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	/************************Open Browser************************/
	@BeforeMethod(groups= {"address","extra","login","logout","product","register","offers","travel","withoutProduct"})
	public static void openBrowser() {
			driver.get(prop.getProperty("url"));
			log.info("Application launched");
	}
	
	/************************Failed Screenshot***********************/
	@AfterMethod(groups= {"address","extra","login","logout","product","register","offers","travel","withoutProduct"})
	public void attachScreenhot(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
		String screenshotPath = Screenshots.captureScreenshot(driver , result.getName());
		extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
		}
		else if(result.getStatus()== ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, "Test case passed successfully");
		}
	}
	
	/**************************Close Browser*************************/
	@AfterMethod(groups= {"address","extra","login","logout","product","register","offers","travel","withoutProduct"})
	public static void closeBrowser() {
			driver.close();
	}
}
