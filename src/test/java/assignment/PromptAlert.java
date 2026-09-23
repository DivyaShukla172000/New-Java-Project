package assignment;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PromptAlert {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		// Launches Chrome and opens https://testautomationpractice.blogspot.com/
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// 1. Opens the page, scrolls to and clicks id='confirmBtn'
		WebElement confirmAlert = driver.findElement(By.id("promptBtn"));
		WebElement resultElement = driver.findElement(By.id("demo"));

		JavascriptExecutor jre = (JavascriptExecutor) driver;
		jre.executeScript("window.scrollBy(0,500)", confirmAlert);
		Thread.sleep(2000);

		confirmAlert.click();

		// 2. Waits for alert, prints the alert message
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		
		String alertText = alert.getText();
		System.out.println("Alert Text : " + alertText);
		
		String msg= "Divya";
		alert.sendKeys(msg);
		alert.accept();
		
		String resultText = resultElement.getText();
		System.out.println("Result Text: " + resultText);

		// 5. Asserts it equals 'You pressed OK!' — prints PASS or FAIL
		String ExpectedText = "Hello "+msg+"! How are you today?";
		System.out.println("Expect Text: "+ExpectedText);
		if (ExpectedText.equals(resultText)) {
			System.out.println("Scenario A Result: PASS");
		} else {
			System.out.println("Scenario A Result: FAIL");
		}

		// 10. Closes the browser
		driver.quit();

	}

}
