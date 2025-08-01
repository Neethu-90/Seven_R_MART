package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.PageUtility;

public class ManageNews {
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news'and@class='small-box-footer']")
	WebElement moreinfo;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newbtn;
	@FindBy(xpath = "//textarea[@id='news']")
	WebElement news;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement savebtn;
	// @FindBy(xpath="//a[text()='Cancel']") WebElement cancelbtn;
	@FindBy(xpath = "//button[@data-dismiss='alert']")
	WebElement alert;
	public WebDriver driver;

	public ManageNews(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickMoreInfo() {
		// moreinfo.click();
		PageUtility pageutility = new PageUtility();
		// pageutility.scrollToElement(driver, moreinfo);
		pageutility.actionClick(driver, moreinfo);
	}

	public void clickNewButton() {
		// newbtn.click();
		PageUtility pageutility = new PageUtility();
		pageutility.scrollToElement(driver, newbtn);
		newbtn.click(); // Direct click is fine here*/
	}

	public void enterNews(String news2) {
		news.sendKeys(news2);
	}

	public void clickSave() {
		// savebtn.click();
		PageUtility pageutility = new PageUtility();
		// pageutility.scrollToElement(driver, savebtn);
		pageutility.clickUsingJS(driver, savebtn); // For reliable click
	}

	/*
	 * public void clickCancel() { cancelbtn.click(); }
	 */
	public Boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}

}
