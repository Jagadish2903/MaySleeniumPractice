package Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowser {
		static WebDriver driver;
		
 
	public static void main(String[] args) {

		String browser = "firefox";

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
		} else {
			System.out.println("Please pass the correct browser");
		}

		driver.get("https://www.amazon.com/");

		String title = driver.getTitle();
		System.out.println(title);

		String pgSource = driver.getPageSource();
		//System.out.println(pgSource);
		
		
		String curUrl = driver.getCurrentUrl();
		System.out.println(curUrl);

		 driver.quit();//Close all the window in the browser and session id gets ended.
		//driver.close();// close the Currentbwindow in the browser and session id remains active

		
	}

}
