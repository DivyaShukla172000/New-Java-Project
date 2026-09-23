package xpathaxes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpathaxes {

	public static void main(String[] args) {
		

		//1.Lunch the browser
				WebDriver driver = new ChromeDriver();
				
				//2.Navigate to URL
				driver.get("https://practicetestautomation.com/");
				
				//3. Maximize the Window
				driver.manage().window().maximize();
				
				//Click on Practice link usng Xpath asxes
				driver.findElement(By.xpath("//li[@id='menu-item-20']/a")).click();
				
				driver.findElement(By.xpath("//section[@id='main-container']//a[text()='Test Login Page']")).click();
				
				driver.findElement(By.xpath("//div[@id='form']/descendant::input[1]")).sendKeys("student");
				
				String username = driver.findElement(By.xpath("//input[@id='username']/preceding-sibling::label")).getText();
				if(username.equals("Username")) {
					System.out.println("Correct");
				}
				else {
					System.out.println("IN-correct Username");
				}
				
				
				

	}

}
