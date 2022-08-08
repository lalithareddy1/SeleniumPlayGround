package actionclassexample;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClickExample {
	
	
public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		
		
		Actions action = new Actions(driver);
		WebElement rightclickButton =driver.findElement(By.xpath("//span[text()='right click me']"));
		action.contextClick(rightclickButton).build().perform();
		
		WebElement copy = driver.findElement(By.cssSelector(".context-menu-icon-copy"));
		String text = copy.getText();
		System.out.println(text);
		copy.click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		
		driver.close();
	
		
	}

}
