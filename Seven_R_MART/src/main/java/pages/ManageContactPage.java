package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageContactPage {

	//@FindBy(xpath = "//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-contact']")
	//WebElement managecontactmoreInfo;
	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-primary btncss']")
	WebElement actions;
	@FindBy(xpath = "//input[@id='email']")
	WebElement email;
	@FindBy(xpath = "//textarea[@id='content' and @placeholder='Enter the Address']")
	WebElement address;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-info']")
	WebElement update;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement greenAlert;

	public WebDriver driver;

	public ManageContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*public void clickMoreInfo() {
		managecontactmoreInfo.click();
	}*/

	public ManageContactPage clickActions() {
		actions.click();
		return this;
	}

	public ManageContactPage updateEmail(String mailId) {
		email.clear();
		email.sendKeys(mailId);
		return this;
	}

	public ManageContactPage updateDetails() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", update);
		js.executeScript("arguments[0].click();", update);
		// update.click();
		return this;
	}

	public boolean isGreenAlertDisplayed() {
		return greenAlert.isDisplayed();
	}
}
