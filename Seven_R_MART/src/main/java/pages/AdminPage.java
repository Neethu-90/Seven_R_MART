package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import utility.PageUtility;
import utility.WaitUtility;

public class AdminPage {

	//@FindBy(xpath = "//a[contains(@href,'list-admin') and contains(@class,'small-box-footer')]") WebElement adminusers;
	//@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'])[1]") WebElement adminusersmoreinfo;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newadmin;
	@FindBy(xpath = "//input[@class='form-control' and @name='username']")
	WebElement enterusername;
	@FindBy(xpath = "//input[@class='form-control' and @name='password']")
	WebElement enterpassword;
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement usertype;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-danger'and @name='Create']")
	WebElement savebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successalert;
	//@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	//WebElement dismissalert;
	@FindBy(xpath = "(//a[contains(@href, '/admin/user/edit')])[1]")
	WebElement updateicon;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-info' and @name='Update']")
	WebElement update;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement updatealert;
	public WebDriver driver;

	public AdminPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*public void clickAdminUsersmoreinfo() {
		//adminusers.click();
		PageUtility page=new PageUtility();
		page.clickUsingJS(driver, adminusersmoreinfo);
		
	}*/

	public AdminPage clickNewAdmin() {
		newadmin.click();
		return this;
	}

	public AdminPage enterUsername(String newusername) {
		enterusername.sendKeys(newusername);
		return this;
	}

	public AdminPage enterPassword(String newpassword) {
		enterpassword.sendKeys(newpassword);
		return this;
	}

	public AdminPage clearAndEnterUsername(String newusername) {
		enterusername.clear();
		enterusername.sendKeys(newusername);
		return this;
	}

	public AdminPage clearAndEnterPassword(String newpassword) {
		enterpassword.clear();
		enterpassword.sendKeys(newpassword);
		return this;
	}

	public AdminPage selectType() {
		// Select select=new Select(usertype);
		// select.selectByVisibleText("Staff");
		PageUtility pageutility = new PageUtility();
		pageutility.selectByVisibleText(usertype, "Staff");
		return this;
	}

	public AdminPage save() {
		savebutton.click();
		return this;
	}

	
	public Boolean alertIsDisplayed() {
		return successalert.isDisplayed();
	}

	/*public Boolean dismissAlertIsDisplayed() {
		return dismissalert.isDisplayed();
	}*/
	public AdminPage clickUpdatebtnIcon() {
		//updateicon.click();
		PageUtility page=new PageUtility();
		page.clickUsingJS(driver, updateicon);
		return this;
	}
	public AdminPage update() {
		update.click();
		return this;
	}

	
	public boolean isUpdatedButtonEnabled() {
		return update.isEnabled();
	}

	public boolean isUpdateAlertDisplayed() {
		return updatealert.isDisplayed();
	}

}
