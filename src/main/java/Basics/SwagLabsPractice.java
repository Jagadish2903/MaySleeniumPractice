package Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SwagLabsPractice {
     
	public static void main(String[] args) {
		BrowserUitil br=new BrowserUitil();
		
	
		WebDriver driver=br.initDriver("chrome");
		br.launchUrl("https://www.saucedemo.com/");
		System.out.println(br.getTitle());
		
		ElementUtil ele=new ElementUtil(driver);
		
		//Username locator
		By username=By.id("user-name");
		By pwd=By.id("password");
		By clickbtn=By.id("login-button");
		
		ele.doSendKeys(username, "standard_user");
		ele.doSendKeys(pwd, "secret_sauce");
		ele.doClick(clickbtn);
		
		
		
		
		
		
		
	}

}
