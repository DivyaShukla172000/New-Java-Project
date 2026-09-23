package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class PriceRangeSlider {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		Actions action = new Actions(driver);
	driver.get("https://testautomationpractice.blogspot.com/");
	driver.manage().window().maximize();
	JavascriptExecutor jre = (JavascriptExecutor) driver;
	jre.executeScript("window.scrollBy(0,1900)");
	
	//2. Locates the slider handle: By.xpath("//div[@id='slider']/span")
	WebElement slider =driver.findElement(By.xpath("//div[@id='slider-range']/span/.."));
	WebElement amountDisplay =driver.findElement(By.id("amount"));
	
	//3. Prints the current amount displayed in id='amount'
	 String initialAmount = amountDisplay.getAttribute("value");
     System.out.println("Initial Amount: " + initialAmount);

     // 4. Uses Actions to drag the slider handle 50 pixels to the right
     Actions actions = new Actions(driver);
     actions.clickAndHold(slider)
            .moveByOffset(50, 0)
            .release()
            .perform();

     // 5. Prints the new amount after moving the slider
     String newAmount = amountDisplay.getAttribute("value");
     System.out.println("New Amount after moving: " + newAmount);

     // 6. Prints success message
     System.out.println("Slider moved successfully");
	
	
	Thread.sleep(3000);
	driver.quit();
	}

}
