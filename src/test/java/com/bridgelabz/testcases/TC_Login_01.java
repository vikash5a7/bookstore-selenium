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
		adminLogin(username, password,userType);
	}
	
	@Test
	public void validatetingWithValidCridentialOfSeller() throws InterruptedException, IOException {
		logger.info("********* Login with valid cridential of seller *************");
		logger.info("email and password is setting from properties files");
		String userType ="seller";
		adminLogin(sellerUserName, password,userType);
	}
	
	
	@Test
	public void validatetingWithValidCridentialOfAdmin() throws InterruptedException, IOException {
		logger.info("********* Login with valid cridential of Admin *************");
		logger.info("email and password is setting from properties files");
		String userType ="admin";
		adminLogin(adminUserName, password,userType);
	}
	
	@Test
	public void loginAsUserAsSeller() throws InterruptedException, IOException {
		logger.info("********* login As User As Seller cridential *************");
		String userType ="seller";
		adminLogin(username, password,userType);
	}
	@Test
	public void loginUserAsAdmin() throws InterruptedException, IOException {
		logger.info("********* login User As Admin cridential *************");
		String userType ="admin";
		adminLogin(username, password,userType);
	}
	
	@Test
	public void adminLoginAsUser() throws InterruptedException, IOException {
		logger.info("********* admin Login As User cridential *************");
		String userType ="admin";
		adminLogin(adminUserName, password,userType);
	}
	@Test
	public void adminLoginAsSeller() throws InterruptedException, IOException {
		logger.info("********* admin Login As Seller *************");
		String userType ="seller";
		adminLogin(adminUserName, password,userType);
	}
	
	@Test
	public void sellerLoginAsAdmin() throws InterruptedException, IOException {
		logger.info("********* admin Login As Seller *************");
		String userType ="admin";
		adminLogin(sellerUserName, password,userType);
	}
	@Test
	public void sellerLoginAsUser() throws InterruptedException, IOException {
		logger.info("********* admin Login As Seller *************");
		String userType ="user";
		adminLogin(sellerUserName, password,userType);
	}
	
	public void adminLogin(String userEmail, String userPassword, String userType) throws InterruptedException, IOException {
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
