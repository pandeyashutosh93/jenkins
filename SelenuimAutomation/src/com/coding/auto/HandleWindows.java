package com.coding.auto;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWindows {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\pashu\\Downloads\\Selenium\\chromedriver_win32\\chromedriver.exe");
	    WebDriver driver =  new ChromeDriver();
	    driver.get("http://demo.automationtesting.in/Windows.html");
	    
	    driver.manage().window().maximize();
	    driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[1]/a")).click();
	    String parentwindow = driver.getWindowHandle();
	    driver.findElement(By.xpath("//*[@id='Tabbed']/a/button")).click();
	    

	    Set <String> handles = driver.getWindowHandles();
	   
	    
	    
	    for(String handle :handles) {
	    	if(!handle.equals(parentwindow)) {
	    		driver.switchTo().window(handle);
	    		driver.findElement(By.xpath("/html/body/div/main/section[2]/div/div/div[2]/div/div[2]/div/a")).click();
	    		
	    		driver.close();
	    	}
	    	
	    }
	    driver.switchTo().window(parentwindow);
	    Thread.sleep(5000);
	    System.out.println("Switched to parent window");
	    driver.findElement(By.xpath("//*[@id='header']/nav/div/div[2]/ul/li[1]/a")).click();

	}

}
