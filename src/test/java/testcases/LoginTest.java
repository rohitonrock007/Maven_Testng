package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;



public class LoginTest extends BaseClass {
//
//	WebDriver driver;
//	
//	@BeforeMethod
//	public void setup() {
//		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
//		
//		driver = new ChromeDriver();
//		//WebDriver driver = new FirefoxDriver();
//		
//		driver.get("https://www.simplilearn.com/");
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
//		
//	}
//	
//	@AfterMethod
//    public void teardown() {
//    	
//    	driver.quit();
//		
//		
//	}
	
	@Test
	public void LoginFailiureTest() {
		
//		test = report.startTest("LoginFailiureTest");
		
		LoginPage login = new LoginPage();
		
		login.LoginFunction("xyz@gmail.com","Abc@12345");
		
		WebElement ErrorMsg = driver.findElement(By.id("msg_box")); 
		
		String ActualMsg = ErrorMsg.getText();
		String ExpMsg = "The email or password you have entered is invalid.";
		
		Assert.assertEquals(ActualMsg, ExpMsg);//hard assertion
		
//		report.endTest(test);
		
//		if(ActualMsg.equals(ExpMsg)) {
//			System.out.println("TC Passed");
//		}else {
//			System.out.println("TC Failed");
		}
		
	@Test
	public void LoginSucessTest() {
//		test = report.startTest("LoginSucessTest");
		LoginPage login = new LoginPage();
		login.LoginFunction("r.rohitsharma92@gmail.com", "**********");
		
//		report.endTest(test);

	}
	@Test
	@Parameters({"Param1","Param2"})
	public void ParameterizedTest(String UserNameVal, String PasswordVal) {
//		test = report.startTest("ParameterizedTest");
		LoginPage login = new LoginPage();
		login.LoginFunction(UserNameVal,PasswordVal);		
//		report.endTest(test);
	}
	@Test
	public void ExternalDataTest() {
//		test = report.startTest("ExternalDataTest");
			String UserNameVal = sheet.getRow(1).getCell(0).getStringCellValue();
			String PasswordVal = sheet.getRow(1).getCell(1).getStringCellValue();
			
			LoginPage login = new LoginPage();
			login.LoginFunction(UserNameVal,PasswordVal);	
//			report.endTest(test);
		}

	
}

