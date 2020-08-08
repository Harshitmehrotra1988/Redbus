package reporting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import tests.RedBusHomePageTest;

public class ListenersImplementation  implements ITestListener{
	
	private static final Logger LOGGER= LoggerFactory.getLogger(ListenersImplementation.class);

	@Override
	public void onTestStart(ITestResult result) {
		LOGGER.info(result.getName()+"Test case started");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		LOGGER.info(result.getName()+"Testcase SUCCESS");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		LOGGER.info(result.getName()+"Testcase FAILURE");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		LOGGER.info(result.getName()+"Testcase SKIPPED");
		
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
