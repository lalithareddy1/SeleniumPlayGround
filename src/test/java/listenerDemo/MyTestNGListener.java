package listenerDemo;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class MyTestNGListener extends BaseClass implements ITestListener{
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Passed "+result.getName());
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test Failed :" + result.getMethod().getMethodName());
		Date d = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String date = formatter.format(d);		
		String screenshots_path = System.getProperty("user.dir") + "//screenshots";
		
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		File desFile = new File(screenshots_path + date + ".png");
		try {
			FileUtils.copyFile(srcFile, desFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.log("<a href='" + desFile.getAbsolutePath() + "'> <img src='" + desFile.getAbsolutePath() + "' height='100' width='100'/> </a>");

		
		
		
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}


}
