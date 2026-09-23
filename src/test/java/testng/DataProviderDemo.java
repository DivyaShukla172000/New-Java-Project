package testng;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo extends ParentClass {
  
  @Test(dataProvider = "loginTestData")
  public void login(String username , String password) throws IOException, InterruptedException {
	  
	  driver.findElement(By.xpath("//a[text()='Practice']")).click();
	  
	  
	  driver.findElement(By.xpath("//a[text()='Test Login Page']")).click();
	  
	  
	  driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
	  Thread.sleep(4000);
	  System.out.println("Username Entered...."+username);
	  driver.findElement(By.id("password")).sendKeys(password);
	  Thread.sleep(4000);
	  driver.findElement(By.id("submit")).click();
	  Thread.sleep(4000);
	 
	  if(!username.equals("student") && password.equals("Password123")) {
		 String errorText= driver.findElement(By.id("error")).getText();
		  Assert.assertTrue(errorText.equals("Your username is invalid!"));
		  System.out.println(errorText);
	  } else if(username.equals("student") && !password.equals("Password123")) {
			 String errorText= driver.findElement(By.id("error")).getText();
			  Assert.assertTrue(errorText.equals("Your password is invalid!"));
			  System.out.println(errorText);
		  }else if(!username.equals("student") && !password.equals("Password123")) {
				 String errorText= driver.findElement(By.id("error")).getText();
				  Assert.assertTrue(errorText.equals("Your username is invalid!"));
				  System.out.println(errorText);
			  }else {
				  Boolean displaycorrecttext = driver.findElement(By.linkText("Log out")).isDisplayed();
				  Assert.assertTrue(displaycorrecttext);
				  System.out.println(displaycorrecttext);
			  }
  }
  
//  @DataProvider(name = "loginTestData" , indices = {2,3})
//  public Object[][] testData() {
//	
//	  Object data[][]= {
//			  {"student","Password321"},
//			  {"student1","Password123"},
//			  {"student1","Password321"},
//			  {"student","Password123"},
//	  };
//	  
//	  return data;
//  }
//  
  
 
}
