package com.crm.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTests extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public HomePageTests(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void veriifyHomePageTitleTest(){
		String homePageTitle= homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO", "hOME PAGE TITLE NOT MATCH");
	}
	@Test(priority=2)
	public void verifyCorrectuserNameTest(){
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectuserName());
	}
	
	@Test(priority=3) 
	public void verifyContactsLinkTest(){
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}
	
	@AfterMethod
	public void teatDown(){
		driver.quit();
	}

}
