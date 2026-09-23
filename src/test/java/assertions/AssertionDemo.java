package assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AssertionDemo {
	WebDriver driver;

	@Test
	public void lauchApp() {

		driver = new ChromeDriver();
		driver.get("https://practicetestautomation.com/");
		driver.manage().window().maximize();

		String actualTitle = driver.getTitle();
		String expectedTitle = "Practice Test Automation | Learn Selenium WebDrive";

	
		/* 
		  if(actualTitle.equals(expectedTitle)) {
		  System.out.println("Test Pass");
			Assert.assertEquals(actualTitle, expectedTitle);
		  } 
		  else { 
			  System.out.println("Test fail"); 
			  Assert.assertEquals(actualTitle, expectedTitle);
			  
			  }
		  */
		//  Assert.assertEquals(123, 123);//true
		  
		//  Assert.assertEquals(123, "123");//false
		  
		  //Assert.assertNotEquals("Test Automation", "Test Automation");//fails
		  
		 // Assert.assertNotEquals("Test Automation", "Testmation");//pass
		  
		 // Assert.assertTrue(actualTitle.equals(expectedTitle));
		  
		 // Assert.assertTrue(false);//fail
		  
		 // Assert.assertTrue(true);//pass
		  
		  Assert.assertFalse(false);  //pass
		  
		//  Assert.assertFalse(true); // fail  
		 
		driver.quit();
	}

}
