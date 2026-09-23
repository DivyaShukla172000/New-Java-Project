package assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertion {
	WebDriver driver;
  @Test
  public void hardAssertion() {
	  driver = new ChromeDriver();
		driver.get("https://practicetestautomation.com/");
		driver.manage().window().maximize();
		
		Assert.assertTrue(true);
		
		System.out.println("Line 1 after hard assertion ");
		
		System.out.println("Line 2 after hard assertion ");
		
		

  }
}
