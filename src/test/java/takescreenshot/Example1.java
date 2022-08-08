package takescreenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Example1 {
	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver  = new ChromeDriver();
		
		System.out.println(System.getProperty("user.dir"));
		String current_dir = System.getProperty("user.dir");
		
		String fileName = current_dir+"//screenshot.png";
		driver.manage().window().maximize();
		
		
		driver.get("https://www.amazon.com/");
		Thread.sleep(1000);
		
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		File desFile = new File(fileName);
		
		FileUtils.copyFile(srcFile, desFile);
		driver.close();
		
		
		
		
	}

}
