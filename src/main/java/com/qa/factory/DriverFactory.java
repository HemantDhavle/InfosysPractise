package com.qa.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory 
{

	public WebDriver driver;
	public Properties prop;
	public static ThreadLocal<WebDriver> tl = new ThreadLocal<WebDriver>();
	
	public WebDriver getBrowser(Properties prop)
	{
		DriverOptions options = new DriverOptions(prop);
		String browser = prop.getProperty("browser");
		
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			tl.set(new ChromeDriver(options.chromeOption()));
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			tl.set(new FirefoxDriver(options.firefoxOption()));
		case "edge":
			WebDriverManager.edgedriver().setup();
			tl.set(new EdgeDriver(options.edgeOption()));
		default:
			System.out.println("Please pass the correct browser");
			break;
		}
		return getDriver();	
	}
	
	
	public synchronized WebDriver getDriver()
	{
			return tl.get();
	}

	public void getProperies()
	{
		FileInputStream fs = null;
		prop = new Properties();
		String envName = System.getProperty("env");
		try 
		{
		if(envName==null)
		{
				System.out.println("We are running on production");
				fs = new FileInputStream("./src/test/jave/resources/config/config.properties");	
		}
		else
		{
			System.out.println("We are running on envrionment "+envName);
			switch (envName) 
			{
			case "qa":
				fs = new FileInputStream("./src/test/jave/resources/config2/config.properties");
				break;
			default:
				System.out.println("Please pass the correct environment");
				break;
			}
		}
		}
		catch (FileNotFoundException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		try {
			prop.load(fs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getScreenshot()
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path =  System.getProperty("user.dir")+"/screenshot/"+System.currentTimeMillis()+".png";
		File des = new File(path);
		try {
			FileUtils.copyFile(src, des);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
		
	}
		



