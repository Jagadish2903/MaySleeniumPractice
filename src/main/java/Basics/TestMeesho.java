package Basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Sleeper;

public class TestMeesho {

	public static void main(String[] args) throws InterruptedException {

		BrowserUitil br = new BrowserUitil();
		WebDriver driver = br.initDriver("chrome");
		br.launchUrl("https://meesho.com/");
		ElementUtil ele = new ElementUtil(driver);
		//driver.manage().window().maximize();
		
		By Womenbutton= By.xpath("//span[text()='Women Ethnic']");
		ele.doClick(Womenbutton);
		
		By kurtis=By.xpath("//p[text()='Anarkali Kurtis']");
		ele.doLinkClick(kurtis, "Anarkali Kurtis");
		
		By totalcount=By.xpath("//p[text()='Banita Graceful Kurtis']");
		Thread.sleep(2000);
			
		ele.doClick(totalcount);
		
		
		
	}
}
