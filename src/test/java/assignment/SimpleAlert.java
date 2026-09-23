package assignment;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SimpleAlert {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		// 1. Launches Chrome and opens https://testautomationpractice.blogspot.com/
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// 3. Locates the 'Simple Alert' button using By.id("alertBtn") and clicks it on
		// 3.a.th Step
		WebElement simpleAlert = driver.findElement(By.id("alertBtn"));
		Thread.sleep(2000);
		// 2. Scrolls to the alert button using JavascriptExecutor scrollIntoView
		JavascriptExecutor jre = (JavascriptExecutor) driver;
		jre.executeScript("window.scrollBy(0,500)", simpleAlert);
		Thread.sleep(2000);
		// 3.a. Click the button to trigger the alert
		simpleAlert.click();
		
		//Use WebDriverWait with ExpectedConditions.alertIsPresent() before switching.
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Alert alertt = wait.until(ExpectedConditions.alertIsPresent());
		// 4. Switches to the alert using driver.switchTo().alert()
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		// 5. Retrieves and prints the alert message text using alert.getText()
		String alertText = alert.getText();
		System.out.println("Alert Text : " + alertText);
		Thread.sleep(2000);
		// 6. Asserts the alert text equals 'I am an alert box!' and prints PASS or FAIL
		String expectedText = "I am an alert box!";
		if (alertText.equals(expectedText)) {
			Thread.sleep(2000);
			System.out.println("Assertion Status: PASS");
		} else {
			Thread.sleep(2000);
			System.out
					.println("Assertion Status: FAIL (Expected: '" + expectedText + "' but got: '" + alertText + "')");
		}
		Thread.sleep(2000);
		// 7. Accepts the alert using alert.accept()
		alert.accept();

		// 8. Prints 'Simple alert accepted successfully'
		System.out.println("Simple alert accepted successfully");

		// 9. Closes the browser
		driver.quit();
	}

}
