package actionclassexample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropByExample {
	
	@Test
	public void test() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/drag_drop.html");
		
		WebElement sales_element = driver.findElement(By.xpath("//li[@id='credit1']/a"));
		WebElement drop_element = driver.findElement(By.xpath("//ol[@id=\"loan\"]/li"));
		
		
		Actions action = new Actions(driver);
		action.dragAndDrop(sales_element, drop_element).build().perform();
		//action.dragAndDropBy(sales_element, 172, 40).build().perform();

		
		String text_after = driver.findElement(By.xpath("//ol[@id='loan']/li")).getText();
		String text = sales_element.getText();
		
		if(text_after == text) {
			System.out.println("Program success");
		}
		else{
			System.out.println("Something is wrong");
		}
		
	
		driver.close();

		
	}

}
