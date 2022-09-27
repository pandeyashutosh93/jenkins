package SeleniumFull;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import Utitlity.Utilities;

public class DropDown {

	

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pashu\\Downloads\\Selenium\\chromedriver_win32\\chromedriver.exe");
		 Map<String, Object> prefs = new HashMap<String, Object>();
		    
			//add key and value to map as follow to switch off browser notification
			//Pass the argument 1 to allow and 2 to block
			prefs.put("profile.default_content_setting_values.notifications", 2);
			    
			//Create an instance of ChromeOptions 
			ChromeOptions options = new ChromeOptions();
			    
			// set ExperimentalOption - prefs 
			options.setExperimentalOption("prefs", prefs);
			
		
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5000));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		//driver.get("https://testautomationpractice.blogspot.com/");
		//WebElement dds = driver.findElement(By.id("speed"));
		//Utilities us = new Utilities(driver);
		//us.selectDropDown(dds,"Fast");
		//us.selectDD(dds, "Medium");
		
		//st.selectByIndex(2);
		//st.selectByVisibleText()
		
		driver.get("https://www.hdfcbank.com/");
		
		
	    driver.findElement(By.xpath("//div[@class = 'drp1']//a")).click();
	 List <WebElement> dd =   driver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']/li"));
	    
	    Utilities us = new Utilities(driver);
	    us.selectBootstrapDD(dd, "Travel Insurance");
		
			 
		 }

	
	}


