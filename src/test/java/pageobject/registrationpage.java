package pageobject;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class registrationpage extends basepage{

	public registrationpage(WebDriver driver) {
		super(driver);
	
	}
	@FindBy(xpath = "//input[@name='firstname']")
	WebElement txt_firstname;
	
	@FindBy(xpath = "//input[@name='lastname']")
	WebElement txt_lastname;
	
	@FindBy(xpath = "//input[@name='email']")
	WebElement txt_email;
	

	@FindBy(xpath = "//input[@name='password']")
	WebElement txt_password;
	
	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement clk_index;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement clk_continue;
	
	public void setfirstname(String fname) {
		txt_firstname.sendKeys(fname);
	}
	public void setlastname(String lname) {
		txt_lastname.sendKeys(lname);
	}
	public void setemail(String email) {
		txt_email.sendKeys(email);
	}
	public void setpassword(String pwd) {
		txt_password.sendKeys(pwd);
	}
	public void clickprivacy() {
	//	JavascriptExecutor js =(JavascriptExecutor)driver;
	//	js.executeScript("window.scrollby(0,document.body.scrollHeight)");
		JavascriptExecutor js=(JavascriptExecutor)driver;
	//	js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		js.executeScript("arguments[0].click();",clk_index );
		//clk_index.click();
	
	}
	public void clickcontinue() {
		//JavascriptExecutor js =(JavascriptExecutor)driver;
	//	js.executeScript("window.scrollby(0,document.body.scrollHeight)");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		js.executeScript("arguments[0].click();", clk_continue);
		//clk_continue.click();
	}

}
