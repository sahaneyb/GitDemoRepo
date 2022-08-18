package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LogingPage;
import resources.Base;

public class LoginTest extends Base {
	
	
	Logger log;
	
	public WebDriver driver;
	
	@Test(dataProvider="getLoginData")
	public void login(String email,String password,String expectedResult) throws IOException, Exception {
	
	log = LogManager.getLogger(LoginTest.class.getName());
	
    LandingPage landingPage = new LandingPage(driver);
	landingPage.myAccountDropdown().click();
	log.debug("Clicked on My Account dropdown");
	landingPage.logingOption().click();
	log.debug("Clicked on login option");
	
	Thread.sleep(3000);
	
	LogingPage logingPage = new LogingPage(driver);
	
//  use data properties file for single set of information or data	
//	logingPage.emailAddressField().sendKeys(prop.getProperty("email")); 
	
	//use of dataProvider for multiple set of data or information
	logingPage.emailAddressField().sendKeys(email);
	log.debug("Email addressed got entered");
	
	Thread.sleep(3000);
//  use data properties file for single set of information or data	
//	logingPage.passwordField().sendKeys(prop.getProperty("password"));
	

	//use of dataProvider for multiple set of data or information	
	logingPage.passwordField().sendKeys(password); 
	log.debug("Password got entered");
	logingPage.loginButton().click();
	log.debug("Clicked on Login Button");
		
	AccountPage accountPage = new AccountPage(driver);
   
	//use of assertTrue 
	// Assert.assertTrue(accountPage.editAccountInformationLink().isDisplayed());	
	
	//System.out.println(accountPage.editAccountInformationLink().isDisplayed());
	
	String actualResult = null;
	
	try {
		
		if(accountPage.editAccountInformationLink().isDisplayed()) {
			log.debug("User got logged in");
			actualResult = "Successfull";
		}
		
		
		
	}catch (Exception e) {
		
		log.debug("User didn't log in");
		actualResult = "Failure";
	}
	
	Assert.assertEquals(actualResult,expectedResult);
	log.info("Login Test got passed");
    
	}

	
	//@BeforeMethod run before @Test method
	@BeforeMethod
	public void openAppliocation() throws IOException {
		
		log = LogManager.getLogger(LoginTest.class.getName());
		
		driver =  initializeDriver(); 
		log.debug("Browser got launched");
		driver.get(prop.getProperty("url"));
		log.debug("Navigated to application URL");
		
		
		}
	
	
	//@AfterMethod run after @Test method 
	@AfterMethod
	public void closure() {
		
		driver.close();
		log.debug("Browser got closed");
	}
	
	
	//use of dataProvider for multiple set of data or information
	@DataProvider
	public Object getLoginData(){
		
		Object [][] data = {{"arun.selenium@gmail.com","Second@123","Successfull"},{"dummy@test.com","dummy","Failure"}};
		
		return data ;
		
		}
	
	
	
}
