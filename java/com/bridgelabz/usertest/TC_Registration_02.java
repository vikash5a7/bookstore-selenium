package com.bridgelabz.usertest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bridgelabz.pageObjects.SignUpPage;
import com.bridgelabz.utilities.Util;

public class TC_Registration_02 extends BaseClass {

	@Test
	public void registration() throws InterruptedException, IOException {
		logger.info("**** Starting Registration page Checking with all the INVALID input ************");
		String captureScreenSortName = "RegistraionFailed"+Util.randomeNum(4);
		driver.get(baseURL);
		logger.info("Url is opened");
		SignUpPage signUpPage = new SignUpPage(driver);
		signUpPage.registrationBtn();
		logger.info("Redirecting to the registration page..");

		signUpPage.setFirstName("Rakesh");
		logger.info("Entered user first name");

		signUpPage.setLastName("Kumar");
		logger.info("Entered user last name");

		signUpPage.setEmail(Util.randomestring(7) + "@gmail.com");

		//signUpPage.setEmail("vikashkumargupta5a7"+ "@gmail.com");
		logger.info("Entered user email address");

		signUpPage.SetPassword("rakesh11");
		logger.info("Entered user last password");

		signUpPage.setConfirmationPassword("rakesh11");
		logger.info("Entered user confirmation password");

		signUpPage.setUserPhoneNumber("99" + Util.randomeNum(8));
		logger.info("Entered user phone number");

		logger.info("checking registration button status");
		Thread.sleep(2000);
		if (signUpPage.isDisabledBtn()) {
			signUpPage.clickOnSubmitBtn();
			Thread.sleep(3000);
			boolean res = driver.getPageSource().contains("registration successfull");
			if (res == true) {
				Assert.assertTrue(true);
				logger.info("test case passed....");
			} else {
				logger.info("test case failed....");
				captureScreen(driver,captureScreenSortName );
				logger.info("Capture Screen sort name is" + captureScreenSortName);
				Assert.assertTrue(false);
			}
		} else {
			logger.info("test case failed....");
			captureScreen(driver,captureScreenSortName );
			logger.info("Capture Screen sort name is" + captureScreenSortName);
			Assert.assertTrue(false);
		}
		logger.info("**** Ended Registration page Checking with all the INVALID input ************");
		
	}
}
