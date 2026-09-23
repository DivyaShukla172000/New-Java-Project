package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StartsWithIdExample {

    public static void main(String[] args) {
    	
       
        WebDriver driver = new ChromeDriver();

        try {
        	
            // Load HTML snippet containing a dynamic ID with a fixed prefix
            String htmlSnippet = "data:text/html;charset=utf-8," +
                    "<div id='user_panel_7392'>Welcome, Alex!</div>";
            
            driver.get(htmlSnippet);
            // 1. Locate element using starts-with() matching the static prefix 'user_panel'
            WebElement userPanel = driver.findElement(By.xpath("//div[starts-with(@id, 'user_panel')]"));

            // 2. Extract and print the element text
            String panelText = userPanel.getText();
            System.out.println("Panel Text: " + panelText);

            Thread.sleep(3000);
            driver.quit();

        } catch (Exception e) {
        	
            e.printStackTrace();
           
            // 3. Close the browser
            driver.quit();
        }
    }
}