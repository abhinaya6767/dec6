package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class basepage {
WebDriver driver;
//constructor
public basepage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
}
