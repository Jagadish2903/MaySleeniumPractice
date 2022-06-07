package Basics;

import javax.swing.text.Document;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScript {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://automationpractice.com/index.php");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String text = js.executeScript("return document.title;").toString();
		System.out.println(text);
		
	}

}
