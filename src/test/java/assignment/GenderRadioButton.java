package assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GenderRadioButton {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver =new ChromeDriver();
		
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
			
//			JavascriptExecutor jre = (JavascriptExecutor) driver;
//			jre.executeScript("window.scrollBy(0,900)");
			

//			2. Checks if the 'Mr.' radio button (id='id_gender1') is selected before clicking — print result
//			3. Clicks the 'Mr.' radio button
//			4. Asserts it is now selected using isSelected() — print PASS or FAIL
			WebElement maleRadiob =driver.findElement(By.id("id_gender1"));
			
			if (maleRadiob.isDisplayed() && maleRadiob.isEnabled()) {
				if(!maleRadiob.isSelected()) {
					maleRadiob.click();
					System.out.println("Male button selected successfully."+maleRadiob);
				}
				else {
					System.out.println("Male button is not selected. "+maleRadiob);
				}
			}
			Thread.sleep(4000);


//			5. Clicks the 'Mrs.' radio button (id='id_gender2')
//			6. Asserts 'Mrs.' is selected AND 'Mr.' is deselected — print both results
			WebElement femaleRadiob =driver.findElement(By.id("id_gender2"));

			if(femaleRadiob.isDisplayed() && femaleRadiob.isDisplayed()) {
				if(femaleRadiob.isSelected() || !maleRadiob.isSelected()) {

					if(!femaleRadiob.isSelected()) {
						femaleRadiob.click();
						System.out.println("Female button selected successfully.");
					}
					else {
						System.out.println("Female button is not selected. ");
					}			
				}
				else {
					
					System.out.println("Female button is not selected and male selected successfully.");
					
				}
			}
			Thread.sleep(4000);
//			7. Close the browser
			//System.out.println("Female button selected successfully."+maleRadiob);
			driver.quit();
	}

}
