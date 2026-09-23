package com.stadsolution.selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.remote.service.DriverFinder;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		
		//1.Lunch the browser
		WebDriver driver = new ChromeDriver();
		
		//2.Navigate to URL
		driver.get("https://practicetestautomation.com/");
		
		//3. Maximize the Window
		driver.manage().window().maximize();
		
		//Thread.sleep(3000); //Hard wait
		
		//4. Click on Practice link using ID that we are using to locating the elements
		//By is the Abstract class
		//driver.findElement(By.id("menu-item-20")).click();
		
		WebElement we = driver.findElement(By.id("menu-item-20"));// Second way to write this
		we.click();
		//5. Click on Test Login Page using Linked text
		//driver.findElement(By.linkText("Test Login Page")).click();
		driver.findElement(By.partialLinkText("Test Login")).click();
		
		Thread.sleep(3000); //Hard wait
		
		//6. Enter Student as an username using name attribute
		//driver.findElement(By.name("username")).sendKeys("student");
		
		//Thread.sleep(3000); //Hard wait
		
		//7. Enter Password as an type
		//driver.findElement(By.name("password")).sendKeys("Password123");
		//Thread.sleep(3000); //Hard wait
		
		//8. Click on Submit button by Class
		//driver.findElement(By.className("btn")).click();
		
		//9. Count number of link on the web page using tag 		
		int noOflink = driver.findElements(By.tagName("a")).size();
		System.out.println("No of anchor tags : "+noOflink);

	}

}
