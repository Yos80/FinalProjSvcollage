package myProj;


import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SignInJunit extends SignInMethods{

	
	
	@Test
	public void SignInSanityChrome() throws InterruptedException {
		configureBrowserChrome();
		this.SignInSanity();
	}	
	
	
	@Test
	public void SignInJustEmail() throws InterruptedException {
		configureBrowserChrome();
		clickSignIn();

		addValueEmail("jim@momo.com");
		
		clickLogIn();
		
		assertEquals(false, this.isSignInSuccessful(), "SignIn with only email");
		Thread.sleep(3000);
		driver.close();

	}
	
	@Test
	public void SignInJustPass() throws InterruptedException {
		configureBrowserChrome();
		clickSignIn();

		addValuePass("123456");
		
		clickLogIn();
		
		assertEquals(false, this.isSignInSuccessful(), "SignIn with only password");
		Thread.sleep(3000);
		driver.close();

	}
	
	@Test
	public void SignInInvalidEmail() throws InterruptedException {
		configureBrowserChrome();
		clickSignIn();

		addValueEmail("@jimmomo.com");
		addValuePass("123456");
		
		clickLogIn();
		
		assertEquals(false, this.isSignInSuccessful(), "SignIn with invalid email");
		Thread.sleep(3000);
		driver.close();

	}
	
}
