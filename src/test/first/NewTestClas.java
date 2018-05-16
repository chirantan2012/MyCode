package test.first;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class NewTestClas 
{
	public static void main(String args[]) throws InterruptedException
	{
		CharSequence elemnt[] = {"Lets party", Keys.ENTER};
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chrome\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver chrome = new ChromeDriver(options);
		//chrome.navigate().to("https://www.google.com");
		//chrome.manage().window().maximize();
		chrome.get("https://www.google.com");
		chrome.findElement(By.id("lst-ib")).sendKeys(elemnt[0]);
		chrome.findElement(By.id("lst-ib")).sendKeys(elemnt[1]);
		chrome.manage().window().fullscreen();
		Thread.sleep(2000);
		chrome.quit();
		
		//open chrome different version from single system
		
		
	}
	

}
