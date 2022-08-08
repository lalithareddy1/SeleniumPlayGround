package frames;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Paytm {
	WebDriver driver = null;
	
	@Test
	public void paytm() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://paytm.com");
		Thread.sleep(5000);
		waitForPageToLoad();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='app']/div/div[2]/div[2]/div[3]/div[3]/div/div/div")));
		driver.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/div[3]/div[3]/div/div/div")).click();
		//clickAndWait(xpathToCliCked, xpathAppear);
		
		
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		System.out.println("Total number of frames are "+ frames.size());
		
		for(int i=0;i<frames.size();i++) {
			// switch to ith frame
			driver.switchTo().frame(i);
			// check the presence of element, if present then  break
			int s = driver.findElements(By.xpath("//*[@id='main-container']/div/div/div/div/div[2]/qr-code-login/div/div[2]/div")).size();
			if(s==0)
				driver.switchTo().defaultContent();
			else
				break;
		}
		//driver.switchTo().frame(0);
		
		String text = driver.findElement(By.xpath("//*[@id='main-container']/div/div/div/div/div[2]/qr-code-login/div/div[2]/div")).getText();
		System.out.println(text);
		
		driver.switchTo().defaultContent();// main window
	}
	
	public void waitForPageToLoad() throws InterruptedException{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		int i=0;
		// page to load 100% -- wait for max 20 secs
		while(i!=10){
			String state = (String)js.executeScript("return document.readyState;");
			System.out.println(state);// complete, loading, interactive
	
			if(state.equals("complete"))
				break;
			else
				Thread.sleep(2000);
	
			i++;
		}
		
	}
	// try to click 5 times
	public void clickAndWait(String xpathToClicked, String xpathAppear) {
		// click - xpathToClicked
		// wait - presence and visiblity of xpathAppear
		// if not visible - 2 secs
		
		// throw failure - if after 5 clicks the element is not appearing
	}


}
