package testscript1;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Messages;
import pages.LoginPage;
import pages.ManageFooterPage;
import utility.ExcelUtility;

public class ManageFooterTest extends Base {
	@Test(description = "Verify that the user can update footer information including address and email successfully.")
	public void validateUserCanUpdateFooterInfo() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickLogin();

		ManageFooterPage managefooter = new ManageFooterPage(driver);
		managefooter.clickMoreinfo();
		managefooter.clickAction();
		String newaddress = ExcelUtility.getStringData(1, 0, "managefooter");
		managefooter.Addaddress(newaddress);
		String newemail = ExcelUtility.getStringData(1, 1, "managefooter");
		managefooter.AddEmail(newemail);
		managefooter.updateDetails();
		boolean alerts = managefooter.isAlertDisplayed();
		Assert.assertTrue(alerts, Messages.FOOTERUPDATEALERTNOTDISPLAYED);

	}

	@Test(description = "Verify that the Update button is displayed when editing footer details.")
	public void validateUpdateButtonIsDisplayed() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickLogin();

		ManageFooterPage managefooter = new ManageFooterPage(driver);
		managefooter.clickMoreinfo();
		managefooter.clickAction();
		Boolean updatebtn = managefooter.isUpadateButtonDisplayed();
		Assert.assertTrue(updatebtn, Messages.FOOTERUPDATEBUTTONNOTDISPLAYED);

	}

}
