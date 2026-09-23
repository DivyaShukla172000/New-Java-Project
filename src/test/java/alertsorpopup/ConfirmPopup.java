package alertsorpopup;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConfirmPopup {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();

		// 2.Navigate to URL
		driver.get("https://practice-automation.com/popups/");
		
		Thread.sleep(2000);

		// 3. Maximize the Window
		driver.manage().window().maximize();

	
		driver.findElement(By.id("confirm")).click();
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		
		System.out.println(alert);
		
		//alert.accept(); // to click on ok
		alert.dismiss(); // to click on cancle

	}

}
