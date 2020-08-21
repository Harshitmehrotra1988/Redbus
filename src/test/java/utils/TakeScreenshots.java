package utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import reporting.ExtentManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TakeScreenshots{
	
	WebDriver driver;
    ExtentTest scenario;
	String testcaseName;
	
	public TakeScreenshots(ExtentTest scenario, WebDriver driver) {
		this.driver = driver;
        this.scenario = scenario;
	}
	
	public TakeScreenshots(WebDriver driver) {
        this.driver = driver;
    }

	public String TakeScreenshot() throws Exception{
		// fileName of the screenshot
		Date d=new Date();
		String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
		// take screenshot
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			// get the dynamic folder name
			FileUtils.copyFile(srcFile, new File(ExtentManager.screenshotFolderPath+screenshotFile));
			//put screenshot file in reports
			Thread.sleep(5000);
			//scenario.log(Status.FAIL,"Screenshot-> "+ scenario.addScreenCaptureFromPath(ExtentManager.screenshotFolderPath+screenshotFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return screenshotFile;
		
	}

}