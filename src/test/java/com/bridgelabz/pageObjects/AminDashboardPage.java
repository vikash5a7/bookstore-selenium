package com.bridgelabz.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AminDashboardPage {
	
	WebDriver ldriver;

	public AminDashboardPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath ="//button[@class='btn-addbook']")
	@CacheLookup
	WebElement addBookBtn;
	
	@FindBy(id ="bookName")
	@CacheLookup
	WebElement bookNameInput;
	
	@FindBy(id ="authorName")
	@CacheLookup
	WebElement bookAuthorNameInput;
	
	
	@FindBy(id ="price")
	@CacheLookup
	WebElement bookPriceInput;
	
	
	@FindBy(id ="quantity")
	@CacheLookup
	WebElement bookQuantityInput;
	
	@FindBy(id ="bookDetails")
	@CacheLookup
	WebElement bookDetailsInputs;
	
	@FindBy(id ="bookCode")
	@CacheLookup
	WebElement bookCodeInput;
	
	@FindBy(xpath ="//button[@class='mat-button mat-button-base']")
	@CacheLookup
	WebElement addBookButton;
	
	
	public void clickOnAddBookButton(){
		addBookBtn.click();
	}
	
	public void setBookName(String name)
	{
		bookNameInput.sendKeys(name);
	}
	
	public void setBookAuthorName(String AuthorName)
	{
		bookAuthorNameInput.sendKeys(AuthorName);
	}
	
	
	public void setPriceOfBook(String price)
	{
		bookPriceInput.sendKeys(price);
	}
	
	public void setQuantityOfBook(String quantity)
	{
		bookQuantityInput.sendKeys(quantity);
	}
	
	public void setBookDetails(String details)
	{
		bookDetailsInputs.sendKeys(details);
	}
	public void setBookCode(String code)
	{
		bookCodeInput.sendKeys(code);
	}
	public void clickOnSumbmitToAddButton(){
		addBookButton.click();
	}
	
}
