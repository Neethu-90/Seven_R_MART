package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import utility.PageUtility;
import utility.WaitUtility;

public class AdminPage {

	//@FindBy(xpath = "//a[contains(@href,'list-admin') and contains(@class,'small-box-footer')]") WebElement adminusers;
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'])[1]") WebElement adminusers;
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

	public void clickAdminUsers() {
		//adminusers.click();
		PageUtility page=new PageUtility();
		page.clickUsingJS(driver, adminusers);
		
	}

	public void clickNewAdmin() {
		newadmin.click();
	}

	public void enterUsername(String newusername) {
		enterusername.sendKeys(newusername);
	}

	public void enterPassword(String newpassword) {
		enterpassword.sendKeys(newpassword);
	}

	public void clearAndEnterUsername(String newusername) {
		enterusername.clear();
		enterusername.sendKeys(newusername);
	}

	public void clearAndEnterPassword(String newpassword) {
		enterpassword.clear();
		enterpassword.sendKeys(newpassword);
	}

	public void selectType() {
		// Select select=new Select(usertype);
		// select.selectByVisibleText("Staff");
		PageUtility pageutility = new PageUtility();
		pageutility.selectByVisibleText(usertype, "Staff");
	}

	public void save() {
		savebutton.click();
	}

	
	public Boolean alertIsDisplayed() {
		return successalert.isDisplayed();
	}

	/*public Boolean dismissAlertIsDisplayed() {
		return dismissalert.isDisplayed();
	}*/
	public void clickUpdatebtnIcon() {
		//updateicon.click();
		PageUtility page=new PageUtility();
		page.clickUsingJS(driver, updateicon);
	}
	public void update() {
		update.click();
	}

	
	public boolean isUpdatedButtonEnabled() {
		return update.isEnabled();
	}

	public boolean isUpdateAlertDisplayed() {
		return updatealert.isDisplayed();
	}

}
