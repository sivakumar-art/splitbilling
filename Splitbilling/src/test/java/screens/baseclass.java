package screens;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utilities.browsers;
import utilities.configuration;
import utilities.datafromexcel;
import utilities.proutilities;

public class baseclass {
   public WebDriver driver;
   public datafromexcel excel;
   public configuration config;
   public ExtentReports report;
   public ExtentTest logger;
@BeforeSuite
   public void setupsuite()
   {
	excel=new datafromexcel();
	config=new configuration();
	ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/reports/340B-"+proutilities.currentdate()+".html"));
	report=new ExtentReports();
	report.attachReporter(extent);
   }
	@BeforeClass
	public void startbrowser()
	{
		driver=browsers.startapp(driver,config.browserget(),config.urlget());
	}
	@AfterClass
	public void quitbrowsers()
	{
		browsers.quit(driver);
	}
	@AfterMethod
	public void screenshot(ITestResult results) throws Exception
	{
		Thread.sleep(15000);
		if(results.getStatus()==ITestResult.FAILURE)
		{
			logger.fail("test failed", MediaEntityBuilder.createScreenCaptureFromPath(proutilities.capturescreenshot(driver)).build());
		}
		else if(results.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("test passed", MediaEntityBuilder.createScreenCaptureFromPath(proutilities.capturescreenshot(driver)).build());
		}
		else
		System.out.println("screenshot not cacptured");
		report.flush();
	}
}
