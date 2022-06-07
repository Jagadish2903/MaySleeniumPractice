package Basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClassicCRMPro {

	public static void main(String[] args) {

		BrowserUitil br = new BrowserUitil();
		WebDriver driver = br.initDriver("chrome");
		br.launchUrl("https://crmpro.com/index.html");
		ElementUtil ele = new ElementUtil(driver);

		// By header = By.xpath("//section[@id='details']//h3");
		//
		// List<WebElement> head = driver.findElements(header);
		// for(WebElement e:head) {
		// String text=e.getText();
		// System.out.println(text);
		// }
		System.out.println("==================================================");

		By links = By.xpath("//div[@id='navbar-collapse']//a");
		List<WebElement> linksheader = driver.findElements(links);
		for (WebElement e : linksheader) {
			String linktobeclicked = e.getText();
			System.out.println(linktobeclicked);
			if (linktobeclicked.trim().equals("Features")) {
				e.click();
				break;
			}
		}

	}

}
