import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		WebElement e1 = driver.findElement(By.cssSelector("input.gLFyf.gsfi"));

		
		WebElement e = driver.findElement(By.xpath("//input[@class=\"gLFyf gsfi\"]"));
		e.sendKeys("James Bond movies"+ Keys.ENTER);
		
		Thread.sleep(1000);
		
		driver.close();
	}

}
