package assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DragandDropUsingActionClass {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Launches Chrome and opens https://testautomationpractice.blogspot.com/
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Locates the draggable element using By.id("draggable")
		WebElement draggable = driver.findElement(By.id("draggable"));
		JavascriptExecutor jre = (JavascriptExecutor) driver;
		jre.executeScript("window.scrollBy(0,1300)");
		Thread.sleep(2000);

		// Locates the droppable element using By.id("droppable")
		WebElement droppable = driver.findElement(By.id("droppable"));

		// 4. Prints the text of the source element before drag
		String BeforeText =droppable.getText();
		System.out.println("Before Drag : " +BeforeText );
		
		
		// 5. Performs drag and drop using Actions class method dragAndDrop(source,
		// target)
		Actions action = new Actions(driver);
		action.dragAndDrop(draggable, droppable).perform();
		
		// 6. Prints the text of the drop target after the action to confirm the drop
		String afterText =droppable.getText();
		System.out.println("After Drag : " +afterText);
		
		
		// 7. Prints 'Drag and Drop performed successfully'
		if (afterText.equals("Dropped!")) {
			System.out.println(afterText+" Successfully!!");
		} else {
			System.out.println("Drag and Drop  Fails ");
		}
		// 8. Closes the browser

		driver.quit();

	}

}
