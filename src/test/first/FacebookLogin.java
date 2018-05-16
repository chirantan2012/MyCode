package test.first;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class FacebookLogin 
{
	static WebElement webElement;
	public static void main(String args[]) throws InterruptedException
	{
		CharSequence elemnt[] = {"Lets party", "Hard", "9988774455", "hcjjs"};
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chrome\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		
		WebDriver chrome = new ChromeDriver(options);
		chrome.get("https://www.facebook.com");
		
		Thread.sleep(5000);
		chrome.findElement(By.id("u_0_k")).sendKeys(elemnt[0]);
		chrome.findElement(By.id("u_0_m")).sendKeys(elemnt[1]);
		chrome.findElement(By.id("u_0_p")).sendKeys(elemnt[2]);
		chrome.findElement(By.id("u_0_w")).sendKeys(elemnt[3]);
		
		webElement = chrome.findElement(By.id("day"));
		Select select = new Select(webElement);
		select.selectByVisibleText("20");
		Thread.sleep(2000);
		
		webElement = chrome.findElement(By.id("month"));
		select = new Select(webElement);
		select.selectByVisibleText("Mar");
		Thread.sleep(2000);
		
		chrome.findElement(By.name("sex")).click();
		chrome.findElement(By.id("u_0_12")).click();
		Thread.sleep(20000);
		
		String err = chrome.findElement(By.id("reg_error_inner")).getText();
		System.out.println(err);
		Assert.assertEquals(err, "Your password must be at least 6 characters long. Please try another.");
	}

}
