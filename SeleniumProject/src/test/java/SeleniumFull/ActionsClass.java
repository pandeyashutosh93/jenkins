package SeleniumFull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClass {

	public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", ".//Drivers/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();

   // Mouse Hovering
// driver.get("https://parivahan.gov.in/parivahan/");
// WebElement is =	driver.findElement(By.xpath("//*[@id='tb-megamenu-main-menu']/div/ul/li[3]/a"));
// WebElement ts =	driver.findElement(By.xpath("//*[@id='tb-megamenu-column-6']/div/ul/li[3]/a"));
// WebElement cs = driver.findElement(By.xpath("//*[@id=\"tb-megamenu-column-2\"]/div/ul/li[1]/a"));
// Actions act = new Actions(driver);
// act.moveToElement(is).moveToElement(ts).moveToElement(cs).click().build().perform();
	
	// Drag and Drop
//	driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
//	WebElement src =driver.findElement(By.xpath("//*[@id='box2']"));
//	WebElement trgt =driver.findElement(By.xpath("//*[@id='box106']"));
//	Actions act = new Actions(driver);
//	//act.dragAndDrop(src, trgt).build().perform();  Method1
//	act.clickAndHold(src).moveToElement(trgt).release().build().perform();  //Method2
	
	//Mouse Right click
//	act.contextClick(trgt).build().perform();
	
	// Slider
	driver.get("https://jqueryui.com/slider/");
	Thread.sleep(5000);
	driver.switchTo().frame(0);
	WebElement ele =driver.findElement(By.xpath("//*[@id='slider']/span"));
	Actions act = new Actions(driver);
	//act.moveToElement(ele).clickAndHold().dragAndDropBy(ele,200, 0).release().build().perform();  //Method3
	//act.moveToElement(ele).dragAndDropBy(ele,200, 0).release().build().perform(); //Method 2
	//act.dragAndDropBy(ele,200, 0).release().perform();  Method 1
	
//	// Resizable
//	driver.get("https://jqueryui.com/resizable/");
//	driver.switchTo().frame(0);
//	WebElement ele = driver.findElement(By.xpath("//*[@id=\"resizable\"]/div[3]"));
//	Actions act = new Actions(driver);
//	act.dragAndDropBy(ele, 80 , 80).build().perform();
	
	}

}
