package com.bridgelabz.usertest;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bridgelabz.pageObjects.LoginPage;

public class TC_LoginTest_01 extends BaseClass {

	@Test
	public void Logintest() throws InterruptedException, IOException {
		driver.get(baseURL);
		logger.info("Url is opened");
		LoginPage lp = new LoginPage(driver);

		lp.setEmailAddress(username);
		logger.info("Entered email ");
		lp.setPassword(password);
		logger.info("Entered password ");
		lp.clickSubmit();
		Thread.sleep(2000);
		if (driver.getTitle().equals("Fundoo Note Dashboard")) {
			logger.info("Login test passed..");
	
			Assert.assertTrue(true);
		}
		else { 
			captureScreen(driver,"LoginTest");
			logger.info("Login test failed..");
			Assert.assertTrue(false);
		}
	}
}
