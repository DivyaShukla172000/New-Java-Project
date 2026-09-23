package keyboardsection;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardActionDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.get("https://text-compare.com/");

		Thread.sleep(2000);
		// 3. Maximize the Window
		driver.manage().window().maximize();

		/*
		 * // JavascriptExecutor jre = new Javascript JavascriptExecutor jse =
		 * (JavascriptExecutor) driver; jse.executeScript("window.scrollBy(0,0)");
		 */
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("inputText1")).sendKeys("Text Hello Divya");
		Thread.sleep(2000);
		
		//1 Ctrl+A to select all
		Actions act = new Actions(driver);
		
		act.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
		Thread.sleep(4000);
		
		//2 Ctrl + c select all
		act.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();
		
		// TAB switvhto 2nd Box
		act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		Thread.sleep(4000);
		
		// Ctrl + v to paste in a2nd box
		act.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();
		driver.quit();
		

	}

}
