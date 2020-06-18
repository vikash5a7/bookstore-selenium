package com.bridgelabz.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
	WebDriver ldriver;

	public SignUpPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(name = "name")
	WebElement name;

	@FindBy(name = "email")
	WebElement email;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(name = "confirmPassword")
	WebElement confirmPassword;

	@FindBy(name = "mobileNumber")
	WebElement phoneNumber;

	@FindBy(id = "userRadio")
	WebElement userRadioBtn;

	@FindBy(id = "sellerRadioBtn")
	WebElement SellerRadion;

	@FindBy(id = "registrationBtn")
	WebElement registrationSubmitBtn;

	public void setFirstName(String userFname) {
		name.sendKeys(userFname);
	}

	public void setEmail(String userEmail) {
		email.sendKeys(userEmail);
	}

	public void SetPassword(String userPassword) {
		password.sendKeys(userPassword);
	}

	public void setConfirmationPassword(String userConfirmationPassword) {
		confirmPassword.sendKeys(userConfirmationPassword);
	}

	public void setUserPhoneNumber(String userPhoneNumber) {
		phoneNumber.sendKeys(userPhoneNumber);
	}

	public void clickOnUserRadionBtn() {
		userRadioBtn.click();
	}

	public void clickOnSellerRadioBtn() {
		SellerRadion.click();
	}

	public boolean isDisabledBtn() {
		return registrationSubmitBtn.isEnabled();
	}

	public void clickOnSubmitBtn() {
		registrationSubmitBtn.click();
	}

}