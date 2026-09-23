package waitmethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Swaimethods {

	public static void main(String[] args) {
	
		WebDriver driver = new ChromeDriver();
		
		//2.Navigate to URL
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		//3. Maximize the Window
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.findElement(By.name("username")).sendKeys("Admin");
		
		
	}

}
