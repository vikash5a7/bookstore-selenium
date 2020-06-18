package com.bridgelabz.testcases;

import org.testng.annotations.Test;

public class TC_SearchBook_01 extends BaseClass {
	
	@Test
	public void searchBook() {
		driver.get(baseURL);
		logger.info("User Opened: ");
	}
}
