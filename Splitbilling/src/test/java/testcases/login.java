package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import screens.baseclass;
import screens.loginapp;

public class login extends baseclass{
	@Test
	public void loginapp()
	{
		logger=report.createTest("test case created");
		loginapp loginapp=PageFactory.initElements(driver, loginapp.class);
		logger.info("login application");
		loginapp.loginapplication(excel.stringdata(0, 1, 0), excel.stringdata(0, 1, 1));
		logger.pass("login successfully");
	}
} 
