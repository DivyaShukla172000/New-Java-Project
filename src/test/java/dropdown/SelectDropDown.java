package dropdown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDown {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		// 2.Navigate to url using get method
		String url = "https://testautomationpractice.blogspot.com/";
		driver.get(url);
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		
		// Select India from Country Drop Down by using selectByVisible Method
		
		WebElement dropdownElement = driver.findElement(By.id("country"));
		
		Select select = new Select(dropdownElement);
		
		//select.selectByVisibleText("India");
		
		//select.selectByValue("India");
		
		select.selectByIndex(1);

		List<WebElement> option = select.getOptions();
		int optionCount = option.size();
		System.out.println(optionCount);
		
//		for (int i =0 ; i<optionCount; i++) {
//			String text = option.get(i).getText();
//			System.out.println("Text "+text);
//			
//		}
		
		for (WebElement options :option) {
			System.out.println(options.getText());
			
		}
		
	

	}

}
