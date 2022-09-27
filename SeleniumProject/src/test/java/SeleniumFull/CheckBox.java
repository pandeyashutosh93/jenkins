package SeleniumFull;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBox {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\pashu\\Downloads\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

		driver.get("https://itera-qa.azurewebsites.net/home/automation");
		List<WebElement> cbele = driver
				.findElements(By.xpath("//div[@class='form-check']//label//input[@type='checkbox']"));
		int cbsize = cbele.size();
		System.out.println(cbsize);
		System.out.println(cbele.get(0).getAttribute("id"));
		for (int i = 0; i < cbsize; i++) {

			if (cbele.get(i).getAttribute("id").contains("tuesday")
					|| cbele.get(i).getAttribute("id").contains("wednesday")) {
				cbele.get(i).click();
			}

		}

	}

}
