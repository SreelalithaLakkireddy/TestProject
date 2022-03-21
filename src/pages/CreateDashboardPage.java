package pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import utils.Commons;

public class CreateDashboardPage {
	
	WebDriver driver;
	Commons commons=new Commons(driver);
	
	By dashboards=By.xpath("//span[@title='Dashboards']//preceding::i[@title='Dashboards']");
	By newdashboard=By.xpath("//i[@title='Dashboards']//preceding::li[text()='New Dashboard']");
	By name=By.xpath("//input[@id='name']");
	By submit=By.xpath("//input[@value='Submit']");
	
	By addWidget=By.xpath("//div[@class='page-header']//li[@title='Add Widget']");
	By selectWidgetType=By.xpath("//*[text()='Bar']");
	By addTitle=By.xpath(" //label[text()='Title']//following::input[1]");
	By significantFigures=By.xpath("//*[@id='sigFigs']");
	By decimalPlaces=By.xpath("//*[@id='decimalPlaces']");
	By valueType=By.xpath("//*[@id='valueType']");
	By sort=By.xpath("//*[text()='Sort']//following-sibling::select");
	By selectSize=By.xpath("//*[text()='Select Size']//following::div[2]//img");
	
	By slots=By.xpath("//h2[text()='Slots']");
	By selectAssets=By.xpath("//*[text()='Assets']//following::select[1]");
	By selectMetric=By.xpath("//div[@title='FEED_MESH']");
	
	By slotOptions=By.xpath("//*[text()='Slot Options']//following::select[1]");
	By asset=By.xpath("//*[text()='Asset']//following::input[1]");
	By metric=By.xpath("//*[text()='Metric']//following::input[1]");
	By slotName=By.xpath("//*[text()='Name']//following::input[2]");
	By update=By.xpath("//*[text()='Name']//following::button[text()='Update']");
	
	By add_to_dashboard=By.xpath("//div[@class='text-right']//div[@class='btn-group']//button[2]");
	By dashboardData=By.xpath("//h1[@class='title']");
	By widgetData=By.xpath("//h4[text()=' Test1001 ']");
	By newDashboard=By.xpath("//h1[text()='New Dashboard']");
	
	public CreateDashboardPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void createDashboard() {
		
		commons.customWait(dashboards,driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.findElement(dashboards).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		commons.customWait(newdashboard,driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		commons.clickAction(newdashboard,driver);
		//driver.findElement(newdashboard).click();
		
		String dashboardName=commons.randomString();
		System.out.println("dashboardName"+dashboardName);
		commons.customWait(newDashboard,driver);
		driver.findElement(name).sendKeys(dashboardName);
		driver.findElement(submit).click();
		
		commons.customWait(dashboardData,driver);
		String dashboardText=driver.findElement(dashboardData).getText();
		System.out.println("dashboardText"+dashboardText);
		
		Assert.assertEquals(dashboardText, dashboardName);
	}
	
	public void addWidget() {
		
		commons.customWait(addWidget,driver);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(addWidget).click();
		driver.findElement(selectWidgetType).click();
		
		commons.customWait(addTitle,driver);
		
		String widgetName=commons.randomString();
		System.out.println("widgetName"+widgetName);
		
		driver.findElement(addTitle).sendKeys(widgetName);
		
		Select significantFiguresText=new Select(driver.findElement(significantFigures));
		significantFiguresText.selectByVisibleText("2");
		
		Select decimalPlacesText=new Select(driver.findElement(decimalPlaces));
		decimalPlacesText.selectByVisibleText("2");
		
		Select valueTypeText=new Select(driver.findElement(valueType));
		valueTypeText.selectByVisibleText("Latest Value");
		
		Select sortText=new Select(driver.findElement(sort));
		sortText.selectByVisibleText("Sort Ascending");
		
		driver.findElement(selectSize).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(slots));
		
		Select assetsText=new Select(driver.findElement(selectAssets));
		assetsText.selectByIndex(4);
		
		driver.findElement(selectMetric).click();
		
		Select slotOptionsText=new Select(driver.findElement(slotOptions));
		slotOptionsText.selectByVisibleText("Asset Metric Slot");
		
		driver.findElement(asset).click();
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(metric));
		driver.findElement(metric).click();
		System.out.println("metric JS is success");

		driver.findElement(slotName).click();
		driver.findElement(update).click();
		
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(add_to_dashboard).click();	
		
	}	

}
