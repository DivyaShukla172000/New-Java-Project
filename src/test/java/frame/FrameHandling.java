package frame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandling {

	public static void main(String[] args) {
		// 1. Launch the Chrome browser
		WebDriver driver = new ChromeDriver();
		
		
		// 2.Navigate to url using get method
		String url = "https://ui.vision/demo/webtest/frames/";
		driver.get(url);
		driver.manage().window().maximize();
		
		
		//3. How many frames/iframes are present on webpage
		int iframeCount=driver.findElements(By.tagName("frame")).size();
		System.out.println(iframeCount);
		
		
		//4. Enter 'Test Automation' text in Frame1 textfield
		WebElement frame1Element=driver.findElement(By.xpath("//frame[@src='frame_1.html']"));

		driver.switchTo().frame(frame1Element);
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Test Automation");

		//Switch back to main page/To come out of the specific frame
		driver.switchTo().defaultContent();
		
		//5.Enter 'Welcome to Frame 2' text in frame 2
		WebElement

		frame2Element=driver.findElement(By.xpath("//frame[@src='frame_2.html']"));

		driver.switchTo().frame(frame2Element);

		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Welcome to Frame 2");

		driver.switchTo().defaultContent();
		// 6.Enter 'Welcome to Frame 3' text in frame 3
		WebElement frame3Element =driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		driver.switchTo().frame(frame3Element);

		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Welcometo Frame 3");

		driver.switchTo().frame(0);
		driver.findElement(By.xpath("(//div[@class='AB7Lab Id5V1'])[2]")).click();
		driver.switchTo().defaultContent();
		driver.quit();
	}

}
// Git Check
