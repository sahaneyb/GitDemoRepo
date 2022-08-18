package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class ThreeTest extends Base {

	public WebDriver driver;
	@Test
	public void threeTest() throws Exception {
		
		System.out.println("Inside ThreeTest");
		
	    driver= initializeDriver();
		
		driver.get("https://www.youtube.com/");
		
		Thread.sleep(2000);
		
		driver.close();
		
		
	}
}
