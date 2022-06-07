package Basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonJhumkaTest {

	public static void main(String[] args) throws InterruptedException {
		BrowserUitil br = new BrowserUitil();
		WebDriver driver = br.initDriver("chrome");
		br.launchUrl("https://www.amazon.com/");
		driver.manage().window().maximize();

		ElementUtil ele = new ElementUtil(driver);
		By searchBox = By.id("nav-search-bar-form");

		ele.doActionSendKeys(searchBox, "Jh");
		Thread.sleep(2000);

		By earrRingsearch = By.xpath("//span[text()='umka earrings for women']");

		ele.doClick(earrRingsearch);

		By Jumka = By.xpath(
				"//span[text()='Crunchy Fashion Bollywood Style Traditional Indian Oxidised Silver Jewelry Jhumki Jhumka Earrings for Women/Girls']");

		ele.doClick(Jumka);
		Thread.sleep(2000);

		By add2Cart = By.name("submit.add-to-cart");
		ele.doClick(add2Cart);
		System.out.println("The Product is added to the cart");

		By goCart = By.linkText("Go to Cart");

		String productname = "Crunchy Fashion Bollywood Style Traditional Indian Oxidised Silver Jewelry Long Jhumki Jhumka Earrings for Women/Girls";
		ele.doClick(goCart);
		Thread.sleep(1000);

		String value = "Silver-Pink";
		List<WebElement> ring = driver.findElements(By.xpath("//span[@class='a-list-item']/span"));
		for (WebElement e : ring) {
			String status = e.getText();
			if (status.contains(value)) {
				System.out.println(
						"Congrats your Earring is added to the cart ..BUT,PLEASE DONT BUY YOUR HUSBAND IS IN TROUBLE");
				break;
			} else {
				System.out.println("checking status");
			}
		}
		driver.quit();
	}
}
