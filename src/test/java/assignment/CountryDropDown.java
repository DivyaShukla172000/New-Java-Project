package assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CountryDropDown {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		try {

//		1. Navigates to https://www.automationexercise.com/login
			driver.get("https://www.automationexercise.com/login");
			driver.manage().window().maximize();

//			2. Enters name and unique email, clicks Signup to reach the Account Information form
			driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Div");
			driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("divyashukla@gamil.com");

//			3. Waits for the form to load
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(By.xpath("//button[normalize-space()='Signup']")).click();
//			4. Uses the Select class to:
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			JavascriptExecutor jre = (JavascriptExecutor) driver;
			jre.executeScript("window.scrollBy(0,900)");
		
			
			WebElement country = driver.findElement(By.id("country"));
			Select countrySelect  = new Select(country);
			
			List<WebElement> allOption =countrySelect.getOptions();
//			System.out.println("All Option from country List "+allOption);
			  System.out.println("--- Available Country Options ---");
	            for (WebElement option : allOption) {
	                System.out.println(option.getText());
	            }
		
	            System.out.println("\nTotal count of options: " + allOption.size());
	            
	            String selectedText = countrySelect.getFirstSelectedOption().getText();
	            if (selectedText.equals("India")) {
	                System.out.println("Assertion Result: PASS");
	            } else {
	                System.out.println("Assertion Result: FAIL (Selected: " + selectedText + ")");
	            }

	            // 9. Checks whether the dropdown is a multi-select using isMultiple() and prints the result
	            boolean isMultiSelect = countrySelect.isMultiple();
	            System.out.println("Is the dropdown a multi-select? " + isMultiSelect);
	  } catch (Exception e) {
          e.printStackTrace();
      } finally {
          // 10. Close the browser
          driver.quit();
      }

			
	}

}
