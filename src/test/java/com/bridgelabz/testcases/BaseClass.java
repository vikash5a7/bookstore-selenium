/**
 * 
 */
package com.bridgelabz.testcases;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.bridgelabz.utitlities.ReadConfig;


public class BaseClass {

	ReadConfig readConfig=new ReadConfig();
	public Properties configPropObj;
	
	public String baseURL = readConfig.getApplicationURL();
	public String username;
	public String password;
	public static WebDriver driver;	
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) throws InterruptedException {
		username = readConfig.getEmail();
		password = readConfig.getPassword();
		System.out.println("Email is " + username + " password is " +  password);
		
		logger = Logger.getLogger("Book Store Testing ");
		PropertyConfigurator.configure("Log4j.properties");
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",readConfig.getChromePath());
			driver=new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",readConfig.getFirefoxPath());
			driver = new FirefoxDriver();
		}
		else if(br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver",readConfig.getIEPath());
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
	}
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "\\Screenshots\\" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
}
