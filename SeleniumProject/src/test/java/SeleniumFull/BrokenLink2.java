package SeleniumFull;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration; 
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLink2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\pashu\\Downloads\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.get("http://www.jadeblue.com");
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		//Collect all links in web page
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		//getting link Size
		int linksize = links.size();
		System.out.println("The total links are:-" + linksize);
			for (int i = 0; i < linksize; i++) {
                //getting the url
				String url = links.get(i).getAttribute("href");
				try {
				geturl(url);
				}
				
				catch(Exception e) {
				}
				}
				
				}
				
			

	




  public static void geturl (String hurl) {
	  try {
			URL linkurl = new URL(hurl);
			//Send http request:
			//HttpURLConnection class has methods to send HTTP request and capture HTTP response code. 
			//So, output of openConnection() method (URLConnection) is type casted to HttpURLConnection.
			
			HttpURLConnection huc = (HttpURLConnection) linkurl.openConnection();
			
			//We can set Request type as “HEAD” instead of “GET”. 
			//So that only headers are returned and not document body.
			 huc.setRequestMethod("HEAD");
			//Thread.sleep(5000);
			 
//On invoking connect() method, actual connection to url is established and the request is sent.
			huc.connect();
// Validating the links
			if (huc.getResponseCode() >= 400) {
				System.out.println(huc.getURL() + " = " + huc.getResponseMessage());
			} 
			else {
				System.err.println(huc.getURL() + " = " + huc.getResponseMessage());
			}
		
	}

	catch (Exception e) {
		e.printStackTrace();

	}
	  
  }
}

