package com.automation.pages;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.automation.utility.BrowserFactory;
import com.automation.utility.ConfigDataProvider;
import com.automation.utility.ExcelDataProvider;
import com.automation.utility.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {

	public WebDriver driver;	//global variable
	public ExcelDataProvider excel; //global variable
	public ConfigDataProvider config; //global variable
	
	public ExtentReports report; //global variable
	public ExtentTest logger;	//global variable
	
	@BeforeSuite
	public void setUpSuite()
	{	
	//Following one line will generate log in html report and true will also display log on screen i.e sysout.
 
	Reporter.log("Setting up reports and Tests are getting ready... ", true);	
		
	excel= new ExcelDataProvider();
	config = new ConfigDataProvider();
	
	ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/FreeCRM_"+Helper.getCurrentDateTime()+".html"));
	report = new ExtentReports();
	report.attachReporter(extent);

	Reporter.log("Setting done -- Tests can be started... ", true);	
	
	}	
	

	@BeforeClass
	public void setup()
	{
		
		Reporter.log("Trying to start browser and getting applicaiton ready... ", true);			
		driver=BrowserFactory.startApplicaiton(driver, config.getBrowser(),config.getStagingURL());		
		Reporter.log("Browser and application is up and running... ", true); // If something goes wrong then this line will not be executed.			

	}
	
	@AfterClass
	public void tearDown()
	{
		BrowserFactory.quitBrowser(driver);	
	} 
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException
	{
		Reporter.log("Test is about to end... ", true);			
		
		if(result.getStatus()==ITestResult.FAILURE){
//			Helper.captureScreenshot(driver);			
			logger.fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test passed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			
		}
//		Similarly we can add for SKIP
//		else if(result.getStatus()==ITestResult.SKIP)
//		{
//		}
		
		
		//report.flush() will keep on adding report of each test case in a single report.
		report.flush();  		

		Reporter.log("Test completed >> Report generated... ", true);			
		
	}
}
