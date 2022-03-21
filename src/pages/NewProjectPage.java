package pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.Commons;

public class NewProjectPage {
	WebDriver driver;
	Commons commons=new Commons(driver);
	
	By projects=By.xpath("//span[@title='Projects']//preceding::i[@title='Projects']");
	By newprojects=By.xpath("//i[@title='Projects']//preceding::li[text()='New Project']");
	By newpr=By.xpath("////h1[text()='New Project']");
	By name=By.xpath("//input[@id='name']");
	By selectShareProject=By.xpath("//select[@id='share']");
	By createProjectButton=By.xpath("//input[@value='Create Project']");
	
	By goal=By.xpath("//h3[text()='Add Goal']");
	By creategoal=By.xpath("//span[text()='Create New Goal']");
	By selectAsset=By.xpath("//span[text()='Select Asset']");
	By search=By.xpath("//input[@id='asset' and @placeholder='Search']");
	By searchDropdown=By.xpath("//input[@id='asset' and @placeholder='Search']//following::select[1]");
	By submit=By.xpath("//div[@class='btn-group']//button[text()='Submit']");
	By selectMetric=By.xpath("//*[text()='Select Metric']//following::select[1]");
	By selectGoalType=By.xpath("//*[text()='Select Goal Type']//following::select[1]");
	By setThreshhold=By.xpath("//*[text()='Set Threshold']//following::input[1]");
	By addGoal=By.xpath("//*[@value='Add Goal']");
	
	//String projectName=commons.randomString();
	//System.out.println("projectName" +projectName);
	
	public NewProjectPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void createProject() {
		
		
		commons.customWait(projects,driver);
		Actions builder = new Actions(driver);
		builder.click(driver.findElement(projects)).build().perform();
		//driver.findElement(projects).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(newprojects));
		commons.customWait(newprojects,driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//driver.findElement(newprojects).click();
		//Actions builder = new Actions(driver);
		builder.click(driver.findElement(newprojects)).build().perform();
		//driver.findElement(newprojects).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(newpr));
		//driver.findElement(name).sendKeys(projectName);
		//System.out.println("projectName" +projectName);
		driver.findElement(name).sendKeys("Test101");
		
		Select selectShareProjectText=new Select(driver.findElement(selectShareProject));
		selectShareProjectText.selectByVisibleText("No");
		
	}

	public void addGoal() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(goal));
		driver.findElement(creategoal).click();
		
		commons.customWait(selectAsset,driver);
		driver.findElement(selectAsset).click();
		
		//js.executeScript("arguments[0].scrollIntoView();", driver.findElement(searchDropdown));
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(searchDropdown));
//		Select searchDropdownText=new Select(driver.findElement(searchDropdown));
//		searchDropdownText.selectByIndex(4);

		driver.findElement(submit).click();
		
		Select selectMetricText=new Select(driver.findElement(selectMetric));
		selectMetricText.selectByVisibleText("testName1");
		
		Select selectGoalTypeText=new Select(driver.findElement(selectGoalType));
		selectGoalTypeText.selectByVisibleText(">");
		
		driver.findElement(setThreshhold).sendKeys("10");
		driver.findElement(addGoal).click();
		
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(createProjectButton));
		driver.findElement(createProjectButton).click();
		
		String projectText=driver.findElement(By.xpath("//div[@class='page-header']")).getText();
		Assert.assertEquals(projectText, "New Project");
		
	}

}
