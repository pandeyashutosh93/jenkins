package SeleniumFull;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class calenderPrac {

	public static void main(String[] args) {
System.setProperty("webdriver.chrome.driver", "C:\\Users\\pashu\\Downloads\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/main/div[9]/span")).click();
		String month= "November 2022";
        String date = "14";
        
        
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/label/span")).click();
        
        while(true) {
        	String mon = driver.findElement(By.xpath("(//div[@class='DayPicker-Caption']/div)[1]")).getText();
        if(mon.equals(month)) {
        	break;
        }
        else {
        	driver.findElement(By.xpath("(//span[contains(@class, 'DayPicker-NavButton DayPicker')])[2]")).click();
        }
        
        
        
        }
        
        
        List <WebElement> dates = driver.findElements(By.xpath("//div[@class='dateInnerCell']"));
        
        int dtsize = dates.size();
        
        for(int i =0 ; i < dtsize ; i++) {
        	
        	String dtvalue =  dates.get(i).getText();
        	String[] acdate = dtvalue.split("\n");
            System.out.println(acdate[0]);
        	
        	if(acdate[0].equals(date)) {
        		dates.get(i).click();
        		break;
        	}
        }
        
        
        
        
		    }

	}


