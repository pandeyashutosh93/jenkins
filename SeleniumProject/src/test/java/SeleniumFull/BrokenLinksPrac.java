package SeleniumFull;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrokenLinksPrac {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pashu\\Downloads\\Selenium\\chromedriver_win32\\chromedriver.exe");
		   
		WebDriver driver = null;
		        
		        String homePage = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		        String url = "";
		        HttpURLConnection huc = null;
		        int respCode = 200;
		        
		        driver = new ChromeDriver();
		        
		        driver.manage().window().maximize();
		        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		        
		        driver.get(homePage);
		        
		        List<WebElement> links = driver.findElements(By.tagName("a"));
		        
		        for(int i =0; i < links.size(); i++) {
		        	
		         url =	links.get(i).getAttribute("href");

		         System.out.println(url);
		        
		            if(url == null || url.isEmpty()){
		System.out.println("URL is either not configured for anchor tag or it is empty");
		                continue;
		            }
		            
		            if(!url.startsWith(homePage)){
		                System.out.println("URL belongs to another domain, skipping it.");
		                continue;
		            }
		            
		            try {
		                huc = (HttpURLConnection)(new URL(url).openConnection());
		                
		                huc.setRequestMethod("HEAD");
		                
		                huc.connect();
		                
		                respCode = huc.getResponseCode();
		                
		                if(respCode >= 400){
		                    System.out.println(url+" is a broken link");
		                }
		                else{
		                    System.out.println(url+" is a valid link");
		                }
		                    
		            } catch (MalformedURLException e) {
		               
		                e.printStackTrace();
		            } catch (IOException e) {
		                
		                e.printStackTrace();
		            }
		        }
		            driver.quit();
		        }
		        
		        

		    }


