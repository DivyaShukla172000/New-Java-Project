package waitmethods;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		// 2.Navigate to URL
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		// 3. Maximize the Window
		driver.manage().window().maximize();

		// Declaration
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);

		WebElement usernameElement = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.name("username"));

			}

		});
		usernameElement.sendKeys("Admin");
		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		 driver.findElement(By.name("username")).sendKeys("Admin");

	}

}
