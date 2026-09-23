package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Set;

public class WindowSwitch {
	

	    public static void main(String[] args) {
	        // 1. Launches Chrome and opens the website
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://testautomationpractice.blogspot.com/");

	        // 2. Saves the main window handle
	        String mainHandle = driver.getWindowHandle();

	        // 3. Scrolls to and clicks the 'New Tab' button
	        WebElement newTabButton = driver.findElement(By.xpath("//button[normalize-space()='New Tab']"));
	        
	        // Scroll button into view to ensure it is clickable
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", newTabButton);
	        newTabButton.click();

	        // 4. Waits briefly for the new tab to open
	        try {
	            Thread.sleep(3000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        // 5. Retrieves all window handles
	        Set<String> allHandles = driver.getWindowHandles();

	        // 6. Prints the total number of open windows/tabs
	        System.out.println("Total windows/tabs open: " + allHandles.size());

	        // 7. Switches to the new tab by iterating handles
	        for (String handle : allHandles) {
	            if (!handle.equals(mainHandle)) {
	                driver.switchTo().window(handle);
	                break;
	            }
	        }

	        // 8. Prints the title and URL of the new tab
	        System.out.println("New Tab Title: " + driver.getTitle());
	        System.out.println("New Tab URL: " + driver.getCurrentUrl());

	        // 9. Closes the new tab
	        driver.close();

	        // 10. Switches focus back to the main window
	        driver.switchTo().window(mainHandle);

	        // 11. Prints the main window title to confirm switch back
	        System.out.println("Main Window Title: " + driver.getTitle());

	        // 12. Closes the browser
	        driver.quit();
	    }
	


}
