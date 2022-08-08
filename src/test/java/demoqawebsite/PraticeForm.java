package demoqawebsite;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PraticeForm {

	public WebDriver driver;

	@BeforeClass()
	public void browser_initialization() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@Test()
	public void test_form() throws InterruptedException {

		driver.findElement(By.id("firstName")).sendKeys("Anushka" + Keys.ENTER);
		driver.findElement(By.id("lastName")).sendKeys("Shetty" + Keys.ENTER);
		driver.findElement(By.id("userEmail")).sendKeys("s@gmail.com" + Keys.ENTER);

		
		
	}
	
	@Test
	public void test_radio() throws InterruptedException {
		System.out.println("************* Radio Button ***************");
		WebElement radio_button = driver
				.findElement(By.xpath("//div[@id=\"genterWrapper\"]/div[2]/div[2]/input[@value='Female']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", radio_button);
		Thread.sleep(1000);
		String value_Selected = radio_button.getAttribute("value");
		System.out.println("Selected value is : " + value_Selected);

		
	}
	
	@Test
	public void test_mobilenumber() {
		System.out.println("************* Mobile Number ***************");
		driver.findElement(By.xpath("//input[@id='userNumber']")).sendKeys("1234567890");
		//System.out.println("Mobile Number :" +driver.findElement(By.id("userNumber")).getText());

		
	}

	@Test
	public void test_calender() throws InterruptedException {

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
		//System.out.println("Month is : " + monthvalue_selected.getText());

		WebElement year_dropdown = driver.findElement(By.xpath("//select[@class=\"react-datepicker__year-select\"]"));
		year_dropdown.click();
		Select s1 = new Select(year_dropdown);
		s1.selectByVisibleText(year);
		WebElement yearvalue_selected = s1.getFirstSelectedOption();
		//System.out.println("Year is : " + yearvalue_selected.getText());

		Thread.sleep(1000);

		List<WebElement> ls = driver.findElements(By.xpath("//div[@class=\"react-datepicker__week\"]/div"));
		System.out.println("List " + ls.size());

		WebElement d = driver.findElement(By.xpath("//div[text()='" + date + "']"));
	    //System.out.println("Date is : " + d.getText());
		d.click();
		Thread.sleep(1000);
		
		String DOB_value = driver.findElement(By.id("dateOfBirthInput")).getAttribute("value");
		System.out.println("Date of birth selected is :" + DOB_value);

	}
	
	
	@Test
	public void test_subject() {
		
		driver.findElement(By.xpath("//div[@id='subjectsContainer']")).sendKeys("maths");
		
	}
	
	@Test
	public void test_hobbies() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", " ");
		driver.findElement(By.xpath("//input[@id='hobbies-checkbox-3']")).click();
		
	}

	@AfterClass
	public void after_class() {
		driver.close();

	}

}
