package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrecedingSiblingExample {

    public static void main(String[] args) {
    	
        WebDriver driver = new ChromeDriver();

        try {
        	
            // Load the HTML snippet
            String htmlSnippet = "data:text/html;charset=utf-8," +
                    "<table>" +
                    "<tr>" +
                    "<td>Name</td>" +
                    "<td>Email</td>" +
                    "<td id='action'>Action</td>" +
                    "</tr>" +
                    "</table>";
            
            driver.get(htmlSnippet);

            // 1. Locate the <td> element with id 'action'
            WebElement actionCell = driver.findElement(By.id("action"));

            // 2. Locate the immediately preceding <td> using preceding-sibling:: axis
            WebElement precedingSibling = actionCell.findElement(By.xpath("./preceding-sibling::td[1]"));

            // 3. Print the text of the preceding sibling element
            System.out.println("Preceding sibling text: " + precedingSibling.getText());

            Thread.sleep(3000);
            driver.quit();

        } catch (Exception e) {
        	
            // 4. Close the browser
            driver.quit();
            
        }
    }
}