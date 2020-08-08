package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import initiateTests.initClass;

public class CommonFunctions {
	static Actions act;
	static JavascriptExecutor js ;
	public static void mouseHover_Click(WebElement ele, int x, int y) {
		act= new Actions(initClass.driver);
		act.moveToElement(ele, x, y).click().build().perform();
		
	}
	public static void mouseHover( WebElement ele) {
		act= new Actions(initClass.driver);
		act.moveToElement(ele).build().perform();
		
	}
	public static void scrollWindow() {
		JavascriptExecutor js =(JavascriptExecutor)initClass.driver;
		js.executeScript("window.scrollBy(0,300)");
		
	}
	
	

}
