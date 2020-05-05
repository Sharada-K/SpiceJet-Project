package com.spicejetProject.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties prop;
	public ReadConfig()
	{
		File src = new File("./Configuration/config.properties");
		try
		{
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("Exception is:"+e.getMessage());
		}
	}
	
	public String getBaseURL()
	{
		return prop.getProperty("URL");
	}
	
	public String getUserName()
	{
		return prop.getProperty("UN");
	}
	
	public String getPassword()
	{
		return prop.getProperty("pwd");
	}
	
	public String getName()
	{
		return prop.getProperty("name");
	}
	
	public String getChomePath()
	{
		return prop.getProperty("chomedriverpath");
	}
	
	public String getIEPath()
	{
		return prop.getProperty("iedriverpath");
	}
	
	public String getfirefoxPath()
	{
		return prop.getProperty("firefoxdriver");
	}
}
