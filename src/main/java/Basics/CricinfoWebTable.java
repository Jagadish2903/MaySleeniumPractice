package Basics;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CricinfoWebTable {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(
				"https://www.espncricinfo.com/series/charlotte-edwards-cup-2022-1298049/sunrisers-vs-central-sparks-group-b-1298068/full-scorecard");
		Thread.sleep(2000);
		String bowlerXpath = "//td[@class='ds-min-w-max ds-w-[20%]']//span[text()='Mady Villiers']";
		
		System.out.println(getBowlerstats("Kelly Castle"));
		

	}

	public static List<String> getBowlerstats(String bowlerName) {
	List<WebElement> bowlerstats=driver.findElements(By.xpath("//td[@class='ds-min-w-max ds-w-[20%]']//span[text()='"+bowlerName+"']/ancestor::td/following-sibling::td"));
	ArrayList<String> details=new ArrayList<String>();	
	for(WebElement e: bowlerstats) {
		String text=e.getText();
			details.add(text);
		}
		return details;
	}
}
