package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BusHirePage {
	
	
	
	@FindBy(xpath="//a[@id='redBus Bus Hire']")
	WebElement busHireTab;
	
	
	WebDriver driver;
	
	public BusHirePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickBusHire()
	{
		busHireTab.click();
	}

}
