package actionclassexample;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomeDepotExample {
	
	
	@Test
	public void test_application() throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.homedepot.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Actions action = new Actions(driver);

		
		WebElement allDepartments = driver.findElement(By.xpath("//a[text()='All Departments']"));
		WebElement appliance = driver.findElement(By.xpath("//a[text()='Appliances']"));
		
		action.moveToElement(allDepartments).build().perform();
		Thread.sleep(1000);
		action.moveToElement(appliance).build().perform();
		Thread.sleep(1000);
		WebElement washer = driver.findElement(By.xpath("//a[@title='Washers & Dryers']"));

		action.moveToElement(washer).click().build().perform();
		Thread.sleep(1000);

		//action.moveToElement(particularFirdge).click().build().perform();
		
		driver.close();
		
		

	}

}
