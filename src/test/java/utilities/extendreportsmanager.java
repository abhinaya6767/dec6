package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testbase.baseclass;

public class extendreportsmanager implements ITestListener {

	public ExtentSparkReporter sparkreporter;//ui of reports
	public ExtentReports extent;//populate common info
	public ExtentTest test;//create entry & update
	String repname;
	
	public void onStart(ITestContext context)
	{
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repname="test-reports-"+timestamp+".html";
		sparkreporter =new ExtentSparkReporter(".\\reports\\"+repname);
		//generate the location in path
		sparkreporter.config().setDocumentTitle("automachine testing");
		sparkreporter.config().setReportName("functional");
		sparkreporter.config().setTheme(Theme.STANDARD);//theme
		
		//common info
		extent =new ExtentReports();
		extent.attachReporter(sparkreporter);
		extent.setSystemInfo("computername", "locahost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester", "Abhi");
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("Browser", "Chrome");
	}
		
	public void onTestSuccess(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.log(Status.PASS, "tet is passed:"+result.getName());
	try {
		String imgpath=new baseclass().captureScreen(result.getName());
	    test.addScreenCaptureFromPath(imgpath);
	}catch(Exception e1) {
		e1.printStackTrace();
	}
	
	}
	
	public void onTestFailure(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.log(Status.FAIL, "tet is failed:"+result.getName());
	test.log(Status.FAIL, "test is failed:"+result.getThrowable());
	}
	
	public void onTestSkipped(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.log(Status.SKIP, "tet is skipped:"+result.getName());
	test.log(Status.SKIP, "test is skipped:"+result.getThrowable());
	}
	
	public void onFinish(ITestContext context)
	{
	extent.flush();
}
}
