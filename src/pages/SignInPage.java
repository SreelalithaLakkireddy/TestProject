package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
	WebDriver driver;
	
	By userName=By.xpath("//input[@id='emailAddress']");
	By password=By.xpath("//input[@id='password']");
	By signinButton=By.xpath("//h6[contains(text(),'Sign In')]");
	
	public SignInPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void SignIn(String strUserName,String strPassword) {
		driver.findElement(userName).sendKeys(strUserName);
		driver.findElement(password).sendKeys(strPassword);
		driver.findElement(signinButton).click();
		
	}

}
