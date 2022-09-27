package SeleniumFull;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardActions {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// using ActionsClass
//		driver.get("https://the-internet.herokuapp.com/key_presses");
//		driver.manage().window().maximize();
	     Actions ac = new Actions(driver);
//		
//		ac.sendKeys(Keys.ENTER).build().perform();
//		Thread.sleep(1000);
//		
//		ac.sendKeys(Keys.CONTROL).build().perform();;
//		Thread.sleep(1000);
//		
//		ac.sendKeys(Keys.TAB).build().perform();;
//		Thread.sleep(1000);
//		
//		ac.sendKeys(Keys.ALT).build().perform();;
//		Thread.sleep(1000);
		
		
		
		//Using Multiple key like CTRl+A, CTRL+V etc
		
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement box1 = driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[2]/div/textarea"));
		//WebElement box2 = driver.findElement(By.id("inputText2"));
		box1.sendKeys("My Name is Ashutosh");
		Thread.sleep(1000);
		ac.keyDown(Keys.CONTROL);
		ac.sendKeys("a");
		ac.keyUp(Keys.CONTROL);
		ac.perform();
		Thread.sleep(3000);
		
		ac.keyDown(Keys.CONTROL);
		ac.sendKeys("c");
		ac.keyUp(Keys.CONTROL);
		ac.perform();
		Thread.sleep(3000);
		
		ac.keyUp(Keys.TAB);
		ac.perform();
		Thread.sleep(3000);
		
		ac.keyDown(Keys.CONTROL);
		ac.sendKeys("v");
		ac.keyUp(Keys.CONTROL);
		ac.perform();
		
		
		


	}

}
