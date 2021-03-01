package com.automation.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	public static String captureScreenshot(WebDriver driver)
	{ 
//		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
//		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
				
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath=System.getProperty("user.dir")+"/Screenshots/FreeCRM_"+getCurrentDateTime() +".png";
		
		try {
//			FileHandler.copy(src,new File("./Screenshots/FreeCRM_"+ getCurrentDateTime() +".png"));
			FileHandler.copy(src,new File(screenshotPath));

		} catch (IOException e) {
			// catch block
			System.out.println("Unable to capture screenshot"+e.getMessage());
		
		}
		return screenshotPath;
	}
	
//  Class to be added: ScreenShots, Frames, Alerts, MultipleWindows, handleSyncIssues, JavaScriptExecutor 
//	public void handleFrames()
//	{
//	}
//	public void handleAlerts()
//	{
//	}

	public static String getCurrentDateTime()
	//getCurrentDateTime()
	{
//		DateFormat format = new SimpleDateFormat("");
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		
		Date currentDate = new Date();
		
		return customFormat.format(currentDate);
	}
	
	
	
}
