package assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DOBDropdown {
	
	public static void main(String args[]) {
		
		WebDriver driver = new ChromeDriver();
		
//	1. Navigates to https://www.automationexercise.com/login
		driver.get("https://www.automationexercise.com/login");
		driver.manage().window().maximize();

//		2. Enters name and unique email, clicks Signup to reach the Account Information form
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Div");
		driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("divyashukla@gamil.com");

//		3. Waits for the form to load
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//button[normalize-space()='Signup']")).click();
//		4. Uses the Select class to:
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		JavascriptExecutor jre = (JavascriptExecutor) driver;
		jre.executeScript("window.scrollBy(0,900)");
		 //  Select Day '15' using selectByValue("15")
        WebElement dayElement = driver.findElement(By.id("days")); // Replace with actual locator
        Select daySelect = new Select(dayElement);
        daySelect.selectByValue("15");

        //  Select Month 'December' using selectByVisibleText("December")
        WebElement monthElement = driver.findElement(By.id("months")); // Replace with actual locator
        Select monthSelect = new Select(monthElement);
        monthSelect.selectByVisibleText("December");

        //  Select Year '1997' using selectByValue("1997")
        WebElement yearElement = driver.findElement(By.id("years")); // Replace with actual locator
        Select yearSelect = new Select(yearElement);
        yearSelect.selectByValue("1997");

        
        //  Print the selected option text from each dropdown
        System.out.println("Selected Day: " + daySelect.getFirstSelectedOption().getText());
        System.out.println("Selected Month: " + monthSelect.getFirstSelectedOption().getText());
        System.out.println("Selected Year: " + yearSelect.getFirstSelectedOption().getText());
        
        driver.close();
		
		

       

       

       
}
}

