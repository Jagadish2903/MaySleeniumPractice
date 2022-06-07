package Basics;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pagination {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://meesho.com/");
		driver.findElement(By.xpath("// span[text()='Women Ethnic']")).click();
		driver.findElement(By.xpath("//a/p[text()='All Sarees']")).click();

		By nxtBtn = By.xpath("//div[@class='BaseButton__ButtonWrapper-sc-1e0kf5s-1 iNjsW']//span[text()='NEXT']");

		String expectedsaree = "https://meesho.com/aagyeyi-superior-sarees/p/1eyuw2";
		Thread.sleep(2000);

		By totallinks = By.xpath("//div[@class='sc-gsnTZi Grid__Row-sc-4ki5nk-0 gfMTeL WphYx products' ]//a");

		List<WebElement> total = driver.findElements(By.xpath("//div[@class='sc-gsnTZi Grid__Row-sc-4ki5nk-0 gfMTeL WphYx products' ]//a"));
		System.out.println("Total Products available in this page is :" + total.size());
		List<String> text = new ArrayList<String>();
		for(WebElement e:total) {
			String urls=e.getAttribute("href");	
			System.out.println(urls);
			text.add(urls);
		}
		while(!(text.contains(expectedsaree))) {
			driver.findElement(By.id("next")).click();
			Thread.sleep(1000);		
		}
		
		

	}
		
}

