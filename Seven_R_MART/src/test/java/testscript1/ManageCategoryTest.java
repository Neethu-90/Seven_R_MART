package testscript1;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import constant.Messages;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utility.ExcelUtility;
import utility.FakerUtility;

public class ManageCategoryTest extends Base {
	@Test(groups = {
			"Regression" }, description = "Verify that a user can successfully log in and create a new category with an image upload.")
	public void verifyUserIsAbleToLoginWithValidCredentials() throws IOException {
		// String username="admin";
		// String password="admin";
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickLogin();
		Boolean ishomepagedisplayed = loginpage.isDashboardDisplayes();
		Assert.assertTrue(ishomepagedisplayed,Messages.LOGINVALIDCREDENTIALS);

		ManageCategoryPage categorypage = new ManageCategoryPage(driver);
		categorypage.clickMoreInfo();
		categorypage.clickNewButton();

		FakerUtility fakerutility = new FakerUtility();
		String newCategory = fakerutility.creatARandomFirstName();
		categorypage.enterCategory(newCategory);
		categorypage.choosefileUpload(Constant.CATEGORYIMAGE);
		boolean imagedisplayed = categorypage.isImagePreviewDisplayed();
		Assert.assertTrue(imagedisplayed, Messages.CATEGORYIMAGEUPLOADFAILED);

	}

}
