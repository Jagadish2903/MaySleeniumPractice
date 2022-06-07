package Basics;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.helper.HttpConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.com/");

		List<WebElement> linksList = driver.findElements(By.tagName("a"));
		System.out.println("Number of links available in this page is " + linksList.size());

		List<String> urlList = new ArrayList<String>();

		for (int i = 0; i < linksList.size(); i++) {
			String urltext = linksList.get(i).getAttribute("href");
			urlList.add(urltext);
		}
		long strTime = System.currentTimeMillis();
		urlList.parallelStream().forEach(e -> checkBrokenLinks(e));
		long EndTime = System.currentTimeMillis();
		System.out.println("Total Time Taken" + ( EndTime - strTime));
		driver.quit();

	}

	public static void checkBrokenLinks(String linksurl) {
		try {
			URL url = new URL(linksurl);
			HttpURLConnection httpconnect = (HttpURLConnection) url.openConnection();
			httpconnect.setConnectTimeout(1000);
			httpconnect.connect();
			if (httpconnect.getResponseCode() >= 400) {
				System.out.println(linksurl + " ---->" + httpconnect.getResponseMessage() + " This is a broken Link");
			} else {
				System.out.println(linksurl + " ---->" + httpconnect.getResponseMessage());
			}

		} catch (Exception e) {

		}
	}
}