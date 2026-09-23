package assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DragandDropUsingClickHoldMovetoElementandRelease {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		WebElement draggable = driver.findElement(By.id("draggable"));
		JavascriptExecutor jre = (JavascriptExecutor) driver;
		jre.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(2000);
		WebElement droppable = driver.findElement(By.id("droppable"));
		

		//4. Performs drag and drop by chaining the following Actions methods step by step:

			//a. clickAndHold(source) — press and hold the mouse on source
		Actions act = new Actions(driver);

		act.clickAndHold(draggable).perform();

			//b. moveToElement(target) — move mouse to the target

		act.moveToElement(droppable).perform();
			//c. release() — release the mouse button
		
		act.release().perform();

			//d. build().perform() — execute the full chain
		act.build().perform();

		//5. Prints the drop target text after action to verify success
		String afterText =droppable.getText();
		System.out.println("After Action : " +afterText);
		

		//6. Closes the browser
		driver.quit();
	}

}
