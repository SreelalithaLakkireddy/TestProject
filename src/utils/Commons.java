package utils;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Commons {
	
	WebDriver driver;
	
	public Commons(WebDriver d) {
		// TODO Auto-generated constructor stub
		this.driver=d;
	}

	public String randomString() {

	    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	    StringBuilder sb = new StringBuilder();
	    StringBuilder sb1=sb.append("Intellisense_");
	    Random random = new Random();
	    int length = 5;

	    for(int i = 0; i < length; i++) {

	      int index = random.nextInt(alphabet.length());
	      char randomChar = alphabet.charAt(index);
	      sb1.append(randomChar);
	    }

	    String randomString = sb.toString();
	    System.out.println("Random String is " + randomString);

	    return randomString;
	}

	public void customWait(By object,WebDriver driver) {
	      
		  System.out.println("Object is " + object);
		  
		  WebDriverWait wait = new WebDriverWait(driver, 60);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(object));

	   }
	  public void clickAction(By object,WebDriver driver) {
	      
		  System.out.println("Object is " + object);
	
	         Actions builder = new Actions(driver);
	         builder.click(driver.findElement(object)).build().perform();

	   }
}
