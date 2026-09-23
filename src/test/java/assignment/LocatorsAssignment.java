package assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsAssignment {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		//Q1: Locate an Element by ID
		// Launches Chrome and opens https://www.google.com
		
		/*try {
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		WebElement Serchfeild = driver.findElement(By.name("q"));
		Serchfeild.sendKeys("Selenium WebDriver");
		
		 String enteredText = Serchfeild.getAttribute("value");
		
		if (enteredText.equals("Selenium WebDriver")) {
			System.out.println("Element found and text entered");
			driver.close();
		}
		else {
			System.out.println("Element not found and text not entered");
			driver.quit();
		}
		}
		 catch (Exception e) {
	            System.out.println("An unexpected error occurred: " + e.getMessage());
	        } 
		*/
		
		
		
		
		/*Q2: Locate an Element by Name Attribute*/
		/*
		try {
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		WebElement Serchfeild = driver.findElement(By.id("q"));
		Serchfeild.sendKeys("Selenium WebDriver");
		
		 String enteredText = Serchfeild.getAttribute("value");
		
		if (enteredText.equals("Selenium WebDriver")) {
			System.out.println("Element found and text entered");
			driver.close();
		}
		else {
			System.out.println("Element not found and text not entered");
			driver.quit();
		}
		}
		 catch (Exception e) {
	            System.out.println("An unexpected error occurred");
	        } 
	        */
	          
		
		/*Q3: Locate an Element by CSS Selector*/
		
		/*
		  try {		
		  driver.get("https://www.google.com");
		driver.manage().window().maximize();
		Thread.sleep(3000);
			List<WebElement> searchButtons = driver.findElements(By.cssSelector("input[name='btnK']"));
			for (WebElement btn : searchButtons) {
			    if (btn.isDisplayed()) {
			        System.out.println("Found the visible search button!");
			        break;
			    }
		}}
		 catch (Exception e) {
	            System.out.println("An unexpected error occurred");
	        } 
			*/
		
		
		/*Q4: Locate an Element by XPath Using Absolute Path*/
		
		/*try {
			driver.get("https://www.google.com");
			driver.manage().window().maximize();
			Thread.sleep(3000);
			WebElement  search =driver.findElement(By.xpath("//textarea[@name='q']"));
			search.sendKeys("clearrrr....");
			Thread.sleep(3000);
			search.clear();
			search.sendKeys("XPath Locator");
			System.out.println("XPath locator worked successfully"); 
			Thread.sleep(3000);
			driver.quit();
		}
		 catch (Exception e) {
	            System.out.println("An unexpected error occurred");
	        } 
			
		*/
		
		/* Q5: Locate Multiple Elements by Class Name */
		try {
			driver.get("https://www.wikipedia.org");
			List<WebElement> totalNoOfATag = driver.findElements(By.tagName("a"));
			System.out.println("Total No. Of Anchor Tag are : "+totalNoOfATag.size());
			
			for(int i = 0 ; i <=totalNoOfATag.size();i++) {
				System.out.println(totalNoOfATag.get(i).getText());
				if(i==2) 
					break;
			}	
			driver.quit();
		}
		catch (Exception e) {
            System.out.println("An unexpected error occurred");
        }

	}

}
