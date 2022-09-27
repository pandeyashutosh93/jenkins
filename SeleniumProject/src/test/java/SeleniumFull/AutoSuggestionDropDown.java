package SeleniumFull;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestionDropDown {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.bing.com/");
		driver.findElement(By.id("sb_form_q")).sendKeys("selenium");
		List <WebElement> list = driver.findElements(By.xpath("//li[@class='sa_sg']//span"));
		for(WebElement lst : list) {
			
			if(lst.getText().equals("selenium webdriver")) {
				lst.click();
				break;
			}
		}
	}
}
