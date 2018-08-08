package student.maven;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TestScript {
	ExtentReports extent;
	ExtentTest test;
	WebDriver driver;
	
	
	@BeforeMethod
	public void setUp() {
		extent=ExtentManager.GetExtent();
		System.setProperty("webdriver.chrome.driver" , "./driver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				
	}
	@Test
	public void checkGoogle() {
		try {
			driver.get("https://www.google.com/");
			test=extent.createTest("Google","verify HomePage");
			String title=driver.getTitle();
			if(title.contains("Google")) {
				test.pass("Contains Title as Google");
			}
			else {
				test.log(Status.FAIL,"Doesn't contains title as Google");
			}
		}catch(Exception e) {
			test.log(Status.ERROR,e.getMessage());
		}
	}
	@AfterMethod
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}

