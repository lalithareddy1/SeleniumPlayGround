import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FergusonExample {
	
	
	@Test
	public void open_application() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.ferguson.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("water softener");
		driver.findElement(By.xpath("//fieldset[@class=\'show-dropdown\']/child::a")).click();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//String num = driver.findElement(By.xpath("//input[@id='totalNumRecs']")).getAttribute("value");
		//System.out.println("Number of search Displayed " + num);

		
		String num = driver.findElement(By.xpath("//input[@id='totalNumRecs']")).getText();
		System.out.println("================="+num);
		
		driver.close();


		
	}

}
