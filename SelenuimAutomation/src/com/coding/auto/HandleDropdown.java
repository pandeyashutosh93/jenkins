package com.coding.auto;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleDropdown {
	
	

	public static void main(String[] args) throws Exception {
System.setProperty("webdriver.chrome.driver","C:\\Users\\pashu\\Downloads\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
        WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/reg/?privacy_mutation_token=eyJ0eXBlIjowLCJjcmVhdGlvbl90aW1lIjoxNjU2MzA1MzcyLCJjYWxsc2l0ZV9pZCI6MzYzOTY5MDQ0ODc4OTI4fQ%3D%3D");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.findElement(By.id("u_0_0_nK")).click();
		WebElement day = driver.findElement(By.id("day"));
		WebElement month = driver.findElement(By.id("month"));
		WebElement year = driver.findElement(By.id("year"));
		
		selectDropDown(day , "14");
		selectDropDown(month , "Nov");
		selectDropDown(year , "1993");
		
	}
	//Generic Method for Multiple dropdown
		public static void selectDropDown(WebElement we, String value) {
			Select cls = new Select(we);
			cls.selectByVisibleText(value);
		}
		
}

