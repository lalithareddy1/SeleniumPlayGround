package listenerDemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Application extends BaseClass{
	public SoftAssert softassert;
	
	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://portfolio.rediff.com/portfolio-login");
		driver.manage().window().maximize();
		
	}
	
	@Test(priority = 1)
	public void login_test() throws InterruptedException {
		driver.findElement(By.id("useremail")).sendKeys("lalitha517.sudireddy@gmail.com");
		driver.findElement(By.id("userpass")).sendKeys("Frenchstreet");
		driver.findElement(By.id("loginsubmit")).click();
		Thread.sleep(1000);

		String title = driver.getTitle();
		System.out.println("Title of the page is :" + title);
		
		//softassert.assertTrue(driver.getTitle().contains("OrangeHRM"));;

	}
	
	@Test(priority = 2)
	public void adminpanel_test() throws InterruptedException {
	
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
	
}
