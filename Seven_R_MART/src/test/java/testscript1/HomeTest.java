package testscript1;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Messages;
import pages.HomePage;
import pages.LoginPage;

import utility.ExcelUtility;

public class HomeTest extends Base {
	
	@Test(retryAnalyzer = retry.Retry.class,description = "Verify that the user is redirected to the sign-in page after logging out successfully.")
	public void verifyUserIsAbleToLogoutWithSuccessfully() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username).enterPassword(password);
		
		loginpage.clickLogin();
		HomePage logoutpage = new HomePage(driver);
		//logoutpage=homepage.clickOnAdmin();
		

		
		logoutpage.clickOnAdmin();
		logoutpage.clickLogout();
		Boolean sign = logoutpage.isSigninPageDisplayed();
		Assert.assertTrue(sign, Messages.LOGOUTFAILED);

	}

}
