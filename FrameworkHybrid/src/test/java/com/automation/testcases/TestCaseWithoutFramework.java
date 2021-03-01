package com.automation.testcases;
//yet to RUN this program

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestCaseWithoutFramework {

	@Test
	public void testn1() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Sel\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.get("https://freecrm.co.in/");
		//driver.get(https://classic.freecrm.com/login.cfm);
		driver.get("https://classic.freecrm.com/index.html?e=1");
		
		
		//driver.get("https://ui.freecrm.com/");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.name("email")).sendKeys("sanjaywp7@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div/form/div/div[3]")).click();
		System.out.println("Clcked with randome values.....");
		driver.quit();
		
	}
	
}
