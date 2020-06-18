package com.bridgelabz.usertest;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bridgelabz.pageObjects.LoginPage;
import com.bridgelabz.utilities.XLUtils;


public class TC_LoginDDT_02 extends BaseClass{

	@Test(dataProvider="LoginData")
	public void loginTest(String user,String pwd) throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		logger.info("Email---" + user + "password====" + pwd);
		logger.info("********* starting TC_LoginDDT_002 *************");
		int count=0;
		driver.get(baseURL);
		lp.setEmailAddress(user);
		lp.setPassword(pwd);
		lp.clickSubmit();
		Thread.sleep(3000);
		
		String exp_title="Fundoo Note Dashboard";
		String act_title=driver.getTitle();
		
		if(exp_title.equals(act_title))
		{
			count++;
			logger.info("********* Login Test pass" + count + "*************");
			lp.clickLogout();
			Assert.assertTrue(true);
			}
			else { 
			count++;
			captureScreen(driver,"Login"+user+pwd);
			Thread.sleep(2000);
			logger.info("********* Login Test Failed.....!!" + count + " *************");
			Assert.assertTrue(false);	
		}
		logger.info("********* Finished  TC_LoginDDT_002 *************");
	}
	
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/TestData/LoginData.xlsx";
		
		int totalrows=XLUtils.getRowCount(path, "Sheet1");	
		int totalcols=XLUtils.getCellCount(path,"Sheet1",1);
				
		String logindata[][]=new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++) 
		{		
			for(int j=0;j<totalcols;j++)
			{
				logindata[i-1][j]= XLUtils.getCellData(path, "Sheet1",i, j);  //1,0
			}
		}
	return logindata;			
	}
	
}

