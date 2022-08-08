package takescreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotDemo {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		
		Date date = new Date();
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
	    String strDate= formatter.format(date); 
	    System.out.println(strDate);  
	    

	   String screenShotFolderPath = System.getProperty("user.dir")+"//screenshots//";
	   System.out.println(screenShotFolderPath);

	   File f = new File(screenShotFolderPath);
	   f.mkdirs();
	   
	   WebDriverManager.chromedriver().setup();
	   WebDriver driver = new ChromeDriver();
	   driver.get("https://www.amazon.com/");
	   
	   driver.manage().window().maximize();
	   
	   TakesScreenshot screenshot = (TakesScreenshot)driver;
	   File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
	   File desFile = new File(screenShotFolderPath + strDate+".png");
	   FileUtils.copyFile(srcFile, desFile);
		
	   driver.close();
	   
		

	}

}
