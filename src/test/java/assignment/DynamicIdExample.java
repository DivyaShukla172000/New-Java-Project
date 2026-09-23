package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicIdExample {

    public static void main(String[] args) {
    	
      
        WebDriver driver = new ChromeDriver();

        try {
        	
            // Load an HTML snippet with a dynamic ID ending in a random number
            String htmlSnippet = "data:text/html;charset=utf-8," +
                    "<button id='btn_submit_48291' type='submit'>Submit</button>";
            
            driver.get(htmlSnippet);

            // 1. Locate element using contains() matching the static prefix 'btn_submit'
            WebElement submitButton = driver.findElement(By.xpath("//button[contains(@id, 'btn_submit')]"));

            // 2. Check and print whether the element is enabled
            boolean isEnabled = submitButton.isEnabled();
            System.out.println("Is the submit button enabled? " + isEnabled);

            Thread.sleep(3000);
            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
  
            driver.quit();
            
           
        }
    }
}
