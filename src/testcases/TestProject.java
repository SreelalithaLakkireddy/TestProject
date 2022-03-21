package testcases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import pages.CreateDashboardPage;
import pages.DashboardPage;
import pages.NewProjectPage;
import pages.SetDateTime;
import pages.SignInPage;


public class TestProject {
	
	String driverPath = "C:\\Softwares\\chromedriver.exe";
	WebDriver driver;
	
	SignInPage signinPage;
	DashboardPage dashboardPage;
	CreateDashboardPage createDashboardPage;
	NewProjectPage newProjectPage;
	SetDateTime setDateTime;
	
	@BeforeTest (description="Open URL on browser")
	@Description("Test Description: Test URL open in browser")
	@Step("Verify URL open..")
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get("https://reference-test.intellisense.io/ ");
		
		System.out.println("URL opened");	
	}
	
	@Test(priority=0, description="Login to application")
	@Description("Test Description: Login test with username and  password application")
	@Step("Verify SignIn..")
	public void enter_SiginDetails() {
	
		signinPage=new SignInPage(driver);
		signinPage.SignIn("menna+testproject@intellisense.io","AutMaNewTest1#");
		System.out.println("SignIn success");
	}
	
	@Test(priority=1,description="Create New Dashboard ")
	@Description("Test Description: Create New Dashboard and add widget")
	@Step("Verify New Dashboard and widget..")
	public void create_new_dashboard() {
		
		createDashboardPage=new CreateDashboardPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		createDashboardPage.createDashboard();
		System.out.println("New Dashboard created Succesfully ");
		createDashboardPage.addWidget();
		System.out.println("Add to Dashboard is success");
		
	}
	
	@Test(priority=2,description="Dashboard Operations")
	@Description("Test Description: Open Test Project and perform some operations")
	@Step("Verify Dashboard Operations..")
	public void dashboard_tabs() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		dashboardPage=new DashboardPage(driver);
		dashboardPage.dashboardTabsOperations();
		System.out.println("Dashboard operations are Success");
		
	}
	
	@Test(priority=3,description="Set DATE and TIME  ")
	@Description("Test Description: Add DATE and TIME to home page")
	@Step("Verify DATE/TIME..")
	public void set_date_time() {
		
		setDateTime=new SetDateTime(driver);
		setDateTime.setDate();
		System.out.println("Set up DATE/TIME Success");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	
	@Test(priority=4,description="Create New Project ")
	@Description("Test Description: Create New Project and add Goal")
	@Step("Verify New Dashboard and Goal..")
	public void create_new_project() {
		
		newProjectPage=new NewProjectPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		newProjectPage.createProject();
		System.out.println("Project created successfully");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		newProjectPage.addGoal();
		System.out.println("Goal added succesfully");
	}
	
}
