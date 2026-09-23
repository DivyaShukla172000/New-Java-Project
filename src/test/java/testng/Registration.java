package testng;

import org.testng.annotations.Test;

public class Registration {
  @Test(priority =1 ,groups= {"sanity","regression","Funtional"})
  public void RegistrationWithEmail() {
	  System.out.println("Registration witt Mail");
  }
  
  @Test(priority =2 ,groups= {"sanity","regression","Funtional"})
  public void registrationWithMobileNo() 
  {
	  System.out.println("Registration with Mobile Number ");
  }
 
}
