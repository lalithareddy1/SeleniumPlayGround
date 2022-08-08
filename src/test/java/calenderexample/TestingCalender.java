package calenderexample;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestingCalender {
	
	
	@Test
	public void testing_calender() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/automation-practice-form");
		
		Thread.sleep(1000);
		
/*		WebElement datefield = driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));
		String MonthYearValue = datefield.getAttribute("value");
		System.out.println(MonthYearValue);
		*/
		// //div[@class="react-datepicker__header"]
		
		driver.findElement(By.xpath("//input[@id='dateOfBirthInput']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@id='dateOfBirthInput']")));

		
		WebElement datefield = driver.findElement(By.xpath("//div[@class=\"react-datepicker__header\"]/div[1]"));
		String MonthYearValueDisplayed = datefield.getText();
		System.out.println(" ---------------- " +MonthYearValueDisplayed);
		
		String monthDisplayed = MonthYearValueDisplayed.split(" ")[0];
		String yearDisplayed = MonthYearValueDisplayed.split(" ")[1];
		
		String yearToBeDisplayed = "2025";
		String MonthToBeDisplayed = "August";
		String dateToBeDisplayed = "19";
		
		int yearDisplayedInt = Integer.parseInt(yearDisplayed);
		int yearToBeDisplayedInt = Integer.parseInt(yearDisplayed);
		
		
		
		WebElement previous_button = driver.findElement(By.xpath("//button[text()='Previous Month']"));
		WebElement next_button = driver.findElement(By.xpath("//button[text()='Next Month']"));
		
		while(!(monthDisplayed.equals(MonthToBeDisplayed) && yearDisplayed.equals(yearToBeDisplayed))) {
			
			if(yearToBeDisplayedInt < yearDisplayedInt) {
				previous_button.click();				
				
			
			}
			else {
				next_button.click();
			}
			
			datefield = driver.findElement(By.xpath("//div[@class=\"react-datepicker__header\"]/div[1]"));
			MonthYearValueDisplayed = datefield.getText();
			monthDisplayed = MonthYearValueDisplayed.split(" ")[0];
			yearDisplayed = MonthYearValueDisplayed.split(" ")[1];
			System.out.println(" -------Inside While Loop--------- " +MonthYearValueDisplayed);

			
			
		}
		WebElement date =   driver.findElement(By.xpath("//div[text()='"+dateToBeDisplayed+"']"));
		System.out.println("DATE" + date.getText());
		date.click();
		
		driver.close();


		
	}


}
