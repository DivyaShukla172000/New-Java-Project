package assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseHover {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Launches Chrome and opens https://testautomationpractice.blogspot.com/
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Locates the 'Point Me' button using: By.xpath("//button[normalize-space()='Point Me']")
		WebElement pointMe =
				driver.findElement(By.xpath("//button[normalize-space()='Point Me']"));
		JavascriptExecutor jre = (JavascriptExecutor) driver;
		jre.executeScript("window.scrollBy(0,900)");
		Thread.sleep(2000);
		
		//3. Uses Actions.moveToElement() to hover the mouse over 'Point Me'
		Actions action = new Actions(driver);
		action.moveToElement(pointMe).perform();
		 String hoverElementText =
				  driver.findElement(By.xpath("//a[text()='Mobiles']")).getText();
				  
				 if (hoverElementText.equals("Mobiles")) {
				 System.out.println("Hovered over 'Point Me' button."); 
				 } else {
				 System.out.println("Mouse hover Fails "); 
				 }
		 
		  
//		4. After hovering, locates the 'Mobiles' sub-menu link: By.xpath("//a[text()='Mobiles']")
		WebElement mobileLink =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Mobiles']")));

		
//		5. Prints whether the Mobiles link is displayed after hover
		boolean isDispaly =mobileLink.isDisplayed();
		System.out.println("Mobile Link Is Displayed "+isDispaly);
		
//		6. Clicks the 'Mobiles' link
		mobileLink.click();
		
//		7. Prints 'Mobiles sub-menu clicked successfully'
		 System.out.println("Mobiles sub-menu clicked successfully");
		 
//		8. Closes the browser
		driver.quit();
		
	

	}

}
