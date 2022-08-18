package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class OneTest extends Base {
	
	public WebDriver driver;
	@Test
	public void oneTest() throws Exception {
		
		System.out.println("Inside OneTest");
		
		driver= initializeDriver();
		
		driver.get("https://www.insightsonindia.com/70-days-ethics-plan/");
		
		Thread.sleep(2000);
		
		driver.close();
		
	}

}
