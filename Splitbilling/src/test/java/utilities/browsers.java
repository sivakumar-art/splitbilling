package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class browsers {

	public static WebDriver startapp(WebDriver driver,String browser,String url)
	{
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browser.equals("IE"))
		{
			
		}
		else
		{
		System.out.println("browsers not supported");
		
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
	public static void quit(WebDriver driver)
	{
		driver.quit();
	}
}
