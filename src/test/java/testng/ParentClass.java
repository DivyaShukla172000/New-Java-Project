package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParentClass {
	WebDriver driver;
  @BeforeSuite
  public void url() {
	  System.out.println("Before Suite");
	  driver = new ChromeDriver();
	  driver.get("https://practicetestautomation.com/");
	  driver.manage().window().maximize();
  }
  @DataProvider(name = "loginTestData" , indices = {2,3})
  public Object[][] testData() {
	
	  Object data[][]= {
			  {"student","Password321"},
			  {"student1","Password123"},
			  {"student1","Password321"},
			  {"student","Password123"},
	  };
	  return data;
	  }
  
  @AfterSuite
  public void Exit() {
	  System.out.println("After Suite");
	  driver.quit();
  }
}
