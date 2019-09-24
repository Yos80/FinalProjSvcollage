package myProj;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.NoSuchElementException;

public class PageHandler {
	WebDriver driver;
	String testPage = "/Users/Yosi/eclipse-workspace/FinalProjSvcollage/src/main/resources/htmlfiles/index.html";

	
	public PageHandler() {
		
	}
	
	public void configureBrowserChrome() {
		this.driver = new ChromeDriver();
		this.setPageUrl();
	}
	
	public PageHandler (String testPage) {
		this.setPageUrl(testPage);
	}
	
	public WebElement findElementByXpath(String xpath) {
		try {
			WebElement element = driver.findElement(By.xpath(xpath));
			return element;
		}
		catch (NoSuchElementException e) {
			return null;
		}
	}

	public void clickElementByXpath(String xpath) {
		findElementByXpath(xpath).click();
	}
	
	public void clickElement(WebElement element) {
		element.click();
	}
	
	public void setPageUrl() {
		driver.get(this.testPage);
		
	}
	public void setPageUrl(String testPage) {
		driver.get(testPage);
		
	}
	public void sendKeysByXpath(String xpath , String keys) {
		findElementByXpath(xpath).sendKeys(keys);
	}
	public void sendKeys(WebElement element) {
		element.sendKeys();
	}
	public String getCssByXpath(String xpath , String css) {
		return findElementByXpath(xpath).getCssValue(css);
	}

	}


