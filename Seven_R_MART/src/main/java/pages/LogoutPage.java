package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {

	@FindBy(xpath = "//a[@class='nav-link' and @data-toggle='dropdown']")
	WebElement admin;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout' and @class='dropdown-item']")
	WebElement logoutbtn;
	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement signin;
	public WebDriver driver;

	public LogoutPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnAdmin() {
		admin.click();
	}

	public void clickLogout() {
		logoutbtn.click();
	}

	public Boolean isSigninPageDisplayed() {
		return signin.isDisplayed();
	}
}