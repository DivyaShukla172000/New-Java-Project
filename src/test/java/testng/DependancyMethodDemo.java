package testng;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DependancyMethodDemo {
	WebDriver driver;
		
	  @Test
	  public void lauchApp() throws IOException {
		  
		  driver = new ChromeDriver();
		 // String URL = readconfigFile("url");
		  driver.get(readconfigFile("url"));
		  System.out.println("URL id ....."+readconfigFile("url"));
		  driver.manage().window().maximize();
	  }
	  
	  @Test(priority= 1,dependsOnMethods = {"lauchApp"})
	  public void verifyLogoDisplayed() throws InterruptedException {
		  Thread.sleep(3000);
		  Boolean displayLogo = driver.findElement(By.xpath("//img[@class='custom-logo']")).isDisplayed();
		  Thread.sleep(3000);
		  System.out.println(displayLogo);
		  
	  }
	  
	  @Test(priority= 2,dependsOnMethods = {"lauchApp"})
	  public void login() throws IOException {
		    
		  driver.findElement(By.xpath("//a[text()='Practice']")).click();
		  driver.findElement(By.xpath("//a[text()='Test Login Page']")).click();
		  driver.findElement(By.xpath("//input[@name='username']")).sendKeys(readconfigFile("username"));
		  System.out.println("Username Entered...."+readconfigFile("username"));
		  driver.findElement(By.id("password")).sendKeys(readconfigFile("password"));
		  driver.findElement(By.id("submit")).click();
		 
	  }
	  
	  @Test(priority= 3,dependsOnMethods = {"lauchApp"})
	  public void verifyLoginSucessfully() throws IOException {
		 Boolean displayveryy =driver.findElement(By.linkText("Log out")).isDisplayed();
		  Assert.assertTrue(displayveryy);
	  }
	  
	  @Test(priority= 4,dependsOnMethods = {"lauchApp","verifyLoginSucessfully"})
	  public void quit() throws InterruptedException {
		  Thread.sleep(5000);
		  driver.close();
		  
	  }
	
	  public String readconfigFile(String key) throws IOException {
		  Properties prop = new Properties();
		  String configPath =System.getProperty("user.dir")+"\\src\\test\\java\\config";
		  FileInputStream fis = new FileInputStream(configPath);
		  prop.load(fis);
		  String value = prop.getProperty(key);
		  return value;
		  
		  
	  }

}
