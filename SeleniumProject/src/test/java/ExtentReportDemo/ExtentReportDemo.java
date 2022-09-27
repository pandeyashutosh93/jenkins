package ExtentReportDemo;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportDemo {
	public WebDriver driver;

	public ExtentHtmlReporter htmlreporter; // ExtentHtmlReporter class is rsponsible for look and feel of the reports,
											// means we can specify the Reportname, Document title, Theme of the report,
											// etc

	public ExtentReports exreport; // It is used to create entries in the report and Additional info can be added
									// like who executed test cases, OS name, browser name etc.
	public ExtentTest etest; // this class is used to update the status in the report, update the logs etc.

	@BeforeClass
	public void extentReportSetUp() {
		htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/MyReports.html");
		htmlreporter.config().setDocumentTitle("OrangeHRM");
		htmlreporter.config().setReportName("Functional Testing");
		htmlreporter.config().setTheme(Theme.DARK);

		exreport = new ExtentReports();
		exreport.attachReporter(htmlreporter);

		exreport.setSystemInfo("HostName", "LocalHost");
		exreport.setSystemInfo("OS", "Windows11");
		exreport.setSystemInfo("TesterName", "Ashutosh");
		exreport.setSystemInfo("Browser", "ChromeBrowser");

	}

	@AfterTest
	public void tearDown() {
		exreport.flush();
	}
	
	@BeforeMethod
	public void setUpMethod() {
		System.setProperty("webdriver.chrome.driver", ".//Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	
	
	
	
	
	@Test
	public void titleVerification() {
	etest =	exreport.createTest("titleVerification");

		String hptitle = driver.getTitle();
		assertEquals("OrangeHRM" , hptitle);
	}
	
	@Test
	public void logoTest() {
		etest =	exreport.createTest("logoTest");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	boolean logodisplay =	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[1]/img")).isDisplayed();
		
		assertTrue(logodisplay);
	}
	
	@Test
	public void urlTest() {
		etest =	exreport.createTest("urlTest");
    String url = driver.getCurrentUrl()	;	
		assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login" , url);
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException { // result var contains result of methods or status of methods
		if (result.getStatus() == ITestResult.FAILURE) {
			etest.log(Status.FAIL, "The Test case name is :-" + result.getName()); //to add name in extent report
			etest.log(Status.FAIL, "The error is :-" + result.getThrowable());// to add the exception in report
			String screenshotpath = ExtentReportDemo.takesSS(driver , result.getName());
			etest.addScreenCaptureFromPath(screenshotpath);
		}
		else if (result.getStatus() == ITestResult.SKIP){
			etest.log(Status.SKIP, "The Skipped test is :- " + result.getName());
			
		}
		else if (result.getStatus() == ITestResult.SKIP) {
			etest.log(Status.PASS, "The passed test name is:- " + result.getName() );
		}
		
		driver.quit();
	}
		
	
	
	
	
	
	
	public static String takesSS(WebDriver driver ,String name) throws IOException {
		
		String datetime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File filesrc = ts.getScreenshotAs(OutputType.FILE);
		
		String destination = System.getProperty("user.dir") + "/Screenshot/" + datetime + name + ".png";	
	    File finaldest = new File(destination);
	    FileUtils.copyFile(filesrc, finaldest);
	    return destination;
	
	
	
	
	}

}
