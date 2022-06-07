package Basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeSuggestionList {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("http://automationpractice.com/index.php");
		String url = driver.getCurrentUrl();
		System.out.println("The URL is " + url);

		System.out.println("===============================================================");

		By searchbox = By.id("search_query_top");
		driver.findElement(searchbox).sendKeys("dress");
		Thread.sleep(5000);
		By suggeList = By.xpath("//div[@class='ac_results']//li");

		List<WebElement> list = driver.findElements(suggeList);
		for (WebElement e : list) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals("Summer Dresses > Printed Chiffon Dress")) {
				e.click();
				break;
			}
		}
		System.out.println("====================================================");

		Thread.sleep(2000);

		By header = By.tagName("h1");
		String headerText = driver.findElement(header).getText();

		if (headerText.equals("Printed Chiffon Dress")) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
		driver.quit();
	}

}
