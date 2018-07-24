package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'Michael Caine')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[text()='Home']")
	WebElement homeLink;
	
	@FindBy(xpath="//a[text()='Calendar']")
	WebElement calendarLink;
	
	@FindBy(xpath="//a[text()='Companies']")
	WebElement companiesLink;
	
	@FindBy(xpath="//a[text()='Contacts']")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[@title='New Contact']")
	WebElement newContactLink;

	
	@FindBy(xpath="//a[text()='Deals']")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[text()=' Tasks']")
	WebElement tasksLink;
	
	
	
	//initializing the page object
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public boolean verifyCorrectuserName(){
		return userNameLabel.isDisplayed();
	}
	public ContactsPage clickOnContactsLink(){
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink(){
		contactsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink(){
		tasksLink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContactLink(){
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
		
	}
	
	
	
}
