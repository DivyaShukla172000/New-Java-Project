package dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HiddenDropDown {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriver driver = new ChromeDriver();

		// 2.Navigate to URL
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		// 3. Maximize the Window
		driver.manage().window().maximize();
		
		Thread.sleep(4000);
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		
		driver.findElement(By.xpath("//button[(contains(.,'Login'))]")).click();
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//a[@class='oxd-main-menu-item active']")).click();
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("driver.findElement(By.xpath(\"//div[@class='oxd-form-actions']\"))")).click();
		
		List<WebElement> optionElements = driver.findElements(By.xpath("//label[text()='Employment Status']/../following-sibling::div/div/div[2]//div//span"));
		
	for(WebElement option : optionElements) {
		System.out.println(option.getText());
	}
		
	}

}
