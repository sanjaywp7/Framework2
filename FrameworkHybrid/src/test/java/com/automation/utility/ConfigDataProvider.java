package com.automation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties pro;

	public ConfigDataProvider()                    //Constructor
	{
		File src = new File("./Config/Config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			
			pro = new Properties();
			
			pro.load(fis);
		} catch (Exception e) {
			//catch block
			
			System.out.println(" Not able to load config file >>>"+e.getMessage());
		}
		
	}

	
	public String getDataFromConfig(String keyToSearch)
	{
		return pro.getProperty(keyToSearch);
	}

	public String getBrowser()
	{
		return pro.getProperty("Browser");
	}
	
	public String getStagingURL()
	{
		return pro.getProperty("qaUrL");
	}
	
	

}
