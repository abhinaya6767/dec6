package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class homepage extends basepage {

	public homepage(WebDriver driver) {
		super(driver);
	}	
	//Locators
		@FindBy(xpath ="//span[text()='My Account']" )
		WebElement btn_myaccount;
		
		@FindBy(xpath = "//a[text()='Register']")
		WebElement btn_register;
		
		public void click_myaccount() {
			btn_myaccount.click();
		}
		public void click_register() {
			btn_register.click();
		}
	}


