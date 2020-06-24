package utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class proutilities {

	public static String capturescreenshot(WebDriver driver)
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String snapshotpath=System.getProperty("user.dir")+"/screenshots/"+currentdate()+".png";
		try {
			FileHandler.copy(src, new File(snapshotpath));
		} catch (IOException e) {
			System.out.println("screenshot error "+e.getMessage());
		}
		return snapshotpath;
	}
	public static String currentdate()
	{
		DateFormat customformat=new SimpleDateFormat("MM-dd-yyyy-HH-mm-ss");
		Date currentdates=new Date();
		return customformat.format(currentdates);
	}
}
