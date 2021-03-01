package com.automation.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.pages.BaseClass;
import com.automation.pages.LoginPage;
import com.automation.utility.BrowserFactory;
import com.automation.utility.ExcelDataProvider;
import com.automation.utility.Helper;

public class LoginTestCRM extends BaseClass {
	
//	Not Required
//	WebDriver driver;

	//Creating an object of class of ExcelDataProvider.java
	
	 
	@Test (priority=1)
	public void LoginApp()	{
		
		// here logger will be responsible for all the login activity. 
		// we have logger.info, ogger.pass, logger.fail, logger.error, logger.escape etc.

		logger=report.createTest("Login to CRM");
		
//		excel.getStringData("Login", 0, 0);  This I have passed in below line, so commenting.
//		System.out.println(driver.getTitle());
//		System.out.println("Success...");

		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		logger.info("Starting spplication");  //test steps we mention here	
		loginPage.loginToCRM(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1)); 
										//sheetName,row,col					sheetName,row,col
		logger.pass("Login Success");
		}

//	@Test(priority=2)
//	public void LoginApp1()	{
//		
//		// This just to show how logger works. here no activity is done. just captured logger only.
//		// This will run two test and add result in the report
//
//		logger=report.createTest("Logout");
//		
// 		logger.fail("Logout failed");		
//		}





}
