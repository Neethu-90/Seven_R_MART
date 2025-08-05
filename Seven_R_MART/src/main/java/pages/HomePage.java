package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.PageUtility;

public class HomePage {
	
    @FindBy(xpath = "//a[@class='nav-link' and @data-toggle='dropdown']")
	WebElement admin;
    @FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout' and @class='dropdown-item']")
	WebElement logoutbtn;
	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement signin;
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'])[1]") WebElement adminusersmoreinfo;
	public WebDriver driver;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='small-box-footer']")
	WebElement managecategorymoreinfo;
	@FindBy(xpath = "//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-contact']")
	WebElement managecontactmoreInfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext' and @class='small-box-footer']")
	WebElement managefootermoreinfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news'and@class='small-box-footer']")
	WebElement managenewsmoreinfo;

	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public AdminPage clickAdminUsersmoreinfo() {
		//adminusers.click();
		PageUtility page=new PageUtility();
		page.clickUsingJS(driver, adminusersmoreinfo);
		return new AdminPage(driver);
		
	}
	public 	ManageCategoryPage clickManageCategoryMoreInfo() {
		//managecategorymoreinfo.click();
		PageUtility page=new PageUtility();
		page.clickUsingJS(driver, managecategorymoreinfo);
		return new ManageCategoryPage(driver);
	}
	public ManageContactPage clickManageContactMoreInfo() {
		managecontactmoreInfo.click();
		return new ManageContactPage(driver);
	}
	public ManageFooterPage clickManageFooterMoreinfo() {
		managefootermoreinfo.click();
		return new ManageFooterPage(driver);
	}

	public ManageNews clickManageNewsMoreInfo() {
		// moreinfo.click();
		PageUtility pageutility = new PageUtility();
		// pageutility.scrollToElement(driver, moreinfo);
		pageutility.actionClick(driver, managenewsmoreinfo);
		return new ManageNews(driver);
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
