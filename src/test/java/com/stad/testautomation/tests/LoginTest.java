package com.stad.testautomation.tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.stad.testautomation.pages.HomePage;
import com.stad.testautomation.pages.PracticePage;
import com.stad.testautomation.pages.TestLoginPage;

public class LoginTest {

	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		System.out.println("Before Suite in POM");
		  driver = new ChromeDriver();
		  driver.get("https://practicetestautomation.com/");
		  driver.manage().window().maximize();		
		
	}
	
	@Test
	public void login()  {
		HomePage homePage = new HomePage(driver);
		PracticePage practicePage = new PracticePage(driver);
		TestLoginPage testLoginPage= new TestLoginPage(driver);
		
		homePage.clickOnPracticeLink();
		practicePage.clickOnTesLoginPageLink();
		testLoginPage.clickOnTesLoginPageLink("student", "Password123");
		Boolean displayStatus = testLoginPage.logoutButtonDisplayed();
		Assert.assertTrue(displayStatus);
		
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
