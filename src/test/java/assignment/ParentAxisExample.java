package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ParentAxisExample {

    public static void main(String[] args) {
    	
        // 4 automatically handles driver management using Selenium Manager.
        WebDriver driver = new ChromeDriver();

        try {
        	
            // Load the HTML content directly using a data URL =simulates loading a local file
            String htmlSnippet = "data:text/html;charset=utf-8," +
                    "<div class='form-group'>" +
                    "<label>Username</label>" +
                    "<input type='text' id='username' />" +
                    "</div>";
            
            
            driver.get(htmlSnippet);
            

            // 1. Locate the <input> element with id 'username'
            WebElement inputElement = driver.findElement(By.id("username"));

            // 2. Navigate to its parent <div> using the XPath parent:: axis
            WebElement parentElement = inputElement.findElement(By.xpath("./parent::div"));

            // 3. Print the tag name of the parent element
            System.out.println("Parent element tag name: " + parentElement.getTagName());
            
            Thread.sleep(5000);

        } catch (Exception e) {
        	
            e.printStackTrace();
            
        } finally {
        	
            // 4. Close the browser
            driver.quit();
            
        }
    }
}