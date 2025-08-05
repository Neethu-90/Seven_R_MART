package testscript1;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Messages;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNews;
import utility.ExcelUtility;

public class MnageNewsTest extends Base {
	ManageNews managenews;
	HomePage homepage;
	@Test(description = "Verify that the user is able to add a news item and a success alert is displayed.")
	public void verifyUserIsabletoAddNews() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username).enterPassword(password);
		//loginpage.enterPassword(password);
		homepage=loginpage.clickLogin();
		//ManageNews managenews = new ManageNews(driver);
		//managenews.clickManageNewsMoreInfo();
		managenews=homepage.clickManageNewsMoreInfo();
		//managenews.clickNewButton();
		String news = ExcelUtility.getStringData(1, 0, "managenews");
		//managenews.enterNews(news);
		//managenews.clickSave();
		managenews.clickNewButton().enterNews(news).clickSave();
		// managenewspage.clickCancel();
		Boolean isalertdisplayed = managenews.isAlertDisplayed();
		Assert.assertTrue(isalertdisplayed, Messages.ADDNEWSALERTNOTDISPLAYED);

	}

}
