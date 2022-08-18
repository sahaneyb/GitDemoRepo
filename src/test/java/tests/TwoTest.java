package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class TwoTest extends Base {
	
	public WebDriver driver;
		@Test
		public void twoTest() throws Exception {
			
			System.out.println("Inside TwoTest");
			
			driver= initializeDriver();
			
			driver.get("https://www.youtube.com/");
			
			Thread.sleep(2000);
			
			driver.close();
			
			
		}

		


}
