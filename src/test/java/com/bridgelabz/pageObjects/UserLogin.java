package com.bridgelabz.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLogin {
	WebDriver ldriver;

	public UserLogin(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(name ="email")
	@CacheLookup
	WebElement email;

	@CacheLookup
	@FindBy(name="password")
	WebElement password;

	@CacheLookup
	@FindBy(id = "loginBtn")
	WebElement btnUserLogin;
	@CacheLookup
	@FindBy(xpath = "//mat-radio-button[@id='mat-radio-2']//div[@class='mat-radio-outer-circle']")
	WebElement userLoginRadioButton;
	
	@FindBy(xpath = "//mat-radio-button[@id='mat-radio-3']//div[@class='mat-radio-outer-circle']")
	WebElement sellerLoginRadioButton;
	
	@FindBy(xpath = "//mat-radio-button[@id='mat-radio-4']//div[@class='mat-radio-outer-circle']")
	WebElement adminLoginRadioButton;
	
	@FindBy(className ="profile")
	WebElement menuBtn;
	
	@FindBy(className ="signout-button")
	WebElement logoutBtn;
	
	public void setEmailAddress(String userEmail)
	{
		email.sendKeys(userEmail);
	}
	public void setPassword(String userPassword)
	{
		password.sendKeys(userPassword);
	}
	
	public void userOnRadioButton() {
		userLoginRadioButton.click();
	}
	public void sellerOnRadioButton() {
		sellerLoginRadioButton.click();
	}
	public void adminOnRadioButton() {
		adminLoginRadioButton.click();
	}
	
	public boolean isEnabledBtUserButton() {
		return btnUserLogin.isEnabled();
	}
	public void clickOnLoginButton() {
		btnUserLogin.click();
	}
	public void clickOnMenu() {
		menuBtn.click();
	}
	public void clickOnlogOutBtn() {
		logoutBtn.click();
	}
}
