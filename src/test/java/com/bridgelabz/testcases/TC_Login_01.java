package com.bridgelabz.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bridgelabz.pageObjects.UserLogin;
import com.bridgelabz.utitlities.Util;

public class TC_Login_01 extends BaseClass {

	@Test
	public void validatetingWithValidCridential() throws InterruptedException, IOException {
		logger.info("********* Login with valid cridential *************");
		logger.info("email and password is setting from properties files");
		String userType ="user";
		login(username, password,userType);
	}
	
	@Test
	public void validatetingWithValidCridentialOfSeller() throws InterruptedException, IOException {
		logger.info("********* Login with valid cridential of seller *************");
		logger.info("email and password is setting from properties files");
		String userType ="seller";
		login(sellerUserName, password,userType);
	}
	
	
	@Test
	public void validatetingWithValidCridentialOfAdmin() throws InterruptedException, IOException {
		logger.info("********* Login with valid cridential of Admin *************");
		logger.info("email and password is setting from properties files");
		String userType ="admin";
		login(adminUserName, password,userType);
	}
	
	@Test
	public void loginAsUserAsSeller() throws InterruptedException, IOException {
		logger.info("********* login As User As Seller cridential *************");
		String userType ="seller";
		login(username, password,userType);
	}
	@Test
	public void loginUserAsAdmin() throws InterruptedException, IOException {
		logger.info("********* login User As Admin cridential *************");
		String userType ="admin";
		login(username, password,userType);
	}
	
	@Test
	public void adminLoginAsUser() throws InterruptedException, IOException {
		logger.info("********* admin Login As User cridential *************");
		String userType ="user";
		login(adminUserName, password,userType);
	}
	@Test
	public void adminLoginAsSeller() throws InterruptedException, IOException {
		logger.info("********* admin Login As Seller *************");
		String userType ="seller";
		login(adminUserName, password,userType);
	}
	
	@Test
	public void sellerLoginAsAdmin() throws InterruptedException, IOException {
		logger.info("********* admin Login As Seller *************");
		String userType ="admin";
		login(sellerUserName, password,userType);
	}
	@Test
	public void sellerLoginAsUser() throws InterruptedException, IOException {
		logger.info("********* admin Login As Seller *************");
		String userType ="user";
		login(sellerUserName, password,userType);
	}
	@Test
	public void validatetingWithInValidCridential() throws InterruptedException, IOException {
		logger.info("********* Login with InValid cridential *************");
		String UserEmmail = Util.randomestring(10) + "@gmail.com";
		String Userpassword = Util.randomestring(9);
		login(UserEmmail, Userpassword,"user");
	}
	
	@Test
	public void validatetingWithInValidEmail() throws InterruptedException, IOException {
		logger.info("********* Login with valid Email But Invalid password *************");
		String UserEmmail = username;
		String Userpassword = Util.randomestring(12);
		login(UserEmmail, Userpassword,"user");
	}

	@Test
	public void validatetingWithValidEmailButInvalidPassword() throws InterruptedException, IOException {
		logger.info("********* Login with InValid Email but valid password *************");
		String UserEmmail = Util.randomestring(500)+"@gmail.com";
		String Userpassword = Util.randomestring(12);
		login(UserEmmail, Userpassword,"user");
	}
	
	@Test
	public void validatetingWithIvalidFormatedOfEmailAndPassword() throws InterruptedException, IOException {
		logger.info("********* Login with InValid Formate Email and password *************");
		String UserEmmail = null;
		String Userpassword = null;
		login(UserEmmail, Userpassword,"user");
	}

	public void login(String userEmail, String userPassword, String userType) throws InterruptedException, IOException {
		String captureScreenSortName = "loginFailed" + Util.randomeNum(4);
		UserLogin userLogin = new UserLogin(driver);
		logger.info("Email---" + userEmail + "password====" + userPassword);
		logger.info("********* starting TC_AdminLogin_01 *************");
		driver.get(baseURL + "login");
		userLogin.setEmailAddress(userEmail);
		logger.info("User email entered " + userEmail);
		userLogin.setPassword(userPassword);
		logger.info("User password entered " + userPassword);
		if(userType.equals("user")) {
			userLogin.userOnRadioButton();
		}else if(userType.equals("admin")) {
			userLogin.adminOnRadioButton();
		}else {
			userLogin.sellerOnRadioButton();
		}
		logger.info("click on radio button ");
		userLogin.clickOnLoginButton();
		Thread.sleep(5000);
			String expectedTitle = "Bookstore";
			String actualTitle = driver.getTitle();
			if (expectedTitle.equals(actualTitle)) {
				Assert.assertTrue(true);
				logger.info("test case Passed....");
				userLogin.clickOnMenu();
				userLogin.clickOnlogOutBtn();
				Thread.sleep(3000);	
			} else {
				logger.info("test case failed....");
				captureScreen(driver, captureScreenSortName);
				logger.info("Capture Screen sort name is" + captureScreenSortName);
				Assert.assertTrue(false);
			}
		} 
}
