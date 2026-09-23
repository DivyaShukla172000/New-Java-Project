package com.stad.testautomation.tests;



import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.stad.testautomation.pages.HomePage;
import com.stad.testautomation.pages.PracticePage;
import com.stad.testautomation.pages.TestLoginPage;
import excel.ReadDataFromExcel;

public class LoginTestUsingExcel {
	
WebDriver driver;
	
	@BeforeClass
	public void setup() {
		 System.out.println("Before Suite");
		  driver = new ChromeDriver();
		  driver.get("https://practicetestautomation.com/");
		  driver.manage().window().maximize();
	}
	
	@Test
	public void loginTestUsingExcel() throws IOException {
		List<String> list = ReadDataFromExcel.readDataFromExcelFile();
		
		String username1 = list.get(0);
		String Password1 = list.get(1);
		
		String username2 = list.get(2);
		String Password2 = list.get(3);
		
		String username3 = list.get(4);
		String Password3 = list.get(5);
		
		String username4 = list.get(6);
		String Password4 = list.get(7);
		
		login(username1,Password1);
		login(username2,Password2);
		login(username3,Password3);
		login(username4,Password4);
	}
		
		public void login(String username , String password)  {
			HomePage homePage = new HomePage(driver);
			PracticePage practicePage = new PracticePage(driver);
			TestLoginPage testLoginPage= new TestLoginPage(driver);
			
			homePage.clickOnPracticeLink();
			practicePage.clickOnTesLoginPageLink();
			testLoginPage.clickOnTesLoginPageLink(username, password);		//Boolean displayStatus = testLoginPage.logoutButtonDisplayed();
			//Assert.assertTrue(displayStatus);
	}
		
		@AfterClass
		public void tearDown() {
			driver.quit();
		}

}
