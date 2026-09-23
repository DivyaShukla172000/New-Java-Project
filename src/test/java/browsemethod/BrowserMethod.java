package browsemethod;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

public class BrowserMethod {

	public static void main(String[] args) throws Exception   {
		WebDriver driver = new ChromeDriver();
		
		//2.Navigate to URL
		driver.get("https://practicetestautomation.com/");
		
		//3. Maximize the Window
		driver.manage().window().maximize();
		
		driver.close();
		
		Thread.sleep(3000);
		RemoteWebDriver remoteDriver = (RemoteWebDriver)driver;
		
		SessionId sessionID = remoteDriver.getSessionId();
		System.out.println("Session ID : "+sessionID);

	}

}
