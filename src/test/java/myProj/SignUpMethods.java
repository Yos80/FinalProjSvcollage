package myProj;


import static org.testng.Assert.assertEquals;

public class SignUpMethods extends PageHandler {

	
	
	public void SignUpSanity() throws InterruptedException {
		clickSignUp();
		
		addValueFirstName("Tem");
		addValueLastName("Bel");
		addValueEmail("jim@momo.com");
		addValuePass("123456");

		clickGetStarted();

		assertEquals(true, this.isSignUpSuccessful(), "Signup failed!");
		Thread.sleep(3000);
		driver.close();
	}

	public void clickSignUp() {
		this.clickElementByXpath("//*[@id=\"Sign-UpB\"]");
	}

	public void addValueEmail(String Email) {
		this.sendKeysByXpath("//*[@id=\"EmailTB\"]", Email);
	}

	public void addValuePass(String Pass) {
		this.sendKeysByXpath("//*[@id=\"PassTB\"]", Pass);
	}

	public void addValueFirstName(String firstName) {
		this.sendKeysByXpath("//*[@id=\"FNTB\"]", firstName);
	}

	public void addValueLastName(String lastName) {
		this.sendKeysByXpath("//*[@id=\"LNTB\"]", lastName);
	}

	public void clickGetStarted() {
		this.clickElementByXpath("//*[@id=\"BGetS\"]");
	}

	public boolean isSignUpSuccessful() {
		return findElementByXpath("/html/body/h1") != null;

	}
}
