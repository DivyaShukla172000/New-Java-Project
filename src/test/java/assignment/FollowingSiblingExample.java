package assignment;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FollowingSiblingExample {

    public static void main(String[] args) {
    	
        WebDriver driver = new ChromeDriver();

        try {
        	
            // Load the HTML snippet
        	
            String htmlSnippet = "data:text/html;charset=utf-8," +
                    "<ul>" +
                    "<li id='item1'>Home</li>" +
                    "<li id='item2'>About</li>" +
                    "<li id='item3'>Contact</li>" +
                    "</ul>";
            
            driver.get(htmlSnippet);

            // 1. Locate the <li> element with id 'item1'
            WebElement item1 = driver.findElement(By.id("item1"));

            // 2. Locate the next sibling <li> using following-sibling:: axis
            WebElement nextSibling = item1.findElement(By.xpath("./following-sibling::li[1]"));

            // 3. Print the text of the following sibling element
            System.out.println("Following sibling text: " + nextSibling.getText());

            Thread.sleep(3000);
            driver.quit();

        } catch (Exception e) {
        	
            driver.quit();
            
        }
    }
}