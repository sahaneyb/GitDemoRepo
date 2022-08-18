package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import resources.Base;

public class FourTest extends Base{

	
	public WebDriver driver;
	
	@Test
	public void fourTest() throws Exception {
		
		System.out.println("Karan has Updated code here");
		System.out.println("Inside FourTest");
		
		driver= initializeDriver();
		
		driver.get("https://www.gktoday.in/current-affairs/category/government-schemes/");
		
		Thread.sleep(2000);
		
		Assert.assertTrue(false);
		
		
		
	}
	
	@AfterMethod
	public void closingBrowser() {
		
		driver.close();
	}
}
