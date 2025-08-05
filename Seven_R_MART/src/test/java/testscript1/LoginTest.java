package testscript1;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Messages;
import pages.HomePage;
import pages.LoginPage;
import utility.ExcelUtility;

public class LoginTest extends Base {
	
	LoginPage loginpage;
	HomePage homepage;
	@Test(description = "Verify that the user is able to log in with valid credentials from the Excel sheet and navigate to the dashboard successfully.")
	public void verifyUserIsAbleToLoginWithValidCredentials() throws IOException {
		// String username="admin";
		// String password="admin";
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username).enterPassword(password);
		//loginpage.enterPassword(password);
		homepage=loginpage.clickLogin();
		Boolean ishomepagedisplayed = loginpage.isDashboardDisplayes();
		Assert.assertTrue(ishomepagedisplayed, Messages.LOGINVALIDCREDENTIALS);
	}

	@Test(retryAnalyzer = retry.Retry.class, description = "Verify that an alert is displayed when the user attempts to login with a valid username and an invalid password.")
	public void verifyUserIsAbleToLoginwithInvalidPassword() {
		String username = "admin";
		String password = "test";
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username).enterPassword(password);
		//loginpage.enterPassword(password);
		homepage=loginpage.clickLogin();
		
		// Now check if alert is displayed
		boolean isAlertDisplayed = loginpage.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed, Messages.LOGININVALIDPASSWORD);

	}

	@Test(description = "Verify that an alert is displayed when the user attempts to login with an invalid username and a valid password.")
	public void verifyUserIsAbleToLoginwithInvalidUsername() {
		String username = "test";
		String password = "admin";
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username).enterPassword(password);
		//loginpage.enterPassword(password);
		homepage=loginpage.clickLogin();
		Boolean isalertdisplayed = loginpage.isAlertDisplayed();
		Assert.assertTrue(isalertdisplayed, Messages.LOGININVALIDUSERNAME);

	}

	@Test(description = "Verify that an alert is displayed when the user attempts to login with both invalid username and invalid password.")
	public void verifyUserIsAbleToLoginwithInvalidUsernameAndPassword() {
		String username = "test";
		String password = "log";
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username).enterPassword(password);
		//loginpage.enterPassword(password);
		homepage=loginpage.clickLogin();
		Boolean isalertdisplayed = loginpage.isAlertDisplayed();
		Assert.assertTrue(isalertdisplayed, Messages.LOGININVALIDCREDENTIALS);

	}
}
