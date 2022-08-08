package dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dropdownExample {
	
	
	@Test
	public void drop_down() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		
		WebElement dropdown_all = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
		dropdown_all.click();
		
				
		Select select = new Select(dropdown_all);
		
		
		List<WebElement> all_options = select.getOptions();
		System.out.println("***************All the drop Down Values**************************");
		int size_dropdown = all_options.size();
		for(int i =0; i<size_dropdown; i++) {
			
			String text = all_options.get(i).getText();
			System.out.println("All the values from drop down : " + text);
		}
		
		
		//select.selectByIndex(3);
		//select.selectByValue("10");
		select.selectByVisibleText("Handmade");

		WebElement option = select.getFirstSelectedOption();
		String option_value = option.getText();
		System.out.println("Selected Option value is " + option_value);
		
		driver.close();
		
		
	}
}
