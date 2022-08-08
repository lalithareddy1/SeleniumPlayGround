package calenderexample;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderDemo {
	

	public WebDriver driver;

	@BeforeTest()
	public void browser_initialization() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@Test
	public void test_form() throws InterruptedException {		 
		WebElement cal = driver.findElement(By.id("dateOfBirthInput"));
		cal.click();
		String month = "August";
		String year = "1993";
		String date = "28";
		Thread.sleep(1000);

		WebElement month_dropdown = driver.findElement(By.xpath("//select[@class=\"react-datepicker__month-select\"]"));
		month_dropdown.click();
		Select s = new Select(month_dropdown);
		s.selectByVisibleText(month);
		WebElement monthvalue_selected = s.getFirstSelectedOption();
		System.out.println("Month is : " + monthvalue_selected.getText());

		WebElement year_dropdown = driver.findElement(By.xpath("//select[@class=\"react-datepicker__year-select\"]"));
		year_dropdown.click();
		Select s1 = new Select(year_dropdown);
		s1.selectByVisibleText(year);
		WebElement yearvalue_selected = s1.getFirstSelectedOption();
		System.out.println("Year is : " + yearvalue_selected.getText());

		Thread.sleep(1000);

		List<WebElement> ls = driver.findElements(By.xpath("//div[@class=\"react-datepicker__week\"]/div"));
		System.out.println("List " + ls.size());

		WebElement d = driver.findElement(By.xpath("//div[text()='" + date + "']"));
		System.out.println("Date is : " + d.getText());
		d.click();
		Thread.sleep(1000);

		driver.close();

	}


}
