package testng;

import org.testng.annotations.Test;

public class SignUp {
  @Test(priority =1 ,groups= {"regression"})
  public void SignUpWithEmail() {
	  System.out.println("Sign Up With Email");
  }
  
  @Test(priority=2 ,groups= {"regression"})
  public void signUpWithMobileNo() 
  {
	  System.out.println("SignUp with Mobile Number ");
  }
}
