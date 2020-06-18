package com.bridgelabz.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bridgelabz.pageObjects.UserLogin;
import com.bridgelabz.pageObjects.AminDashboardPage;
import com.bridgelabz.utitlities.Util;

public class TC_AddBook_01 extends BaseClass {

	@Test
	public void addingBookWithValidData() throws InterruptedException, IOException {
		if (adminLogin(username, password)) {
			for (int i = 1; i < 50; i++) {
				logger.info("Adding book Number -> " + i);
				addBook();
			}
		} else {
			logger.info("Invalide Cridentials");
			Assert.assertTrue(false);
		}
		logger.info("********* Adding book over *************");
		
	}
	
	@Test
	public void addBook() throws InterruptedException, IOException {
		String name = Util.randomestring(12);
		String author = Util.randomestring(10) + Util.randomestring(8);
		String price = Util.randomeNum(5);
		String quantity = Util.randomeNum(1);
		String detials = Util.randomestring(10) + Util.randomestring(5) + Util.randomestring(15)
				+ Util.randomestring(5);
		String code = Util.randomestring(3) + Util.randomestring(3);
		logger.info("********* starting Book adding *************");
		addBook(name, author, price, quantity, detials, code);
		Thread.sleep(3000);
		if (driver.getPageSource().contains(name)) {
			logger.info("********* Book Added SuccesFully *************");
			Assert.assertTrue(true);
		}
	}

	public void addBook(String bookName, String authorName, String price, String Qunatity, String details,
			String bookCode) throws InterruptedException, IOException {
		AminDashboardPage adminDashboard = new AminDashboardPage(driver);
		logger.info("---------------- Adding book details-----------------");
		adminDashboard.clickOnAddBookButton();
		logger.info("********* Click on add book button *************");
		adminDashboard.setBookName(bookName);
		logger.info("Set book name " + bookName);
		adminDashboard.setBookAuthorName(authorName);
		logger.info("Set Author name " + authorName);
		adminDashboard.setPriceOfBook(price);
		logger.info("Set Book Price " + price);
		adminDashboard.setQuantityOfBook(Qunatity);
		logger.info("Set Number of books" + Qunatity);
		adminDashboard.setBookDetails(details);
		logger.info("Set Book Details " + details);
		adminDashboard.setBookCode(bookCode);
		logger.info("Set Book code " + bookCode);
		adminDashboard.clickOnSumbmitToAddButton();
	}

	public boolean adminLogin(String userEmail, String userPassword) throws InterruptedException, IOException {
		UserLogin adminLogin = new UserLogin(driver);
		String captureScreenSortName = "loginFailed" + Util.randomeNum(4);
		logger.info("Email---" + userEmail + "password====" + userPassword);
		logger.info("********* starting TC_AdminLogin_01 *************");
		driver.get(baseURL + "login");
		adminLogin.setEmailAddress(userEmail);
		logger.info("User email entered " + userEmail);
		adminLogin.setPassword(userPassword);
		logger.info("User password entered " + userPassword);
			Thread.sleep(3000);
			String expectedTitle = "#Seller-Home";
			String actualTitle = driver.getTitle();
			if (expectedTitle.equals(actualTitle)) {
				logger.info("test case Passed....");
				Assert.assertTrue(true);
				Thread.sleep(2000);
				return true;
			} else {
				logger.info("test case failed....");
				captureScreen(driver, captureScreenSortName);
				logger.info("Capture Screen sort name is" + captureScreenSortName);
				Assert.assertTrue(false);
				return false;
			}
	}
}
