package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.Commons;

public class DashboardPage {
	
	WebDriver driver;
	Commons commons=new Commons(driver);
	
	By singular=By.xpath("//span[text()='Singular']");
	By interval=By.xpath("//span[text()='Interval']");
	By constant=By.xpath("//span[text()='Constant']");
	By dashboards=By.xpath("//span[@title='Dashboards']//preceding::i[@title='Dashboards']");
	By project=By.xpath("//i[@title='Dashboards']//preceding::li[text()='Test Project']");
	By add=By.xpath("//tbody/tr[1]//td[6]//div//*[name()='svg']/*");
	By startDate=By.xpath("//label[text()='Start Date']");
	By year=By.xpath("//*[text()='2022']");
	By setPastYear=By.xpath("//*[text()='2020']");
	By setOk=By.xpath("//*[text()='OK']");
	By value=By.xpath("//input[@id='value']");
	By submit=By.xpath("//span[text()='Submit']");
	By dashboardData=By.xpath("//h1[@class='title']");
	
	public DashboardPage(WebDriver driver) {
		this.driver=driver;
	
	}
	
	public void dashboardTabsOperations() {

		commons.customWait(dashboards,driver);
		driver.findElement(dashboards).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(project));
		commons.customWait(project,driver);
		driver.findElement(project).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		commons.customWait(singular,driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.findElement(singular).click();
		commons.clickAction(add,driver);
		commons.clickAction(startDate,driver);
		driver.findElement(year).click();
		driver.findElement(setPastYear).click();
		driver.findElement(setOk).click();
		driver.findElement(value).sendKeys("10");
		driver.findElement(submit).click();
		driver.findElement(interval).click();
		driver.findElement(constant).click();
		
		String dashboardText=driver.findElement(dashboardData).getText();
		System.out.println("dashboardText"+dashboardText);
		Assert.assertEquals(dashboardText, "Test Project");
		
	}

}
