package assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckboxNewslatterandSpecialOffer {

	public static void main(String[] args) {
		WebDriver driver =new ChromeDriver();
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


			  try {
		            // 1. Navigate to the login/signup page
				  driver.get("https://www.automationexercise.com/login");
					driver.manage().window().maximize();


		            // 2. Enter name and a unique email, then click Signup
		            driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("Test User");
		            
		            // Generate a unique email using the current timestamp
		            String uniqueEmail = "testuser" + System.currentTimeMillis() + "@example.com";
		            driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys(uniqueEmail);
		            
		            driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

		            // 3. Wait for the form heading 'Enter Account Information' to appear
		            // Using a case-insensitive match for reliability
		            wait.until(ExpectedConditions.visibilityOfElementLocated(
		                    By.xpath("//b[normalize-space()='Enter Account Information']")
		            ));

		            // Locate the checkboxes
		            WebElement newsletterCheckbox = driver.findElement(By.id("newsletter"));
		            WebElement optinCheckbox = driver.findElement(By.id("optin"));

		            // 4. Check the initial state of both checkboxes using isSelected() — print both
		            System.out.println("Initial Newsletter state (Selected): " + newsletterCheckbox.isSelected());
		            System.out.println("Initial Optin state (Selected): " + optinCheckbox.isSelected());

		            // 5. Click the 'newsletter' checkbox to select it
		            newsletterCheckbox.click();

		            // 6. Click the 'optin' checkbox to select it
		            optinCheckbox.click();

		            // 7. Asserts both are now selected — print PASS or FAIL
		            if (newsletterCheckbox.isSelected() && optinCheckbox.isSelected()) {
		                System.out.println("Step 7 Assertion: PASS (Both checkboxes are selected)");
		            } else {
		                System.out.println("Step 7 Assertion: FAIL (One or both checkboxes are not selected)");
		            }

		            // 8. Clicks 'newsletter' again to deselect it
		            newsletterCheckbox.click();

		            // 9. Asserts 'newsletter' is deselected and 'optin' remains selected — print PASS or FAIL
		            if (!newsletterCheckbox.isSelected() && optinCheckbox.isSelected()) {
		                System.out.println("Step 9 Assertion: PASS ('newsletter' is deselected and 'optin' is selected)");
		            } else {
		                System.out.println("Step 9 Assertion: FAIL (Unexpected checkbox state)");
		            }

		        } catch (Exception e) {
		            System.err.println("An error occurred during execution: " + e.getMessage());
		            e.printStackTrace();
		        } finally {
		            // 10. Close the browser
		            driver.quit();
		        }
		 
	}

}
