package screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginapp {
WebDriver driver;
	public loginapp( WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	public  void loginapplication(String username,String password)
	{
		driver.findElement(By.xpath("//input[@id='Input_Username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='Input_Password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Login']")).click();
	}
	
}
