package test.first;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGTest 
{
	
	@BeforeMethod
	public void bfrMthd()
	{
		System.out.println("Im in BM");
	}

	@Test
	public void testing() throws InterruptedException
	{
		System.out.println("Running Test");
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chrome\\chromedriver.exe");

		WebDriver chrome = new ChromeDriver();
		chrome.get("https://www.facebook.com");
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void afrMthd()
	{
		System.out.println("Im in AM");
		
		
	}
	
}
