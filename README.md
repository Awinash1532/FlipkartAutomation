# Flipkart Web Automation
* Link **https://www.flipkart.com/**

## ABOUT
* This project follows Page Object Model Design.
* This Project was designed on Windows using Eclipse, Selenium, Maven, TestNG.
* This Project is designed to run in various Browsers like Google Chrome, Firefox, Internet Explorer in both Headless and Non-Headless Mode.

## SETUP
#### Dependencies:
>* Selenium Maven Dependency » 3.141.59
* TestNG Maven Dependency » 6.14.3
* Relevantcodes Maven Dependency » 2.41.2
* Commons io Maven Dependency » 2.8.0
* JUnit » 4.11
* Apache POI » 4.1.1
* Apache Log4j » 1.2.17

#### Pulgin:
>* surefire maven plugin » 32.22.1

#### Drivers:
>* chromedriver.exe
* geckodriver.exe
* IEDriverServer.exe

## TABLE OF CONTENT

#### Pages Package:
> * AddressPage
* ExtraFeaturesPage
* LoginPage
* ProductPage
* RegisterPage
* TopOffersPage
* TravelPage
* Without_LoginProductPge

#### Utils Package:
> * CheckTestExecution
* Excel_DataProvider
* Excel_FileControl
* Sceenshots Class

#### Tests Package: 
> * AddressTest
* BaseTest
* ExtrafeaturesTest
* LoginTest
* LogoutTest
* ProductTest
* RegisterTest
* TopOffersTest
* TravelTest
* Without_LoginProductTest

#### src/main/syslogs: 
> * Log4j.properties

#### Resources: 
> * config.properties
* Test_Data.xlsx

#### Project Contains: 
* **Pages Package:** <ol>It contains *LOCATORS* and *PAGE ACTION* of every test.</ol>
* **Utils Package:** <ol>It contains *FailedScreenshot* code by which if any test case gets failed the system immediately takes screenshot and stores pictures in FailedScreenshot Folder.</ol> <ol>It also contains the code for *Excel sheet* controls and datas.</ol>
* **AddressTest:** <ol>It contains *ADD ADDRESS* & *DELETE ADDRESS SCENARIOS*</ol>
* **BaseTest:** <ol>It contains controls of Extent Report, Webdriver(chrome, FF, IE) , failedScreenshot, Browser Open/Close.</ol>
* **ExtraFeaturesTest:** <ol>It contains *SECURITY POLICY*, *FLIPKART STORIES*, *SIGNUP UP* & *CUSTOMER CARE SCENARIOS*.</ol>
* **LoginTest:** <ol>It contains *VALID LOGIN* & *INVALID LOGIN SCENARIOS*.</ol>
* **LogoutTest:** <ol>It contains *LOGOUT SCENARIO*.</ol>
* **ProductTest:** <ol>It contains *SEARCH PRODUCT WITH LOGIN*, *ADD PRODUCT TO CART WITH LOGIN* & *DELETE PRODUCT FROM CART WITH LOGIN SCENARIOS*.</ol>
* **RegisterTest:** <ol>It contains *REGISTER SCENARIO*.</ol>
* **TopOffersTest:** <ol>It contains *TOPOFFERS CHECK* & *ELECTRONICS CHECK SCENARIOS*.</ol>
* **TravelTest:** <ol>It contains *ONE WAY TRAVEL* & *ROUND WAY TRAVEL SCENARIOS*.</ol>
* **Without_LoginProductTest:** <ol>It contains *PRODUCT SEARCH WITHOUT LOGIN SCENARIO*.</ol>

