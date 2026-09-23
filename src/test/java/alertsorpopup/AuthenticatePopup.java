package alertsorpopup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticatePopup {

	public static void main(String[] args) throws InterruptedException  {
		
		WebDriver driver = new ChromeDriver();

		// 2.Navigate to URL
		String username = "admin";
		String password = "vinothqa";
		
		Thread.sleep(2000);
		String url = "https://"+username+":"+password+"@vinothqaacademy.com/basic-auth-demo/protected/";
		driver.get(url);
		
		
		// 3. Maximize the Window
		driver.manage().window().maximize();


	}

}
