package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotation {
	WebDriver driver;
	
	@BeforeTest//@BeforeClass // @BeforeMethod
	  public void lauchApp() {
		  System.out.println("Before Method");
		  driver = new ChromeDriver();
		  driver.get("https://practicetestautomation.com/");
		  driver.manage().window().maximize();
	  }
	  
	  @Test
	  public void verifyLogoDisplayedd() {
		  System.out.println("Before Test logo check ");
		  Boolean displayLogo = driver.findElement(By.xpath("//img[@class='custom-logo']")).isDisplayed();
		  System.out.println(displayLogo);
		  
	  }
	  
	  @Test
	  public void login() {
		  System.out.println("Before Test login");
		  driver.findElement(By.xpath("//a[text()='Practice']")).click();
		  driver.findElement(By.xpath("//a[text()='Test Login Page']")).click();
		  driver.findElement(By.xpath("//input[@name='username']")).sendKeys("student");
		  driver.findElement(By.id("password")).sendKeys("Password123");
		  driver.findElement(By.id("submit")).click();
		 
	  }
	  @AfterTest//@AfterClass//@AfterMethod
	  public void quit() throws InterruptedException {
		  System.out.println("After Method");
		  Thread.sleep(5000);
		  driver.close();
		  
	  }

}
