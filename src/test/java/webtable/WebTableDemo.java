package webtable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableDemo {
	
	@Test
	public void test_table() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://cosmocode.io/automation-practice-webtable/");
		
		String country_name = "India";
		
		List<WebElement> countries = driver.findElements(By.xpath("//table[@id='countries']/tbody/tr/td[2]"));
		int len_countries = countries.size();
		
		System.out.println(len_countries);
		
		for(int i=0; i<len_countries; i++) {
			System.out.println(countries.get(i).getText());
			if(country_name.equals(countries.get(i).getText())) {				
				System.out.println("Country Name matched");
				break;
			}
			
		}
		
		driver.close();
		
	}

}
