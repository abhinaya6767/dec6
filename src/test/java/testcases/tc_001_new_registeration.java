package testcases;

import org.testng.annotations.Test;

import pageobject.homepage;
import pageobject.registrationpage;
import testbase.baseclass;

public class tc_001_new_registeration extends baseclass{

	@Test
	public void oc_new_registration() {
		logger.debug("*******application logs******");
		logger.info("*****starting execution tc_001_new_registration***");
		homepage hp=new homepage(driver);
		registrationpage rp=new registrationpage(driver);
		
		logger.info("checking my account");
		hp.click_myaccount();
		logger.info("checking my registeration");
		hp.click_register();
		
		logger.info("entering firstname");
		rp.setfirstname(rb.getString("firstname"));
		
		logger.info("entering lastname");
		rp.setlastname(rb.getString("lastname"));
		
		logger.info("entering email");
		rp.setemail(rb.getString("email"));
		
		logger.info("entering password");
		rp.setpassword(rb.getString("password"));
		
		logger.info("clicking privacy");
		rp.clickprivacy();
		
		logger.info("clicking on continue");
		rp.clickcontinue();
		
	}
}
