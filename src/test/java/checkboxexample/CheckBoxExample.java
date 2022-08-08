package checkboxexample;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxExample {
	
	public static void main(String args[]) {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://selenium08.blogspot.com/2019/07/check-box-and-radio-buttons.html");
		driver.manage().window().maximize();
		
		
	/*	WebElement red = driver.findElement(By.xpath("//input[@value='red']"));
		red.click();
		System.out.println(red.isSelected());

		
		WebElement orange = driver.findElement(By.xpath("//input[@value='Orange']"));
		orange.click();
		*/
		
		List<WebElement> checkbox = driver.findElements(By.xpath("//div[@id='post-body-7702345506409447484']/div/input"));
		int len = checkbox.size();			
		for(int i = 0; i<len; i++) {
			checkbox.get(i).click();
			String value = checkbox.get(i).getAttribute("value");
			System.out.println("Values Selected are : " + value);
			
		}
		driver.close();
		
		
	}

}
