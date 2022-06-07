package Basics;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWaits {

	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.amazon.com/");

	By searchBox=(By.id("twotabsearchtextbox"));
	
	waittillElementPresent(searchBox, 10).sendKeys("Jeans");
		
	}

	public static WebElement waittillElementPresent(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public static WebElement waittillElementPresentInterval(By locator, int timeout,int interval) {
		WebDriverWait wait = new WebDriverWait(driver, timeout, interval);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page.
	 * This does notnecessarily mean that the element is visible.
	 * 
	 * @param locator
	 * @param timeout
	 * @return
	 */

	public WebElement waitForElementPresent(By locator, long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public WebElement waitForElementPresent(By locator, long timeout, long IntervalTime) {
		WebDriverWait wait = new WebDriverWait(driver, timeout, IntervalTime);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public List<WebElement> waitforPresenceofElements(By locator, int timouts) {
		WebDriverWait wait = new WebDriverWait(driver, timouts);
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}

	public List<String> getListofElementsusingWaits(By locator, int timeouts) {
		List<WebElement> elelists = waitforPresenceofElements(locator, timeouts);
		List<String> eleVallist = new ArrayList<String>();
		for (WebElement e : elelists) {
			eleVallist.add(e.getText());
		}
		return eleVallist;
	}

	public void printListofElements(By locator, int timeouts) {
		List<WebElement> elelist = waitforPresenceofElements(locator, timeouts);
		for (WebElement e : elelist) {
			System.out.println(e.getText());
		}
	}
	
	public List<WebElement> waitforVisibilityofElements(By locator, int timouts) {
		WebDriverWait wait = new WebDriverWait(driver, timouts);
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	public List<String> getVisibleListofElementsusingWaits(By locator, int timeouts) {
		List<WebElement> elelists = waitforVisibilityofElements(locator, timeouts);
		List<String> eleVallist = new ArrayList<String>();
		for (WebElement e : elelists) {
			eleVallist.add(e.getText());
		}
		return eleVallist;
	}

	/**
	 * An expectation for checking that an element is present on the DOM of a page
	 * and visible. Visibility means that the element is not only displayed but also
	 * has a height and width that isgreater than 0.
	 * 
	 * @param locator
	 * @param timeout
	 * @return
	 */

	public WebElement waitForElementVisible(By locator, long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public WebElement waitforElementtobeClickable(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void clickWhenReady(By locator, int timeout) {
		waitforElementtobeClickable(locator, timeout).click();
	}
	
	
}
