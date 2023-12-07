package testbase;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class baseclass {


	public static WebDriver driver;
	public Logger logger;
	public ResourceBundle rb;
	//@BeforeClass
	@Parameters({"browser"})
	@BeforeClass
	public void setup(String br) {
	logger=LogManager.getLogger(this.getClass());
	rb=ResourceBundle.getBundle("config");
	if(br.equals("chrome")) {
		driver=new ChromeDriver();
	}else {
		driver=new EdgeDriver();
	}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
	driver.get(rb.getString("baseurl"));
	
	}
	@AfterClass
	public void close() {
		driver.quit();
	}
	public String captureScreen(String tname) {
		String timestamp=new SimpleDateFormat("yyyy.MM.HH.mm.ss").format(new Date());
	TakesScreenshot screenshot=((TakesScreenshot)driver);
	File source=screenshot.getScreenshotAs(OutputType.FILE);
	String destination=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timestamp+".png";
    try {
	FileUtils.copyFile(source, new File(destination));
}catch(Exception e){
	e.getMessage();
}
	return destination;
	}
}
