import java.awt.RenderingHints.Key;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestingPage {
	
	
	@Test
	public void open_application() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/text-box");
		
		Thread.sleep(1000);		
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("admin@gmail.com");
		driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys("Boston");
		driver.findElement(By.xpath("//textarea[@id='permanentAddress']")).sendKeys("India");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");

		driver.findElement(By.xpath("//button[@id='submit']")).click();
		Thread.sleep(1000);
		driver.close();


		
	}

}
