package com.spicejetProject.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


import com.beust.jcommander.Parameter;
import com.spicejetProject.utilities.ReadConfig;

public class BaseClass {

	public static WebDriver driver;
	ReadConfig RC = new ReadConfig();
	public String URL = RC.getBaseURL();
	public String UN = RC.getUserName();
	public String pwd = RC.getPassword();
	public String name = RC.getName();
	public Logger logger;
	
	@Parameters("browser")
	@BeforeTest
	public void setUp(String br)
	{	
		logger = Logger.getLogger("spicejet");
		PropertyConfigurator.configure("Log4j2.properties");
		
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", RC.getChomePath());
			driver = new ChromeDriver();
		}
		
		if(br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", RC.getIEPath());
			driver = new InternetExplorerDriver();
		}
		
		if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", RC.getfirefoxPath());
			driver = new FirefoxDriver();
		}
		driver.get(URL);
		logger.info("URL opened");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public static void driverWait(WebElement w,long t)
	{
		WebDriverWait wait = new WebDriverWait(driver,t);
		wait.until(ExpectedConditions.visibilityOf(w));
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreen(String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
}
