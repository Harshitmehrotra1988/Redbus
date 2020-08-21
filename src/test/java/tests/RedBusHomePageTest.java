package tests;



import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import initiateTests.initClass;
import pages.RedBusHomePage;
import utils.Takescreenshot;

//@Listeners(reporting.ListenersImplementation.class)
public class RedBusHomePageTest extends initClass{
	
	
	private static final Logger LOGGER= LoggerFactory.getLogger(RedBusHomePageTest.class);
	//WebDriver driver;

	
	@Test
public void bookTicketForRedBus() throws IOException, InterruptedException
{	
	LOGGER.info("Running testcase bookTicketForRedBus");
    homePage.selectCityFromDropDown();
	homePage.selectCityToDropDown();
	homePage.dateSelect();
	homePage.searchButtonClick();
	//homePage.safetypop_up();
	//Thread.sleep(3000);
	//homePage.scrollDown();
	//homePage.clickViewSeat();
	//homePage.clickBusSeat();


	
	// Assert.assertEquals(homePage.errorMessageOnNoBusFound(),"Oops! No buses found.");
	 
	 }
	@Test
	public void checkTitle() throws IOException
	
	{	LOGGER.info("Running testcase checkTitle");
		Assert.assertEquals(homePage.getTitle(),"ook Bus Travels, AC Volvo Bus, rPool & Bus Hire - redBus India");
		Takescreenshot.takescreen("checkTitle");
	}
	
	@Test
	public void checkLogoOfHomePage() throws IOException
	{ 
		throw new SkipException("implementation not done");
	
		//Assert.assertTrue(homePage.RedBusLogoDisplay(), "Logo is not displayed");
	
	}
}
