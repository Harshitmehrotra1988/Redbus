package initiateTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;

import managers.PropertyFileManager;
import pages.BusHirePage;
import pages.RedBusHomePage;
import reporting.ExtentManager;
import reporting.ReportingClass;
import tests.RedBusHomePageTest;

public class initClass {
	

	
	private static final Logger LOGGER= LoggerFactory.getLogger(initClass.class);
	
	public static WebDriver driver;
	protected static RedBusHomePage homePage;
	protected static BusHirePage busHirePage;
	public static ExtentReports report;

	@BeforeClass
	public void launchDriver() throws IOException
	{
		
		//This is update done in SReporting branch
	 driver=WebDriverLaunch.getWindowDriver();
	 
	 createObjects();
	 report= ExtentManager.setUp("Extent_Reports");
	}
	
	public static void createObjects()
	{
		LOGGER.info("Created Objects of Pages");
		 homePage= new RedBusHomePage(driver);
		 busHirePage = new BusHirePage(driver);	
	}
	
	@BeforeMethod
	public void launchURL()
	{
		driver.get("https://www.redbus.in/");
		 LOGGER.info("Lauching  RedBus URL");
	}
	@AfterClass
	public void closeDriver()
	
	{
			driver.close();
			ReportingClass.putReport();
	}
}
