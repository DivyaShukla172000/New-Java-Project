package testng;

import org.testng.annotations.Test;

public class TestNGDemo {

	
	@Test
	public void login() {
		System.out.println("Logged into the application successfully");
	}
	
	
	@Test(priority=-2)
	public void logout() {	
		System.out.println("logout from the application successfully");
	}
	
	@Test(priority=1)
	public void applaunh() {
		System.out.println("application launch successfully");
	}

}
