package SeleniumFull;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class UploadFiles {

	public static void main(String[] args) throws AWTException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.monsterindia.com/");
		driver.findElement(By.xpath("//a[contains(@class,'btn block resume')]")).click();

		// Using SendKeys Method
		// Note: This method only works when the html attribute "type" = file.
		// driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\pashu\\Downloads\\Selenium\\Automation
		// Certificates\\sample.pdf");

		// Using Robot class

		WebElement button = driver.findElement(By.id("file-upload"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", button);

		StringSelection sc = new StringSelection(
				"C:\\Users\\pashu\\Downloads\\Selenium\\Automation Certificates\\sample.pdf");

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sc, null);

		Robot rb = new Robot();
		rb.delay(2000);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.delay(2000);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.delay(2000);
		rb.keyPress(KeyEvent.VK_ENTER);

//	Actions act = new Actions(driver);
//	
//	act.keyDown(Keys.CONTROL);
//	Thread.sleep(2000);
//	act.sendKeys("v");
//	Thread.sleep(2000);
//	act.keyUp(Keys.CONTROL);
//	Thread.sleep(2000);
//	act.perform();
//	
//	
//	act.keyDown(Keys.ENTER);

	}

}
