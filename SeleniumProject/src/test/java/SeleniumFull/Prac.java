package SeleniumFull;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Prac {

	public static void main(String[] args) {
		
	
			System.setProperty("webdriver.chrome.driver", ".//Drivers/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			
			driver.get("https://itera-qa.azurewebsites.net/home/automation");
			
			
			WebElement drpdwn = driver.findElement(By.xpath("//select[@class = 'custom-select']"));
			
			Select sc = new Select(drpdwn);
			
            // sc.selectByIndex(2);
            // sc.selectByVisibleText("Spain");
            // sc.selectByValue("2");
			
			List <WebElement> drplist = sc.getOptions();
			int size = drplist.size();
			
			for(int i = 0; i < size; i++) {
				
				if  (drplist.get(i).getText().equals("Spain")) {
					drplist.get(i).click();
				}
			}
			
			
	}
	}