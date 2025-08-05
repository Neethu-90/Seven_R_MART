package utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/* used to handle wait conditions like waiting for an element to be visible or clickable.
It helps make the test more stable by avoiding issues like element not found or not interactable errors."*/
public class WaitUtility {
	public static final int IMPLICITWAIT = 10;
	public static final int EXPLICITWAIT = 10;

	public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// Wait for element to be visible
	public void waitForElementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// Wait for element to be present in DOM (but not necessarily visible)
	public void waitForPresenceOfElementLocated(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	// Wait for element to be invisible
	public void waitForElementToBeInvisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	// Wait for title to contain a specific text
	public void waitForTitleToContain(WebDriver driver, String partialTitle) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
		wait.until(ExpectedConditions.titleContains(partialTitle));
	}

	// Wait for URL to contain a specific text
	public void waitForURLToContain(WebDriver driver, String partialURL) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
		wait.until(ExpectedConditions.urlContains(partialURL));
	}

}
