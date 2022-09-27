package com.coding.auto;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrokenLinks {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\pashu\\Downloads\\Selenium\\chromedriver_win32\\chromedriver.exe");
	    WebDriver driver =  new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    
	   
	    driver.findElement(By.name("username")).clear();  
	 driver.findElement(By.name("username")).sendKeys("Admin");
	 driver.findElement(By.name("password")).clear();
     driver.findElement(By.name("password")).sendKeys("admin123");

	 driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
	    
	 
	 // Capture all the element having anchor tag(used to create hyperlink in page)
        List<WebElement> link = driver.findElements(By.tagName("a"));
     
        // Capture Size of links
        int size = link.size();
        System.out.println(link.size());
        
        
        for(int i = 0; i < size; i++) {
        	try{
        	// Capturing URL of the link by href attribute
        	String url = link.get(i).getAttribute("href");
        	
        	//creating url link object
        	URL linkurl = new URL(url);
        	
        	
        	// HttpURLConnection checks whether particular kink is connecting to target page or not
        	// Connecting a connection using above url object 
        	HttpURLConnection huc = (HttpURLConnection)linkurl.openConnection();
        	
        	// wait time 
        	huc.setConnectTimeout(5000);
        	
        	// Establishing connection
        	huc.connect();
        	
        	// capturing the response code
        	if(huc.getResponseCode()>= 400) {
        		System.err.println(url + " - " + "is broken link");
        	}
        	else {
        	System.out.println(url + " - " + "is not broken link");

        	}
        	
        	 huc.disconnect();
        	}
        	catch(Exception e) {
        		e.printStackTrace();
        	}
        	}
        	driver.quit();
        }
	 
     
	}


