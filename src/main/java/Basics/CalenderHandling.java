package Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalenderHandling {
	static WebDriver driver;

	public static void main(String[] args) {
		BrowserUitil br = new BrowserUitil();
		driver = br.initDriver("chrome");
		br.launchUrl("https://www.redbus.in/");

		// clicking calender
		driver.findElement(By.xpath("//span[@class='fl icon-calendar_icon-new icon-onward-calendar icon']")).click();

		By Currentday = By.xpath("//td[@class='current day']");

		WebElement Day = driver.findElement(By.xpath("//td[text()='30']"));

		String expMonth = "July 2027";

		String actualMonth = driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();
		// selectday("25");

//		while (!actualMonth.equalsIgnoreCase(expMonth)) {
//			driver.findElement(By.xpath("//td[@class='next']")).click();
//			actualMonth = driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();
//		}
		
		calenderHandling("32", "Nov 2023");

	}
	

	public static void selectday(String day) {
		driver.findElement(By.xpath("//td[text()='" + day + "']")).click();
		return;
	}
	
	
	public static void calenderHandling(String day,String expectedMonth) {
		if(Integer.parseInt(day)>31) {
			System.out.println("Please pass correct day");
			return;
		}if(expectedMonth.contains("Feb") && Integer.parseInt(day) >29) {
			System.out.println("Please pass correct day");
		}else {
		String actualMonth = driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();
		while (!actualMonth.equalsIgnoreCase(expectedMonth)) {
			driver.findElement(By.xpath("//td[@class='next']")).click();
			actualMonth = driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();
		}
		selectday(day);
		
	}}
	

}
