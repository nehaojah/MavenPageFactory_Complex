package testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseClass {

	public static WebDriver driver;
	XSSFWorkbook wbook;
	XSSFSheet sheet;
	
	
	public static ExtentReports report;  // customized reports
	public static ExtentTest test; // customized test messages

	@BeforeMethod
	public void SetUp() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://accounts.simplilearn.com/user/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@BeforeTest
	public void testData() throws IOException {
		FileInputStream fis = new FileInputStream("Test_Data.xlsx");
		wbook = new XSSFWorkbook(fis);
		sheet = wbook.getSheet("Sheet1");
		
		report = new ExtentReports("ExtentReport.html");

	}

	@AfterTest
	public void DataClose() throws IOException {
		wbook.close();
		report.flush();
		report.close();
		test.log(LogStatus.PASS, "Data Closed");
	}

	@AfterMethod
	public void QuitBrowser() {
		driver.quit();
	}

}
