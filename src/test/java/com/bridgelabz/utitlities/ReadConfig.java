package com.bridgelabz.utitlities;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	
	public ReadConfig()
	{
		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	public String getApplicationURL()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}
	
	public String getEmail()
	{
		return pro.getProperty("email");
	}
	
	public String getPassword()
	{
		return pro.getProperty("password");
	}
	
	public String getChromePath()
	{
	return pro.getProperty("chromepath");
	}
	
	public String getIEPath()
	{
	String iepath=pro.getProperty("iepath");
	return iepath;
	}
	
	public String getFirefoxPath()
	{
	return pro.getProperty("firefoxpath");
	}
	
}




