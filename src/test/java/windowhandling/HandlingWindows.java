package windowhandling;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverInfo;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingWindows {
	
	WebDriver driver;
	
	@BeforeTest
	public void open() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	
	@Test
	public void test() {
		driver.get("https://demo.automationtesting.in/Windows.html");
		String parent_windowTitle = driver.getTitle();
		System.out.println("Parent Window " + parent_windowTitle);
		
		WebElement click_button = driver.findElement(By.xpath("//div[@id='Tabbed']/a/button"));
		click_button.click();
//		JavascriptExecutor js = ((JavascriptExecutor)driver);
//		js.executeScript("arguments[0].click", click_button);
//		
		Set<String> s = driver.getWindowHandles();
		
		for(String i :s) {
			System.out.println(i);
			String title = driver.switchTo().window(i).getTitle();
			System.out.println(title);
			if(title.contains("Frames & windows")) {
				driver.close();
			}
			if(title.contains("Selenium")) {
				
			}
		}
		
		driver.close();
		
	}

}
