package Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionClass {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		BrowserUitil br = new BrowserUitil();
		driver = br.initDriver("chrome");
		br.launchUrl("http://automationpractice.com/index.php");

		// WebElement womenbtn=driver.findElement(By.linkText("WOMEN"));

		// Actions act=new Actions(driver);
		// act.moveToElement(womenbtn).build().perform();
		// Thread.sleep(2000);
		// WebElement blousebtn=driver.findElement(By.linkText("Blouses"));
		// act.moveToElement(blousebtn).click().build().perform();

		By womenBtn = By.linkText("WOMEN");
		By blouseBtn = By.linkText("Blouses");
		parentChildMenuHandle(womenBtn, blouseBtn);
		
		

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);

	}

	public static void parentChildMenuHandle(By parent, By child) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parent)).build().perform();
		Thread.sleep(2000);
		act.moveToElement(getElement(child)).click().build().perform();
	
	}

}
