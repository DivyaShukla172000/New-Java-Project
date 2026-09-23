package customizelocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathExamples {

	public static void main(String[] args) {
	
		//1.Lunch the browser
				WebDriver driver = new ChromeDriver();
				
				//2.Navigate to URL
				driver.get("https://practicetestautomation.com/");
				
				//3. Maximize the Window
				driver.manage().window().maximize();
				
				//Click on Practice link using Single Attribue x-path
				driver.findElement(By.xpath("//li[@id='menu-item-20']")).click();
				
				driver.findElement(By.linkText("Test Login Page")).click();
				
				//mutiple attribute
			//	driver.findElement(By.xpath("//input[@id='username'][@name = 'username']")).sendKeys("sudent");
				
//				// and operator
			driver.findElement(By.xpath("//input[@id='username' and  @name = 'username']")).sendKeys("student");
//				
//				//or Oprators ek galt bhi chalega as per the OR condition 
			//	driver.findElement(By.xpath("//input[@id='username' or  @name = 'usname']")).sendKeys("student");
//

				//click on submit button using text()
				driver.findElement(By.xpath("//button[text() = 'Submit']")).click();
				
				//wih text() contain
				//WebElement errorText = driver.findElement(By.xpath("//div[contains(text(),'invalid!')]"));
				
				//with starts-with
				WebElement errorText = driver.findElement(By.xpath("//div[starts-with(text(),'Your')]"));
				String MSG = errorText.getText();
				
				if (MSG.equals("Your password is invalid!")) {
					System.out.println("Correct Text");
				}
				else {
					System.out.println("In-Correct Text");
				}
				
		
				
				
				
	}

}
