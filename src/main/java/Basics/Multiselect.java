package Basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Multiselect {
	static WebDriver driver;
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();

		driver.get("https://www.jqueryscript.net/demo/multi-select-tree/");

		System.out.println("The Current Url is " + driver.getCurrentUrl());

		By selectBox = By.xpath("//span[@class='custom-select treeSelector'][2]");

		driver.findElement(selectBox).click();

		By choices = By.xpath("//div[@class='treeSelection border'][2]//li[@class='no-sign']/label");
		
		multiSelect(choices, "AdMap","Google MAps");

	}

	public static void multiSelect(By locator, String...value){
		List<WebElement> choiceList = driver.findElements(locator);
		for(int i=0;i<choiceList.size();i++) {
			String text=choiceList.get(i).getText();
				System.out.println(text);
				for(int j=0;j<value.length;j++) {
					if(text.equals(value[j])) {
						choiceList.get(i).click();
						break;
					}

	}

		}
	}}
