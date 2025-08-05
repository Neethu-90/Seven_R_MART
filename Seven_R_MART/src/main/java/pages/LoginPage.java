package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.WaitUtility;


public class LoginPage {
	@FindBy(xpath="//input[@name='username']") WebElement username;
	@FindBy(xpath="//input[@name='password']") WebElement password;
	@FindBy(xpath="//button[text()='Sign In']") WebElement login;
	@FindBy(xpath="//p[text()='Dashboard']") WebElement dashboard;// used to automate login page
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']") WebElement alert;
	
public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);//static method initialize webelmts(initelemts mtd)
		
	}
	public LoginPage enterUsername(String username2)
	{
		username.sendKeys(username2);
		return this;
	}
	public LoginPage enterPassword(String password2)
	{
		password.sendKeys(password2);
		return this;
	}
	public HomePage clickLogin()
	{
		login.click();
		return new HomePage(driver);
	}
	public boolean isDashboardDisplayes()
	{
		return dashboard.isDisplayed();
	}
	 public boolean getAlertElement()
	 {
	        return alert.isDisplayed();
	 }

	public boolean isAlertDisplayed() {
	    WaitUtility wait = new WaitUtility();
	    wait.waitForElementToBeVisible(driver, alert);  // use element wait
	    return alert.isDisplayed();
	}
	
	/*public Boolean isAlertDisplayed()
	{
		return alert.isDisplayed();
	}*/
}


