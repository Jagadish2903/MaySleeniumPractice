package Basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SpecificLinks {


	public static void main(String[] args) {

		BrowserUitil br = new BrowserUitil();
		WebDriver driver = br.initDriver("chrome");
		br.launchUrl("https://www.google.com/");
		ElementUtil ele = new ElementUtil(driver);
		
		
		By TotalLinks=By.xpath("//div[@id='SIvCob']/a");
		
		List<WebElement> ttl=driver.findElements(TotalLinks);
		
		for(WebElement e:ttl) {
			String links=e.getAttribute("href");
			System.out.println(links);
			
			System.out.println("===================================");
			String text=e.getText();
			System.out.println(text);
			
		}

	}

}
