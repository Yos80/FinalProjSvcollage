package myProj;


import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SignUpJunit extends SignUpMethods{

	
	@Test
	public void SignUpSanityChrome() throws InterruptedException {
		configureBrowserChrome();
		this.SignUpSanity();
	}	

	@Test
	public void SignUpJustFirstName() throws InterruptedException {
		configureBrowserChrome();

		addValueFirstName("Tem");
		clickGetStarted();
		assertEquals(false, this.isSignUpSuccessful(), "Signed up with only first name!");
		Thread.sleep(3000);
		driver.close();
	}

	@Test
	public void SignUpFirstAndLast() throws InterruptedException {
		configureBrowserChrome();

		addValueFirstName("Tem");
		addValueLastName("Bel");
		clickGetStarted();
		assertEquals(false, this.isSignUpSuccessful(), "Signed up with only first name and last name!");
		Thread.sleep(3000);
		driver.close();
	}

	@Test
	public void SignUpFirstAndLastAndEmail() throws InterruptedException {
		configureBrowserChrome();

		addValueFirstName("Tem");
		addValueLastName("Bel");
		addValueEmail("joejoe@hmail.com");
		clickGetStarted();
		assertEquals(false, this.isSignUpSuccessful(), "Signed up with everything but a password!");
		Thread.sleep(3000);
		driver.close();

	}

	@Test
	public void SignUpPassOnly() throws InterruptedException {
		configureBrowserChrome();

		addValuePass("123456");
		clickGetStarted();
		assertEquals(false, this.isSignUpSuccessful(), "Signed up with everything only a password!");
		Thread.sleep(3000);
		driver.close();
	}
	
	@Test
	public void SignUpInvalidEmail() throws InterruptedException {
		configureBrowserChrome();

		addValueFirstName("Tem");
		addValueLastName("Bel");
		addValueEmail("jimmomo.com@");
		addValuePass("123456");
		assertEquals(false, this.isSignUpSuccessful(), "Signed up with invalid email");
		Thread.sleep(3000);
		driver.close();
	}
	
	@Test
	public void SignUpColorCheck() throws InterruptedException {
		configureBrowserChrome();

		String headerColor = getCssByXpath("/html/body/div" , "background");
		assertEquals("rgba(19, 35, 47, 0.9) none repeat scroll 0% 0% / auto padding-box border-box", headerColor, "color check");
		Thread.sleep(3000);
		driver.close();
	}
	
	
}
