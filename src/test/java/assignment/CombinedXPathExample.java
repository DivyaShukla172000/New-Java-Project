package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CombinedXPathExample {

    public static void main(String[] args) {
    	
       
        WebDriver driver = new ChromeDriver();

        try {
        	
            // Load the HTML snippet directly
            String htmlSnippet = "data:text/html;charset=utf-8," +
                    "<div class='row'>" +
                    "<label>Password</label>" +
                    "<input type='password' id='pwd' />" +
                    "<span class='error'>Password is required</span>" +
                    "</div>";
            
            driver.get(htmlSnippet);

            // 1. Locate the <input> with id 'pwd'
            WebElement passwordInput = driver.findElement(By.id("pwd"));

            // 2. Navigate to parent <div>, then find the <span class='error'> sibling within it
            WebElement errorMessage = passwordInput
                    .findElement(By.xpath("./parent::div"))
                    .findElement(By.xpath(".//span[@class='error']"));

            // 3. Print the error message text
            System.out.println("Error message text: " + errorMessage.getText());

            // Optional 3-second delay to observe execution
            Thread.sleep(3000);
            
            // 4. Close the browser
            driver.quit();

        } catch (Exception e) {
        
            driver.quit();
        }
    }
}