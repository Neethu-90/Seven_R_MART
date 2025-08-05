package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooterPage {

	//@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext' and @class='small-box-footer']")
	//WebElement managefootermoreinfo;
	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-primary btncss']")
	WebElement action;
	@FindBy(xpath = "//textarea[@id='content']")
	WebElement address;
	@FindBy(xpath = "//input[@id='email']")
	WebElement email;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-info']")
	WebElement update;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;

	public WebDriver driver;

	public ManageFooterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*public void clickMoreinfo() {
		managefootermoreinfo.click();
	}*/

	public ManageFooterPage clickAction() {
		action.click();
		return this;
	}

	public ManageFooterPage Addaddress(String newadd) {
		address.clear();
		address.sendKeys(newadd);
		return this;
	}

	public ManageFooterPage AddEmail(String newmail) {
		email.clear();
		email.sendKeys(newmail);
		return this;
	}

	public boolean isUpadateButtonDisplayed() {
		return update.isDisplayed();
	}

	public ManageFooterPage updateDetails() {
		update.click();
		return this;
	}

	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}

}
