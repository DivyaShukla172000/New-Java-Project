package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssStartsWithExample {

    public static void main(String[] args) {
    	
   
        WebDriver driver = new ChromeDriver();

        try {
        	
            // Load HTML snippet containing a dynamic ID with a fixed prefix
            String htmlSnippet = "data:text/html;charset=utf-8," +
                    "<div id='modal_popup_5512' class='active-modal overlay'>Notification Content</div>";
            
            driver.get(htmlSnippet);

            // 1. Locate the element using CSS selector ^= (starts-with) operator
            WebElement modalElement = driver.findElement(By.cssSelector("[id^='modal_popup']"));

            // 2. Extract and print the tag name and class attribute
            System.out.println("Tag Name: " + modalElement.getTagName());
            System.out.println("Class Attribute: " + modalElement.getAttribute("class"));

            Thread.sleep(3000);
            driver.quit();


        } catch (Exception e) {
        	
            e.printStackTrace();
           // 3. Close the browser
            driver.quit();
        }
    }
}