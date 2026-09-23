package com.stadsolution.selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomizedLocators {

	public static void main(String[] args) throws InterruptedException {
		//1.Lunch the browser
		WebDriver driver = new ChromeDriver();
		
		//2.Navigate to URL
		driver.get("https://practicetestautomation.com/");
		
		//3. Maximize the Window
		driver.manage().window().maximize();
		
		//Thread.sleep(3000); //Hard wait
		
		//4. Click on Practice link using ID that we are using to locating the elements
		WebElement we = driver.findElement(By.id("menu-item-20"));// Second way to write this
		we.click();
		
		//5. Click on Test Login Page using Linked text
		driver.findElement(By.linkText("Test Login Page")).click();
		

		//6. Enter Student as an username using tag#id CSS Selector
		//driver.findElement(By.cssSelector("input#username")).sendKeys("student");
		
		//Enter Student as an username using tag[attribute = 'value'] CSS Selector
		driver.findElement(By.cssSelector("input[name='username']")).sendKeys("student");
		
		Thread.sleep(3000); //Hard wait
		
		//7. Enter Password as Password123 using tag#id CSS Selector
		driver.findElement(By.cssSelector("input#password")).sendKeys("Password123");
		
		
		//8. Click on Submit button as tag class CSS Selector button.btn
		//driver.findElement(By.cssSelector("button.btn")).click();
		
		//Click on Submit button as tag class CSS Selector tag.class[attribute = 'value']
		driver.findElement(By.cssSelector("button.btn[id= 'submit']")).click();
	}

}
