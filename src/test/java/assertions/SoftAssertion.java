package assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {
	WebDriver driver;
  @Test
  public void softAssertion() {
  
  driver = new ChromeDriver();
	driver.get("https://practicetestautomation.com/");
	driver.manage().window().maximize();
	
	SoftAssert sa = new SoftAssert();
	sa.assertTrue(false);
	
	System.out.println("Line 1 after soft assertion ");
	
	System.out.println("Line 2 after Soft assertion ");
	
	sa.assertAll();
	driver.quit();
}
}