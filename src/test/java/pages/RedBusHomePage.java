package pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import managers.PropertyFileManager;
import tests.RedBusHomePageTest;
import utils.CommonFunctions;

public class RedBusHomePage {
	
	private static final Logger LOGGER= LoggerFactory.getLogger(RedBusHomePage.class);
	
	
	WebDriver driver;
	
	@FindBy(css="input#src")
	public WebElement searchFromDropDown;
	@FindBy(css="ul.autoFill>li")
	public List<WebElement> dropDownList;
	@FindBy(css="input#dest")
	public WebElement searchToDropDown;
	@FindBy(css="td[class='current day']")
	public WebElement selectDate;
	@FindBy(css="button#search_btn")
	public WebElement searchButton;
	/*@FindBy(css="div.error-view>h3")
	public WebElement errorOOPS_Message;*/
	@FindBy(xpath="//a[text()='redbus']")
	public WebElement logo;
	@FindBy(xpath="//i[@class='icon icon-close']")
	public WebElement  safetyPopup;
	@FindBy(xpath="(//div[text()='View Seats'])[1]")
	public WebElement viewSeat;
	@FindBy(xpath="//canvas[@data-type=\"lower\"]")
	public WebElement busCanvas;
	
	
	
	
	public RedBusHomePage( WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectCityFromDropDown() throws IOException
	{
		searchFromDropDown.sendKeys("kash");
		String fromvalue=PropertyFileManager.getPropertyValue("redBusHomePage","FromDropDownvalue");
		
		
		 for(WebElement e:dropDownList)
		 {
			if (e.getText().contains(fromvalue))
			{
				e.click();
			break;
		 }
		 }
		 LOGGER.info("Entering Kash in from dropdown");
	}
	public void selectCityToDropDown() throws IOException
	{
		searchToDropDown.sendKeys("Amr");
		
		
		String tovalue=PropertyFileManager.getPropertyValue("redBusHomePage","ToDropDownvalue");
		
		 for(WebElement e1:dropDownList)
		 {
			 if (e1.getText().equalsIgnoreCase(tovalue))
			 {
				 e1.click();
			 break;
		 }
		 }
		 LOGGER.info("Entering Amt in to dropdown");
	}
	
	public void dateSelect()
	{
		
		selectDate.click();
		 LOGGER.info("Entering today's date");
	}
	
	public void searchButtonClick()
	{
		searchButton.click();
		 LOGGER.info("Clicking on search button");
	}
/*public String errorMessageOnNoBusFound()
{
	return      errorOOPS_Message.getText();
}*/

public String getTitle() {
	
	return driver.getTitle();
	
}

public boolean RedBusLogoDisplay() {
	
	return logo.isDisplayed();
}

public void safetypop_up()

{
	safetyPopup.click();
}
public void scrollDown() {
	
	CommonFunctions.scrollWindow();
/*	JavascriptExecutor js =(JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,300)")*/;
	
}

public void clickViewSeat()
{
	viewSeat.click();
}
public void clickBusSeat() {

	CommonFunctions.mouseHover_Click(busCanvas,90,30);
	/*Actions act= new Actions(driver);
	act.moveToElement(busCanvas, 90,30).click().build().perform();*/
			
}


}
