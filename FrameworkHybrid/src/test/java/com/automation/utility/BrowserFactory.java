
//NOT COMPLETE
// Working fine for Chrome but not working for IE or other browsers. Need to check. 


package com.automation.utility;

import java.util.concurrent.TimeUnit;

import org.apache.commons.math3.geometry.spherical.twod.Edge;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {

public static WebDriver startApplicaiton(WebDriver driver, String browserName,String appURL) 
	{
 		if(browserName.equals("Chrome"))
		{
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		//driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);		
		}
		else if(browserName.equals("FireFox"))
		{
			System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe");
			// Location of all drivers are under C:\Sel\
			//like C:\Sel\FirefoxDriver\geckodriver-v0.29.0-win64
			driver = new FirefoxDriver();
			//driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);		
			
		}
		else if(browserName.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver","./Drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			//driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);		
			
		}
//
//	// Code for configuring Edge explorer	
//		else if(browserName.equals("Edge"))
//		{
//			System.setProperty("webdriver.edge.driver","./Drivers/msedgedriver.exe");
//			driver = new Edge();
//	//driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);		
//			
//		}
		else 
		{
			System.out.println("We do not support this browser");
		}
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

		return driver;			
		
	}

	
public static void quitBrowser(WebDriver driver) 
	{
		driver.quit();
		
	}

}
