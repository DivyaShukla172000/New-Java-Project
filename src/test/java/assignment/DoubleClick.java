package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class DoubleClick {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
			Actions action = new Actions(driver);
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		JavascriptExecutor jre = (JavascriptExecutor) driver;
		jre.executeScript("window.scrollBy(0,900)");
		
		//2. Locates Field1 (id='field1') and prints its current value using getAttribute('value')
		WebElement f1 = driver.findElement(By.id("field1"));
		String text =f1.getAttribute("value");
		System.out.println("Print Field 1 value "+text);
		
		//3. Locates Field2 (id='field2') and prints its value before the double click
		WebElement f2 = driver.findElement(By.id("field2"));
		String text2 =f2.getAttribute("value");
		System.out.println("Print Field 2 before Coping the value value "+text2);
		
		//4. Locates the 'Copy Text' button: By.xpath("//button[normalize-space()='Copy Text']")
		WebElement dbClick =driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		
		//5. Performs a double click on the button using Actions.doubleClick()
		action.doubleClick(dbClick).build().perform();
		System.out.println("Double clicked the 'Copy Text' button.");

		//6. Reads Field2's value after the double click
		String field2ValueAfter = f2.getAttribute("value");
        System.out.println("Field2 value after double click: " + field2ValueAfter);
		
	
		//7. Asserts Field2 equals 'Hello World!' and prints PASS or FAIL
		if (field2ValueAfter.equals("Hello World!")) {
			System.out.println("PASS");
		}
		else {
			System.out.println("Fails ");
		}
		
		driver.quit();

	}

}
