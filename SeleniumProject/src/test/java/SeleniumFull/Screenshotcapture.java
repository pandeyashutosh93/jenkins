package SeleniumFull;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshotcapture {

	public static void main(String[] args) throws IOException, InterruptedException {
		// Using TakesScreenshot capturing full page SS
		
		
		System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		 // Here we have typecasted the driver because driver is an instance of WebDriver and ts is
		 // instance of Takesscreenshot interface so we cannot directly assign driver variable to ts varaible
		 // If it would have ChromeDriver driver = new ChromeDriver(); then no need of Typecasting
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		Thread.sleep(3000);
//		File src = ts.getScreenshotAs(OutputType.FILE);
//		File dst = new File(".//Screenshot/SS.png");
//		
//		FileUtils.copyFile(src, dst);
		
		
		// Capturing Section/ portion of page
		driver.get("https://www.etmoney.com/");
		WebElement logo = driver.findElement(By.xpath("//*[@id=\"mainHeader\"]/div[1]/a/img"));
		
		File src = logo.getScreenshotAs(OutputType.FILE);
		Thread.sleep(3000);
		
		File dst = new File(".//Screenshot/SS.png");
		
		FileUtils.copyFile(src, dst);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
