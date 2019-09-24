package myProj;


import static org.testng.Assert.assertEquals;

public class SignInMethods extends PageHandler {


    public void SignInSanity() throws InterruptedException {
        clickSignIn();

        addValueEmail("jim@momo.com");
        addValuePass("123456");

        clickLogIn();

        assertEquals(true, this.isSignInSuccessful(), "SignIn failed!");
        Thread.sleep(3000);
        driver.close();

    }

    public void clickSignIn() {

        this.clickElementByXpath("//*[@id=\"LoginB\"]");
    }

    public void addValueEmail(String Email) {

        this.sendKeysByXpath("//*[@id=\"ReEmailTB\"]", Email);
    }

    public void addValuePass(String Pass) {

        this.sendKeysByXpath("//*[@id=\"RePassTB\"]", Pass);
    }

    public void clickLogIn() {

        this.clickElementByXpath("//*[@id=\"ReBGetS\"]");
    }

    public boolean isSignInSuccessful() {
        return findElementByXpath("/html/body/h1") != null;

    }
}