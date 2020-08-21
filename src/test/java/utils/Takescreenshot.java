package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import initiateTests.initClass;

public class Takescreenshot {

	public static void takescreen(String filename) throws IOException
	{
		 File scr=   ((TakesScreenshot) initClass.driver).getScreenshotAs(OutputType.FILE);
         File dest= new File("target\\"+filename+".jpg");
         FileUtils.copyFile(scr, dest);

	}
}

        	
        	
        	
        	

