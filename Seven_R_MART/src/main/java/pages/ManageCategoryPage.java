package pages;

import java.awt.AWTException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constant;
import utility.FileUploadUtility;
import utility.PageUtility;
import utility.WaitUtility;

public class ManageCategoryPage {

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='small-box-footer']")
	WebElement moreinfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Category/add']")
	WebElement newbtn;
	@FindBy(xpath = "//input[@class='form-control' and @id='category']")
	WebElement category;
	@FindBy(xpath = "//input[@name='main_img']")
	WebElement choosefile;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement savebtn;
	@FindBy(xpath = "//div[@id='imagePreview']")
	WebElement imagepreview;
	public WebDriver driver;

	public ManageCategoryPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickMoreInfo() {
		moreinfo.click();
	}

	public void clickNewButton() {
		newbtn.click();
	}

	public void enterCategory(String categoryname) {
		category.sendKeys(categoryname);
	}

	public void choosefileUpload(String categoryimage2) {
		FileUploadUtility fileupload = new FileUploadUtility();
		fileupload.fileUploadUsingSendKeys(choosefile, categoryimage2);
	}

	public boolean isImagePreviewDisplayed() {
		return imagepreview.isDisplayed();
	}

	/*
	 * public void saveCategory() {
	 * 
	 * savebtn.click(); }
	 */

}
