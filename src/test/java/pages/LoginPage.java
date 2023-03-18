package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import testcases.BaseClass;

public class LoginPage {
	WebDriver driver = BaseClass.driver;
	
	ExtentTest test = BaseClass.test;
	
	
//	@FindBy(linkText = "Log in")
//	WebElement LoginLink;
	
	@FindBy(name = "user_login")
	WebElement UserName;
	
	@FindBy(id = "password")
	WebElement Password;
	
	@FindBy(className = "rememberMe")
	WebElement RememberMe;
	
	@FindBy(name = "btn_login")
	WebElement LoginBtn;
	
	public LoginPage() {
		PageFactory.initElements(driver, this); //constructor
	}
	
	public void LoginFunction(String UserNameVal,String PasswordVal) throws InterruptedException {
		Thread.sleep(3000);
		//LoginLink.click();
		UserName.sendKeys(UserNameVal);
		test.log(LogStatus.PASS, "UserName Entered");
		Password.sendKeys(PasswordVal);
		test.log(LogStatus.PASS, "Password Entered");
		RememberMe.click();
		test.log(LogStatus.PASS, "Selected Remember Me");
		LoginBtn.click();
		test.log(LogStatus.PASS, "Clicked login button");
	}
	public void LoginCheck() {
		Assert.assertTrue(UserName.isDisplayed());
	}
	
	public void Clear() {
	UserName.clear();
	test.log(LogStatus.PASS, "UserName Field Cleared");
	Password.clear();
	test.log(LogStatus.PASS, "Password Field Cleared");
	}
}
