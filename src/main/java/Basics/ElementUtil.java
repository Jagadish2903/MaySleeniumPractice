package Basics;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	private WebDriver driver;

	// constructor
	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * These are my generic utility
	 * 
	 * @param locator
	 * @return
	 */

	public WebElement getElement(By locator) {
		return driver.findElement(locator);

	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}

	public String doGetText(By locator) {
		return getElement(locator).getText();
	}

	public boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

	public boolean doIsEnabled(By locator) {
		return getElement(locator).isEnabled();
	}

	public boolean doIsSelected(By locator) {
		return getElement(locator).isSelected();
	}

	public boolean checkElementIsDisplayed(By locator, String attributeName) {
		String Attribute = doGetAttributeValue(locator, attributeName);
		if (Attribute.equals("true")) {
			return true;
		} else {
			return false;
		}
	}

	public String doGetAttributeValue(By locator, String attributeName) {
		return getElement(locator).getAttribute(attributeName);
	}

	public void doLinkClick(By locator, String linkValue) {
		List<WebElement> links = getElements(locator);
		for (WebElement e : links) {
			String LinksText = e.getText();
			if (LinksText.trim().equals(linkValue)) {
				e.click();
				break;
			}
		}
	}

	/********************************
	 * DROPDOWN UTIL
	 *****************************************/

	/**
	 * These are my dropdown Utils
	 */

	public void doselectByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);

	}

	public void doselectByVisibleText(By locator, String text) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);

	}

	public void doselectByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);

	}

	// to achieve encapsulation making it as private and access it in public
	private void iteratedropdownandSelect(List<WebElement> Optionslist, String value) {
		for (WebElement e : Optionslist) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals(value)) {
				e.click();
				break;
			}
		}
	}

	public void doselectDropdown(By locator, String value) {
		Select select = new Select(getElement(locator));
		List<WebElement> Optionslist = select.getOptions();
		iteratedropdownandSelect(Optionslist, value);
	}

	public void selectDropdownwithoutSelect(By locator, String value) {
		List<WebElement> Optionslist = getElements(locator);
		iteratedropdownandSelect(Optionslist, value);
	}

	/**
	 * ============================================================Action
	 * Utils====================================
	 **/

	public void parentChildMenuHandle(By parent, By child) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parent)).build().perform();
		Thread.sleep(2000);
		act.moveToElement(getElement(child)).click().build().perform();
	}

	public List<String> getrightClickChecklist(By rightclick, By items) {
		List<String> itemsValuelist = new ArrayList<String>();
		Actions act = new Actions(driver);
		act.contextClick(getElement(rightclick)).build().perform();
		List<WebElement> menuList = getElements(items);
		for (WebElement e : menuList) {
			String text = e.getText();
			System.out.println(text);
			itemsValuelist.add(text);
		}
		return itemsValuelist;
	}

	public int getRightClickItemsCount(By rightclick, By items) {
		return getrightClickChecklist(rightclick, items).size();
	}

	public void rightclickItem(By rightclick, By items, String value) {
		Actions act = new Actions(driver);
		act.contextClick(getElement(rightclick)).build().perform();
		List<WebElement> menuList = getElements(items);
		for (WebElement e : menuList) {
			String text = e.getText();
			if (text.equalsIgnoreCase(value)) {
				e.click();
				break;
			}
		}
	}

	public void doActionSendKeys(By locator, String value) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), value).build().perform();
	}

	public void doActionClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).build().perform();
	}

	/**
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++Wait
	 * Utils++++++++++++++++++++++++++++++
	 **/

	public WebElement waitForElementPresent(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public WebElement waitForElementPresentInterval(By locator, int timeout, long Timeinterval) {
		WebDriverWait wait = new WebDriverWait(driver, timeout, Timeinterval);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public Alert waitforJSAlert(int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(int timeout) {
		waitforJSAlert(timeout).accept();
	}

	public void dismissAlert(int timeout) {
		waitforJSAlert(timeout).dismiss();
	}

	public String alertGetText(int timeout) {
		Alert alert = waitforJSAlert(timeout);
		String text = alert.getText();
		alert.accept();
		return text;
	}

	public void doSendKeysAlert(int timeout, String value) {
		waitforJSAlert(timeout).sendKeys(value);
	}

	public boolean waitforURLContains(int timeout, String Containsvalue) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.urlContains(Containsvalue));
	}

	public boolean waitUrlToBe(int timeout, String expectedURL) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.urlToBe(expectedURL));
	}

	public String waitforTitleContains(int timeout, String titleFraction) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		if (wait.until(ExpectedConditions.titleContains(titleFraction))) {
			return driver.getTitle();
		}
		return null;
	}

	public String waitforTitleIs(int timeout, String ExpectedTitle) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		if (wait.until(ExpectedConditions.titleIs(ExpectedTitle))) {
			return driver.getTitle();
		}
		return null;
	}

	public void waitForFramesusingNameorID(String FrameIDorName, int Timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Timeout);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(FrameIDorName));
	}

	public void waitForFramesusingframeByLocator(By frameLocator, int Timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Timeout);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}

	public void waitForFramesusingframeIndex(int frameIndex, int Timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Timeout);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
	}

	public void waitForFramesusingElementLocator(String frameElement, int Timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Timeout);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
	}

}
