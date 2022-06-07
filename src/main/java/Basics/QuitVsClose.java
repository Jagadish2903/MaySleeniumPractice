package Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class QuitVsClose {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.com/");
		
		String title = driver.getTitle();
		System.out.println(title);

	

		String pgSource = driver.getPageSource();
		System.out.println(pgSource);
		//driver.quit();//Close all the window in the browser and session id gets ended.
		driver.close();//close the Currentbwindow in the browser and session id remains active
		
		String curUrl = driver.getCurrentUrl();
		System.out.println(curUrl);

	}

}
