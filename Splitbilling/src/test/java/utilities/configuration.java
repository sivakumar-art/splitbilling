package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configuration {
Properties pro;
	public configuration()
	{
		File src=new File("./configuration/config.properties");
			try {
				FileInputStream fis=new FileInputStream(src);
				pro= new Properties();
				pro.load(fis);
			} catch (IOException e) {
				System.out.println("config error"+e.getMessage());
	
	}}
	public String browserget()
	{
		return pro.getProperty("browser");
	}
	public String urlget()
	{
		return pro.getProperty("preprodurl");
	}
}
