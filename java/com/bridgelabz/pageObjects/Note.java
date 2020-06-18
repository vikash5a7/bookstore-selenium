package com.bridgelabz.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Note {
	WebDriver ldriver;
	public Note(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(className = "matinputbox")
	WebElement matBox;
	
	@FindBy(id = "title")
	WebElement titleInput;
	
	@FindBy(id = "desc")
	WebElement descInput;
	
	@FindBy(className="div-button")
	WebElement createNoteButton;
	
	public void clickOnBox() {
		matBox.click();
	}
	
	public void setTitle(String title) {
		titleInput.sendKeys(title);
	}
	
	public void setDesc(String desc) {
		descInput.sendKeys(desc);
	}
	
	public void createNote() {
		createNoteButton.click();
	}
	
}
