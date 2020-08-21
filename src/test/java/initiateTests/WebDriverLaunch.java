package initiateTests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import managers.PropertyFileManager;



public class WebDriverLaunch {
	
	private static final Logger LOGGER= LoggerFactory.getLogger(WebDriverLaunch.class);
	
    static WebDriver driver;

	public static WebDriver getWindowDriver() throws IOException
	{
		
	
	//String browserVariable=System.getenv("browserName");
	String browserVariable=PropertyFileManager.getPropertyValue("config","browser");
	if (browserVariable.equalsIgnoreCase("Chrome"))
	{
	ChromeOptions opt = new ChromeOptions();
	opt.addArguments("--disable-notifications");
System.setProperty("webdriver.chrome.driver","src\\test\\resources\\drivers\\chromedriver_windows.exe");

 driver = new ChromeDriver(opt);
 LOGGER.info("Lauching chrome browser");
	}
	else if (browserVariable.equalsIgnoreCase("FireFox"))
	{
		FirefoxOptions opt= new FirefoxOptions();
		opt.addPreference("dom.webnotifications.enabled", false);
		System.setProperty("webdriver.gecko.driver","src\\test\\resources\\drivers\\geckodriver.exe");
		
		 driver = new FirefoxDriver(opt);
		 LOGGER.info("Lauching Firefox browser");
	}
	else
	{
		System.out.println("No Browser specified");
	}
driver.manage().window().maximize();


driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);
return driver;

}
}
