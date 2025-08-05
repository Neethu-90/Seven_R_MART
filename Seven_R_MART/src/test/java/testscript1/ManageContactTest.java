package testscript1;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Messages;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageContactPage;
import utility.ExcelUtility;

public class ManageContactTest extends Base {
	ManageContactPage manage;
	HomePage homepage;
	@Test(description = "Verify that the admin is able to update contact details in the Manage Contact section successfully.")
	public void validateAdminIsAbleToUpdateManageContact() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username).enterPassword(password);
		//loginpage.enterPassword(password);
		homepage=loginpage.clickLogin();

		//ManageContactPage manage = new ManageContactPage(driver);
		//manage.clickManageContactMoreInfo();
		//String mailId = ExcelUtility.getStringData(1, 0, "managecontact");

		manage=homepage.clickManageContactMoreInfo();
		manage.clickActions();
		String mailId = ExcelUtility.getStringData(1, 0, "managecontact");
		manage.updateEmail(mailId);
		manage.updateDetails();
		boolean alert = manage.isGreenAlertDisplayed();
		Assert.assertTrue(alert, Messages.CONTACTUPDATEFAILED);

	}
}
