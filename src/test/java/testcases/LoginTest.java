package testcases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.LoginPage;

public class LoginTest extends BaseClass {
	
	
//	public void LoginFailTest() throws InterruptedException {
//	LoginPage login = new LoginPage();
//	login.LoginFunction("test.1@gmail.com", "Neha123@123");
//	WebElement ErrorMsg = driver.findElement(By.id("msg_box"));
//	String ActualMsg = ErrorMsg.getText();
//	String ExpMsg = "The email or password you have entered is invalid.";
//	Assert.assertEquals(ActualMsg, ExpMsg);
//	}
//	
	
	@Test
	public void excelTestData() throws InterruptedException {
		test = report.startTest("excelTestData");
	int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		 
	 for (int i = 1; i <= rowCount; i++) {
	
		String UserNameVal = sheet.getRow(i).getCell(0).getStringCellValue();
		String PasswordVal = sheet.getRow(i).getCell(1).getStringCellValue();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		LoginPage login_1 = new LoginPage();
		
		login_1.LoginFunction(UserNameVal, PasswordVal);
		WebElement ErrorMsg = driver.findElement(By.id("msg_box"));
		String ActualMsg = ErrorMsg.getText();
		String ExpMsg = "The email or password you have entered is invalid.";
		Assert.assertEquals(ActualMsg, ExpMsg);
		test.log(LogStatus.PASS, "Asserted");
		login_1.Clear();
//		if(driver.getTitle() != "Simplilearn | Online Courses - Bootcamp & Certification Platform") {
//			
//			 driver.navigate().back();
//        }
		 
		report.endTest(test);
	 }
	}

}
