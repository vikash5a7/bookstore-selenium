package com.bridgelabz.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bridgelabz.pageObjects.SignUpPage;
import com.bridgelabz.utitlities.Util;

public class TC_Registration_01 extends BaseClass {

	String enterUserfname;
	String enterUserlname;
	String enterUserPassword;
	String enterUserConfirmationPassword;
	String enterUseremail;
	String enterNumber;

	
	@Test
	public void testWithAllValidInput() throws InterruptedException, IOException {
		logger.info("**** Registration Checking with all the valid input ************");
		enterUserfname = Util.randomestring(5);
		enterUserlname = Util.randomestring(5);
		String password= Util.randomestring(5)+Util.randomeNum(4);
		enterUserPassword = password;
		enterUserConfirmationPassword = password;
		enterUseremail = Util.randomestring(8) + "@gmail.com";
		enterNumber = "99" + Util.randomeNum(8);
		registration(enterUserfname, enterUserfname, enterUseremail, enterUserPassword, enterUserConfirmationPassword,
				enterNumber);
		logger.info("**** End Registration with all the valid input ************");
	}
	
	@Test
	public void testWithAllInValidInput() throws InterruptedException, IOException {
		logger.info("**** Registration with all the Invalid input ************");
		enterUserfname = Util.randomestring(2);
		enterUserlname = Util.randomestring(2);
		enterUserPassword = "Rak";
		enterUserConfirmationPassword = "Rakes";
		enterUseremail = Util.randomestring(8) + "@gmailcom";
		enterNumber = "99" + Util.randomeNum(5);
		registration(enterUserfname, enterUserfname, enterUseremail, enterUserPassword, enterUserConfirmationPassword,
				enterNumber);
		logger.info("**** End Registration with all the Invalid input ************");
	}
	
	
	@Test
	public void testWithInvalidfnameLname() throws InterruptedException, IOException {
		logger.info("**** Registration with all the Invalid first name and last name ************");
		enterUserfname = Util.randomestring(2);
		enterUserlname = Util.randomestring(2);
		enterUserPassword = "Rakes1";
		enterUserConfirmationPassword = "Rakesh1";
		enterUseremail = Util.randomestring(8) + "@gmailcom";
		enterNumber = "99" + Util.randomeNum(8);
		registration(enterUserfname, enterUserfname, enterUseremail, enterUserPassword, enterUserConfirmationPassword,
				enterNumber);
		logger.info("**** End Checking with wrong first name and last name formated ************");
	}
	
	@Test
	public void testWithAllInValidPassWord() throws InterruptedException, IOException {
		logger.info("**** Registration Checking with not match password and confimation password ************");
		enterUserfname = Util.randomestring(5);
		enterUserlname = Util.randomestring(5);
		enterUserPassword = "Rakes";
		enterUserConfirmationPassword = "Rakesh1";
		enterUseremail = Util.randomestring(8) + "@gmail.com";
		enterNumber = "99" + Util.randomeNum(8);
		registration(enterUserfname, enterUserfname, enterUseremail, enterUserPassword, enterUserConfirmationPassword,
				enterNumber);
		logger.info("**** END Registration Checking with not match password and confimation password ************");
	}
	@Test
	public void testWithAlreadyPresentUser() throws InterruptedException, IOException {
		logger.info("**** Registration Checking with already present user ************");
		enterUserfname = Util.randomestring(5);
		enterUserlname = Util.randomestring(5);
		enterUserPassword = "Rakesh1";
		enterUserConfirmationPassword = "Rakesh1";
		enterUseremail = "vikashkumargupta5a7@gmail.com";
		enterNumber = "99" + Util.randomeNum(8);
		registration(enterUserfname, enterUserfname, enterUseremail, enterUserPassword, enterUserConfirmationPassword,
				enterNumber);
		logger.info("**** End Registration page Checking with all the valid input ************");
	}
	
	public void registration(String fname, String lname, String email, String password, String ConfirmationPass,
			String number) throws InterruptedException, IOException {

		String captureScreenSortName = "RegistraionFailed" + Util.randomeNum(4);
		driver.get(baseURL + "register");
		logger.info("Url is opened");
		SignUpPage signUpPage = new SignUpPage(driver);
		logger.info("Redirecting to the registration page..");

		signUpPage.setFirstName(fname);
		logger.info("Entered user first name");

		signUpPage.setEmail(email);
		// signUpPage.setEmail("vikashkumargupta5a7"+ "@gmail.com");
		logger.info("Entered user email address");

		signUpPage.SetPassword(password);
		logger.info("Entered user last password");

		signUpPage.setConfirmationPassword(ConfirmationPass);
		logger.info("Entered user confirmation password");

		signUpPage.setUserPhoneNumber(number);
		logger.info("Entered user phone number");
		
		signUpPage.clickOnUserRadionBtn();
		logger.info("checking registration button status");
		Thread.sleep(2000);
		if (signUpPage.isDisabledBtn()) {
			signUpPage.clickOnSubmitBtn();
			Thread.sleep(8000);
			String expexted = "Bookstore | Login";
			String actual = driver.getTitle();
			if (expexted.equals(actual)) {
				Assert.assertTrue(true);
				logger.info("User Detailes of succefully registration.."+fname +" "+ lname + " "+ email );
				logger.info("test case passed....");
			} else {
				logger.info("test case failed....");
				captureScreen(driver, captureScreenSortName);
				logger.info("Capture Screen sort name is" + captureScreenSortName);
				Assert.assertTrue(false);
			}
		} else {
			logger.info("test case failed....");
			captureScreen(driver, captureScreenSortName);
			logger.info("Capture Screen sort name is" + captureScreenSortName);
			Assert.assertTrue(false);
		}
		driver.navigate().refresh();
	}
}