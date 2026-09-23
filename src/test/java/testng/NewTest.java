package testng;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class NewTest {
	 //WebDriver driver = new ChromeDriver(); //not recomended as per the coding standards
	WebDriver driver;
	
  @Test
  public void lauchApp() {
	  driver = new ChromeDriver();
	  driver.get("https://practicetestautomation.com/");
	  driver.manage().window().maximize();
  }
  
  @Test
  public void verifyLogoDisplayed() throws InterruptedException {
	  Thread.sleep(3000);
	  Boolean displayLogo = driver.findElement(By.xpath("//img[@class='custom-logo']")).isDisplayed();
	  Thread.sleep(3000);
	  System.out.println(displayLogo);
	  
  }
  
  @Test
  public void login() throws IOException {
	  
	  
	  driver.findElement(By.xpath("//a[text()='Practice']")).click();
	  driver.findElement(By.xpath("//a[text()='Test Login Page']")).click();
	  driver.findElement(By.xpath("//input[@name='username']")).sendKeys(readconfigFile("username"));
	  System.out.println("Username Entered...."+readconfigFile("username"));
	  driver.findElement(By.id("password")).sendKeys(readconfigFile("password"));
	  driver.findElement(By.id("submit")).click();
	 
  }
  @Test
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
