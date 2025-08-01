package testscript1;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Messages;
import pages.AdminPage;
import pages.LoginPage;
import utility.ExcelUtility;
import utility.FakerUtility;

public class AdminTest extends Base {
	@Test(retryAnalyzer = retry.Retry.class, description = "Verify that a new admin user can be created successfully after valid login.")
	public void verifyUserIsAbleToLoginWithValidCredentials() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickLogin();

		AdminPage adminpage = new AdminPage(driver);
		
		
		adminpage.clickAdminUsers();
		
		adminpage.clickNewAdmin();
		// String newusername=ExcelUtility.getStringData(1,0,"adminusers");
		// String newpassword=ExcelUtility.getStringData(1,1,"adminusers");
		FakerUtility fakerutility = new FakerUtility();
		String newusername = fakerutility.creatARandomFirstName();
		String newpassword = fakerutility.creatARandomLastName();
		adminpage.enterUsername(newusername);
		adminpage.enterPassword(newpassword);
		adminpage.selectType();
		adminpage.save();
		Boolean alertisdisplayed = adminpage.alertIsDisplayed();
		Assert.assertTrue(alertisdisplayed, Messages.ADMINUSERCREATIONFAILED);

	}

	@Test(description = "Verify that the admin can update an existing user's details successfully.")
	public void verifyAdminCanUpdateField() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickLogin();

		AdminPage adminpage = new AdminPage(driver);
		adminpage.clickAdminUsers();
		adminpage.clickNewAdmin();
        adminpage.clickUpdatebtnIcon();

		// Generate new data using FakerUtility
		FakerUtility fakerutility = new FakerUtility();
		String updatedUsername = fakerutility.creatARandomFirstName();
		String updatedPassword = fakerutility.creatARandomLastName();

		adminpage.clearAndEnterUsername(updatedUsername);
		adminpage.clearAndEnterPassword(updatedPassword);
		adminpage.selectType();
		adminpage.update();
		boolean displayalert=adminpage.isUpdateAlertDisplayed();
		Assert.assertTrue(displayalert,Messages.ADMINUSERUPDATEALERTNOTDISPLAYED);

	}

	

	@Test(description = "Verify that an alert is displayed after successfully updating admin user details.")
	public void verifyAlertIsDisplayedAfterUpdate() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickLogin();

		AdminPage adminpage = new AdminPage(driver);
		adminpage.clickAdminUsers();
		adminpage.clickUpdatebtnIcon();
		FakerUtility fakerutility = new FakerUtility();
		String updatedUsername = fakerutility.creatARandomFirstName();
		String updatedPassword = fakerutility.creatARandomLastName();
		adminpage.clearAndEnterUsername(updatedUsername);
		adminpage.clearAndEnterPassword(updatedPassword);
		adminpage.selectType();
		adminpage.update();
		boolean isalert = adminpage.isUpdateAlertDisplayed();
		Assert.assertTrue(isalert, Messages.ADMINUSERUPDATEALERTNOTDISPLAYED);
	}
	
	@Test(description = "Verify that the Update button is enabled when editing admin user details.")
	public void validateUpdateButtonIsEnabled() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickLogin();

		AdminPage adminpage = new AdminPage(driver);
		adminpage.clickAdminUsers();
		adminpage.clickUpdatebtnIcon();
		FakerUtility fakerutility = new FakerUtility();
		String updatedUsername = fakerutility.creatARandomFirstName();
		String updatedPassword = fakerutility.creatARandomLastName();
		adminpage.clearAndEnterUsername(updatedUsername);
		adminpage.clearAndEnterPassword(updatedPassword);
		adminpage.selectType();
	    boolean isEnabled = adminpage.isUpdatedButtonEnabled();
		Assert.assertTrue(isEnabled, Messages.UPDATEBUTTONNOTENABLED);
	}

}