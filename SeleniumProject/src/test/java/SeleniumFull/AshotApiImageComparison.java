package SeleniumFull;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class AshotApiImageComparison {

	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\pashu\\Downloads\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.etmoney.com/");

		// WebElement logo =
		// driver.findElement(By.xpath("//a[@class='brand-logo']/img"));

		BufferedImage expimg = ImageIO.read(new File("C:\\Users\\pashu\\Downloads\\Applications\\SS\\etmoney1.png"));
		AShot as = new AShot();
		WebDriverWait wb = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement logo = wb
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='brand-logo']/img")));

		Screenshot logoimg = as.takeScreenshot(driver, logo);
		BufferedImage actualimg = logoimg.getImage();
		ImageIO.write(actualimg, "png", new File("C:\\Users\\pashu\\Downloads\\Applications\\SS\\etmoney2.png"));

		ImageDiffer imgdiff = new ImageDiffer();
		ImageDiff imgd = imgdiff.makeDiff(expimg, actualimg);
		if (imgd.hasDiff() == true) {
			System.out.println("Our TestCase got failed");

		} else {
			System.out.println("Our TestCase got Passed");
		}
	}

}
