package com.stadsolution.selenium.programs;

//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebDriver;

//1. Launch the Browser 
//2. URL navigation  to https://in.bookmyshow.com/login
//3. Validate the Title
//4. Close the Browser

public class BrowserLaunch {

	public static void main(String[] args) {
		
//		ChromeDriver driver = new ChromeDriver();// this is limited for only chrome driver 
		
		
		//1. Launch the Browser 
		WebDriver driver = new EdgeDriver(); // web driver is Interface and driver is reference variable for instance of webDriver.this is most helpful for cross browser testing , parent interface o remote web Driver
		
		//2. URL navigation  to https://in.bookmyshow.com/login
		driver.get("https://in.bookmyshow.com/login");
		
		//3. Validate the Title
		String ActualTitle =driver.getTitle();
		
		if (ActualTitle.equals("Movie Tickets, Plays, Sports, Music Concerts, Theater & Reviews BookMyShow")) {
			System.out.println("Test is pass");
		
		}else
		{
		System.out.println("Test is fail");
		}
		
		driver.close();
		}

}
