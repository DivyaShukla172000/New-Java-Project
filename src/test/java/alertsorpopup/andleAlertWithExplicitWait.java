package alertsorpopup;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class andleAlertWithExplicitWait {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();

		// 2.Navigate to URL
		driver.get("https://practice-automation.com/popups/");
		
		Thread.sleep(2000);

		// 3. Maximize the Window
		driver.manage().window().maximize();
		
		driver.findElement(By.id("prompt")).click();
		Thread.sleep(2000);
		
		
		WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		
		alert.accept();
	}

}
