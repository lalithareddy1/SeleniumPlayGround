package checkboxexample;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxExample2 {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/checkbox");
		
		
		
		String element_collapsed = driver.findElement(By.xpath("//li[@class='rct-node rct-node-parent rct-node-collapsed']")).getAttribute("class");		

		driver.findElement(By.xpath("//div[@class=\"check-box-tree-wrapper\"]/div/ol/li[@class='rct-node rct-node-parent rct-node-collapsed']/span/button")).click();
	
		Thread.sleep(1000);
		
		List<WebElement> list_arrows = driver.findElements((By.xpath("//li[@class='rct-node rct-node-parent rct-node-collapsed']")));
		int length = list_arrows.size();
		System.out.println(length);
		
		
		System.out.println("***************************Desktop Checkbox*****************************************");
		//String desktop_text = driver.findElement(By.xpath("//div[@class=\"check-box-tree-wrapper\"]/div/ol/li[@class='rct-node rct-node-parent rct-node-expanded']/ol/li[1]")).getAttribute("class");
		String desktop_text = driver.findElement(By.xpath("//li[@class='rct-node rct-node-parent rct-node-expanded']/ol/li[1]")).getAttribute("class");
		System.out.println("Desktop text" + desktop_text);
		
		if(desktop_text.endsWith("rct-node-collapsed")) {
			System.out.println("*************** Inside Desktop ***************");			
			driver.findElement(By.xpath("//li[@class='rct-node rct-node-parent rct-node-expanded']/ol/li[1]/span/button")).click();
			driver.findElement(By.xpath("//label[@for='tree-node-notes']/span[1]")).click();
			driver.findElement(By.xpath("//label[@for='tree-node-commands']/span[1]")).click();

		}
		
		
		
		System.out.println("***************************Documents Checkbox*****************************************");

		String documents_text = driver.findElement(By.xpath("//li[@class='rct-node rct-node-parent rct-node-expanded']/ol/li[2]")).getAttribute("class");
		System.out.println("Documents text" + documents_text);
		
		if(documents_text.endsWith("rct-node-collapsed")) {
			System.out.println("************* Inside Documents **************");			
			driver.findElement(By.xpath("//li[@class='rct-node rct-node-parent rct-node-expanded']/ol/li[2]/span/button")).click();
			
			String workspace_text = driver.findElement(By.xpath("//li[@class='rct-node rct-node-parent rct-node-expanded']/ol/li[@class='rct-node rct-node-parent rct-node-expanded']/ol/li[1]")).getAttribute("class");
			System.out.println("workspacec_text" + workspace_text);
			if(workspace_text.endsWith("rct-node-collapsed")) {
				
				driver.findElement(By.xpath("//li[@class='rct-node rct-node-parent rct-node-expanded']/ol/li[2]/ol/li[1]/span/button")).click();
				driver.findElement(By.xpath("//label[@for='tree-node-react']/span[1]")).click();
				driver.findElement(By.xpath("//label[@for='tree-node-angular']/span[1]")).click();
				driver.findElement(By.xpath("//label[@for='tree-node-veu']/span[1]")).click();


			}
		}
		
			
			
			
		//	String office_text = driver.findElement(By.xpath("//li[@class=\"rct-node rct-node-parent rct-node-expanded\"]/ol/li[2]/ol/li[2]")).getAttribute("class");
			//System.out.println("office_text" + office_text);
			//if(office_text.endsWith("rct-node-collapsed")) {
				
		//		driver.findElement(By.xpath("//li[@class='rct-node rct-node-parent rct-node-expanded']/ol/li[2]/ol/li[2]/span/button")).click();
//				System.out.println("=============================================");
//				Thread.sleep(1000);
//				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
				//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='tree-node-public']/span[1]"))).click();
//				driver.findElement(By.xpath("//label[@for='tree-node-public']/span[1]")).click();
//				driver.findElement(By.xpath("//label[@for='tree-node-private']/span[1]")).click();
//				driver.findElement(By.xpath("//label[@for='tree-node-classified']/span[1]")).click();
//				driver.findElement(By.xpath("//label[@for='tree-node-general']/span[1]")).click();



//			}
		
		
		
		System.out.println("***************************Downloads Checkbox*****************************************");

		String downloads_text = driver.findElement(By.xpath("//li[@class='rct-node rct-node-parent rct-node-expanded']/ol/li[3]")).getAttribute("class");
		if(downloads_text.endsWith("rct-node-collapsed")) {
			System.out.println("************* Inside Downloads ***************");			
			driver.findElement(By.xpath("//li[@class='rct-node rct-node-parent rct-node-expanded']/ol/li[3]/span/button")).click();
			driver.findElement(By.xpath("//label[@for='tree-node-wordFile']/span[1]")).click();
			driver.findElement(By.xpath("//label[@for='tree-node-excelFile']/span[1]")).click();
		}
	
		
		driver.close();
		
		

	}

}

