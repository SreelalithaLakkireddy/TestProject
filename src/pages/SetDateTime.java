package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SetDateTime {
	
	WebDriver driver;

	By dateTime=By.xpath("//button[@title='DATE/TIME']//i");
	By historic=By.xpath("//*[@class='icon icon-historic']");
	By from=By.xpath("//*[text()='From']//following::div[1]");
	By leftfrombutton=By.xpath("//label[text()='From']//following::i[@class='fa fa-chevron-left'][1]");
	By fromMonth=By.xpath("//label[text()='From']//following::span[@class='month'][1]");
	By fromDay=By.xpath("//div[@data-date='2020-11-02T00:00:00Z']");
	By fromHours=By.xpath("//label[text()='To']//preceding::select[@name='hours'][1]");
	By fromMinutes=By.xpath("//label[text()='To']//preceding::select[@name='minutes'][1]");
	
	By to=By.xpath("//label[text()='To']//following::div[2]");
	By lefttobutton=By.xpath("//label[text()='To']//following::i[@class='fa fa-chevron-left'][1]");
	By toMonth=By.xpath("//label[text()='To']//following::span[@class='month'][1]");
	By toDay=By.xpath("//div[@data-date='2022-02-14T00:00:00Z']");
	By toHours=By.xpath("//label[text()='To']//following::select[@name='hours'][1]");
	By toMinutes=By.xpath("//label[text()='To']//following::select[@name='minutes'][1]");
	By submit=By.xpath("//label[text()='To']//following::button[text()='Submit']");
	
	public SetDateTime(WebDriver driver) {
		this.driver=driver;
	}
	
	public void setDate() {
		driver.findElement(dateTime).click();
		driver.findElement(historic).click();
		driver.findElement(from).click();
		String element=driver.findElement(fromMonth).getText();
		while(element!=("Nov 2020")) {
			String element2=driver.findElement(fromMonth).getText();
			System.out.println("element2"+element2);
			driver.findElement(leftfrombutton).click();
			if(element2.equals("Dec 2020")) {
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				System.out.println("if"+element);
				
				driver.findElement(fromDay).click();
				Select searchDropdownText=new Select(driver.findElement(fromHours));
				searchDropdownText.selectByValue("11");
				
				Select searchDropdownText2=new Select(driver.findElement(fromMinutes));
				searchDropdownText2.selectByValue("35");
				driver.findElement(fromHours).click();
				Assert.assertEquals(element2,"Dec 2020" );
				break;
			}
			
			
		}
		driver.findElement(to).click();
		String element3=driver.findElement(toMonth).getText();
		while(element3!=("Feb 2022")) {
			String element2=driver.findElement(toMonth).getText();
			System.out.println("element2"+element2);
			driver.findElement(lefttobutton).click();
			if(element2.equals("Mar 2022")) {
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				System.out.println("if"+element);
				
				driver.findElement(fromDay).click();
				Select searchDropdownText=new Select(driver.findElement(toHours));
				searchDropdownText.selectByValue("12");
				
				Select searchDropdownText2=new Select(driver.findElement(toMinutes));
				searchDropdownText2.selectByValue("35");

				break;
			}
			Assert.assertEquals(element2,"Feb 2022" );
		}
		
		driver.findElement(submit).click();
		
	}
	

}
