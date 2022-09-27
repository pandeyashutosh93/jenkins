package com.coding.auto;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class AshotApi {
	
	// Third party jar used -->> ashot 1.5.4 ; hamcrest , gson

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\pashu\\Downloads\\Selenium\\chromedriver_win32\\chromedriver.exe");
	    WebDriver driver =  new ChromeDriver();
	    driver.manage().window().maximize();
	    //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get("https://opensource-demo.orangehrmlive.com/");
	    WebElement logo = driver.findElement(By.xpath("//div[@class ='orangehrm-login-branding']/img"));
	    
	    
	    
	   Screenshot logoimg =  new AShot().takeScreenshot(driver, logo); // Takes screenshot of the element logo
	   //To save the SS in file format, we'll get the image out of SS and provide the path to store file
	    //  logoimg.getImage(); will get the image from SS
	   // ImageIO.write -->> Capture the image from screenshot and store it in the provided path in png format.
	   ImageIO.write(logoimg.getImage(),"png",new File("C:\\Users\\pashu\\Downloads\\Applications\\SS\\orange.png"));
	   
File f = new File("C:\\Users\\pashu\\Downloads\\Applications\\SS\\orange.png");

if (f.exists()) {
	System.out.println("File Exist: test case passed");
}
	}

}
