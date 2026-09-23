package mousesection;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MouseSectionDemo {

	public static void main(String[] args) throws InterruptedException {

		//Mouse Action assignment https://dribbble.com/tags/hover-effect
		WebDriver driver = new ChromeDriver();

		// 2.Navigate to URL
		String username = "admin";
		String password = "vinothqa";

//		String url = "https://"+username+":"+password+"@https://vinothqaacademy.com/mouse-event/";
//		driver.get(url);

		driver.get("https://vinothqaacademy.com/mouse-event/");

		Thread.sleep(2000);
		// 3. Maximize the Window
		driver.manage().window().maximize();

		// JavascriptExecutor jre = new Javascript
		
		  // Scroll to bottom of page
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,900)");

		Thread.sleep(2000);
		// WebElement dbClick = driver.findElement(By.id("doubleBtn"));

		Actions act = new Actions(driver);

		// act.doubleClick(dbClick).build().perform();

//		String click = driver.findElement(By.id("doubleStatus")).getText();
//		
//		if (click.equals("Double Click Detected ✅")) {
//			System.out.println(click);
//		}
//		else {
//			System.out.println("Fails ");
//		}
//		
//		// Right Click
//	WebElement rightclick = driver.findElement(By.id("rightBtn"));
//	
//	act.contextClick(rightclick).perform();
//	String rightclicktext = driver.findElement(By.id("rightStatus")).getText();
//	
//	if (rightclicktext.equals("Menu opened ✅")) {
//		System.out.println(rightclicktext);
//	}
//	else {
//		System.out.println("Right Click Me Fails ");
//	}

		Thread.sleep(2000);
		// Drag and Drop
		/*
		 * WebElement drag = driver.findElement(By.id("dragItem")); WebElement drop =
		 * driver.findElement(By.id("dropZone")); act.dragAndDrop(drag, drop).perform();
		 * 
		 * String DragDropText = driver.findElement(By.id("dragStatus")).getText();
		 * 
		 * if (DragDropText.equals("Dropped Successfully ✅")) {
		 * System.out.println(DragDropText); } else {
		 * System.out.println("Drag and Drop  Fails "); }
		 */

		// mouse hover
		/*
		 * WebElement hoverElement = driver.findElement(By.id("tooltipTarget"));
		 * 
		 * act.moveToElement(hoverElement).perform(); String hoverElementText =
		 * driver.findElement(By.id("tooltipStatus")).getText();
		 * 
		 * if (hoverElementText.equals("Tooltip Visible ✅")) {
		 * System.out.println("Mouse Hover Susessfull"); } else {
		 * System.out.println("Mouse hover Fails "); }
		 */
		// Slider
		WebElement slider = driver.findElement(By.id("handle_max"));

		act.dragAndDropBy(slider, 240, 0).perform();
		String hoverElementText = driver.findElement(By.id("sliderStatus")).getText();

		System.out.println("Exact Location  : " + slider.getLocation());

		if (hoverElementText.equals(hoverElementText)) {
			System.out.println("Slider " + hoverElementText);
		} else {
			System.out.println("Mouse hover Fails ");
		}
		driver.quit();
		}

}


