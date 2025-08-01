package testscript1;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constant;
import utility.ScreenShotUtility;
import utility.WaitUtility;

public class Base {

	public WebDriver driver;

	public FileInputStream fileinput;
	Properties properties;

	@Parameters("browser")
	@BeforeMethod(alwaysRun = true)
	public void browserInitialization(String browser) throws Exception {
		try {
			properties = new Properties();
			fileinput = new FileInputStream(Constant.CONFIGFILE);
			properties.load(fileinput);

		} catch (Exception e) {
			System.out.println("Invalid");
		}
		if (browser.equalsIgnoreCase("Chrome")) {

			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else {
			throw new Exception("Browser is invalid");
		}

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.get("https://groceryapp.uniqassosiates.com/admin");
		driver.get(properties.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICITWAIT));
		}
    @AfterMethod(alwaysRun = true)
	public void browserQuit(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			ScreenShotUtility scrShot = new ScreenShotUtility(); // creating obj
			scrShot.getScreenShot(driver, iTestResult.getName());
		}
	     //driver.close();
		 driver.quit();
	}

}
