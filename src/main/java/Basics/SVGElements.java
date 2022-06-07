package Basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVGElements {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://frappe.io/charts");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,4000)");
		
		Thread.sleep(2000);
		
		String plotdotXpath="//*[local-name()='svg' and @class='//']//*[name()='g' and @class='dataset-units dataset-line dataset-0']//*[name()='circle']";
		
		String dotXpath="//*[local-name()='svg' and @class='//']//*[name()='g' and @class='dataset-units dataset-line dataset-0']//*";
		
		List<WebElement> plotList=driver.findElements(By.xpath(dotXpath));
		for(WebElement e:plotList) {
			Actions act=new Actions(driver);
			act.moveToElement(e).build().perform();
			Thread.sleep(500);
			
			
			}
		}

}
