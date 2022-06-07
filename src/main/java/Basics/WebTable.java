package Basics;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get(
				"https://www.espncricinfo.com/series/charlotte-edwards-cup-2022-1298049/sunrisers-vs-central-sparks-group-b-1298068/full-scorecard");

		Thread.sleep(2000);
		
		//String batsmanXpath="//span[@class='ds-text-tight-s ds-font-medium']/span[text()='Eve Jones']";
		System.out.println(getWicketTakerName("Eve Jones"));
		System.out.println(getBatsmanStats("Eve Jones"));
		
		System.out.println(getWicketTakerName("Amy Jones"));
		System.out.println(getBatsmanStats("Amy Jones"));
		
	}
	
	
	public static String getWicketTakerName(String batsman) {
		String wicketTakerXpath="(//span[@class='ds-text-tight-s ds-font-medium']/span[text()='"+batsman+"']/ancestor::td/following-sibling::td)[1]";
		String wicketTaker =driver.findElement(By.xpath(wicketTakerXpath)).getText();
		return wicketTaker;
	}
	
	public static List<String> getBatsmanStats(String batsman) {
		String stats="(//span[@class='ds-text-tight-s ds-font-medium']/span[text()='"+batsman+"']/ancestor::td/following-sibling::td)";
		List<WebElement> ele=driver.findElements(By.xpath(stats));
		ArrayList<String> scoreList=new ArrayList<String>();
		for(int i=1;i<ele.size();i++) {
			String batsmanstats=ele.get(i).getText();
			scoreList.add(batsmanstats);	
		}
		return scoreList;
	}
}
