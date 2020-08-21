package reporting;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import initiateTests.initClass;
import tests.RedBusHomePageTest;

public class ListenersImplementation  implements ITestListener{
	
	private static final Logger LOGGER= LoggerFactory.getLogger(ListenersImplementation.class);
	
	

	@Override
	public void onTestStart(ITestResult result) {
		//LOGGER.info(result.getName()+"Test case started");
		ReportingClass.initReports(result.getName());
	}	
	
	@Override
	public void onTestSuccess(ITestResult result) {
		LOGGER.info(result.getName()+"Testcase SUCCESS");
		ReportingClass.infoLogPass("===========>pass");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
	//	LOGGER.info(result.getName()+"Testcase FAILURE");
		
			try {
				ReportingClass.reportFailure("=============>Fail", initClass.driver);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	//	LOGGER.info(result.getName()+"Testcase SKIPPED");
	ReportingClass.infoLogSkip("============================>Skip");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
