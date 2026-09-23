package testng;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelTesting  {
	WebDriver driver;
	@Test(priority = 1)
	@Parameters({ "browser" })
	public void lauchApp(String browserName) {

		switch (browserName) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Invalid Browser Name");

		}

		//driver = new ChromeDriver();
		driver.get("https://practicetestautomation.com/");
		driver.manage().window().maximize();
	}

	@Test(dataProvider = "loginTestData", priority = 2)
	public void login(String username, String password) throws IOException, InterruptedException {

		driver.findElement(By.xpath("//a[text()='Practice']")).click();
		driver.findElement(By.xpath("//a[text()='Test Login Page']")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
		Thread.sleep(2000);
		System.out.println("Username Entered...." + username);
		driver.findElement(By.id("password")).sendKeys(password);
		Thread.sleep(1000);
		driver.findElement(By.id("submit")).click();
		Thread.sleep(2000);

	}

	@Test(priority = 3)
	public void Exit() {
		System.out.println("After Suite");
		driver.quit();
	}
	@DataProvider(name = "loginTestData")
	  public Object[][] testData() {
		
		  Object data[][]= {
//				  {"student","Password321"},
//				  {"student1","Password123"},
//				  {"student1","Password321"},
				  {"student","Password123"},
		  };
		  
		  return data;
	  }
}
