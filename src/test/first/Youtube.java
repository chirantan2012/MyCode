package test.first;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Youtube 
{
	static WebElement elements[];
	public static void main(String args[]) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chrome\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		
		WebDriver chrome = new ChromeDriver(options);
		chrome.get("https://www.youtube.com");
		Thread.sleep(15000);
		
		List<WebElement> elements = chrome.findElements(By.xpath("//div[@id='meta']//h3//a"));
		WebElement element[] = new WebElement[elements.size()];
		for (int i = 0; i < element.length; i++) {
			element[i] = elements.get(i);
			System.out.println(element[i].getText());
		}
		
			//chrome.close();
	}

}
