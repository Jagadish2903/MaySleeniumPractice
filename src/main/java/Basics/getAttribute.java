package Basics;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class getAttribute {

	public static void main(String[] args) {

		BrowserUitil br = new BrowserUitil();
		WebDriver driver = br.initDriver("chrome");
		br.launchUrl("https://www.amazon.com/");
		ElementUtil ele = new ElementUtil(driver);

		// By links=By.partialLinkText("Today's");
		// String sam=ele.doGetAttributeValue(links, "href");
		// System.out.println(sam);
		// System.out.println("=============================================================");

		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total links in the page is " + links.size());
		// Using for Loop
		for (int i = 0; i < links.size(); i++) {
			String lnk = links.get(i).getAttribute("href");
			String lnkText = links.get(i).getText();
			System.out.println(lnk);
			System.out.println(lnkText);

		}

		// using forEach
		for (WebElement e : links) {
			String s = e.getAttribute("href");
			System.out.println(s);
			String d = e.getText();
			System.out.println(d);
		}

	}

}
