package testng;

import org.testng.annotations.Test;

public class Login {
	 @Test(priority =1 ,groups= {"sanity"})
	  public void LoginWithEmailId() {
		  System.out.println("Login with Email");
	  }
	  
	  @Test(priority=2 ,groups= {"sanity"})
	  public void LoginWithMobile() 
	  {
		  System.out.println("Login with Mobile Number ");
	  }
}
