package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogingPage {
	
	WebDriver driver;
	
	public LogingPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-email")
	private WebElement emailAddressField;//Encapsualtion --->>> We have encapsulated web element in our page object model in their respective classes
	
	@FindBy(id="input-password")
	private WebElement passwordField;// WebElement make private i.e Encapsualtion
	
	@FindBy(css="input[value='Login']")
	private WebElement loginButton;// Encapsulation
	
	public WebElement emailAddressField() {
		
		
		return emailAddressField;
		
			
	}
	
	public WebElement passwordField() {
		
		return passwordField;
		
	}

	public WebElement loginButton() {
		
		return loginButton;
	}

	
}



