package com.bridgelabz.notetest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bridgelabz.pageObjects.LoginPage;
import com.bridgelabz.pageObjects.Note;
import com.bridgelabz.usertest.BaseClass;
import com.bridgelabz.utilities.Util;

public class TC_CreateNote_01 extends BaseClass{
	
	
	@Test
	public void createNote() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		Note note=new Note(driver);
		driver.manage().window().maximize();
		driver.get(baseURL);
		logger.info("Url is opened");
		lp.setEmailAddress(username);
		lp.setPassword(password);
		lp.clickSubmit();
		Thread.sleep(3000);
		if (driver.getTitle().equals("Fundoo Note Dashboard")) {
			logger.info("Login test passed..");
			note.clickOnBox();
			Thread.sleep(2000);
			logger.info(" Note Box is opnend");
			String title = Util.randomestring(6);
			String desString = Util.randomestring(3) + " " + Util.randomestring(7) + " " + Util.randomestring(6);
			note.setTitle(title);
			logger.info("Title is set");
			note.setDesc(desString);
			logger.info("Descrption is set");
			note.createNote();
			logger.info("clicked on note create ");
			Thread.sleep(5000);
			
			if(driver.getPageSource().contains(desString) && driver.getPageSource().contains(title)) {
				logger.info("Note is created sucessFully");
				Assert.assertTrue(true);
				logger.info("Note Created test is passed ");
				lp.clickLogout();
			}
			
		}
		else { 
			captureScreen(driver,"LoginTest");
			logger.info("Login test failed..");
			Assert.assertTrue(false);
			driver.close();
		}
	}
	
}
