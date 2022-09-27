package SeleniumFull;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HeadlessTesting {

	public static void main(String[] args) {
		// Setting the Driver path
		System.setProperty("webdriver.chrome.driver", ".//Drivers/chromedriver.exe");
		
		//Using ChromeOptions class
		ChromeOptions option = new ChromeOptions();
		
		//Using FirefoxOPtions class
		//FirefoxOptions option1 = new FirefoxOptions();
		

		// Setting Chrome browser as Headless- There are two methods
	//	option.setHeadless(true); //Method1
	option.addArguments("--headless");  //Method2
		
		
		//we will give the option reference variable as an parameter in chrome driver, see below
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		String pgtitle = driver.getTitle();
		assertEquals("OrangeHRM" , pgtitle);
	    System.out.println(pgtitle);

		
		
		
		//Using HTMLUnit driver
		
//		HtmlUnitDriver driver = new HtmlUnitDriver();
//		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//		String pgtitle = driver.getTitle();
//		System.out.println(pgtitle);

	}

}
