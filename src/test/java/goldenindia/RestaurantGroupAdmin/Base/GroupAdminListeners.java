package goldenindia.RestaurantGroupAdmin.Base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import goldenindia.RestaurantGroupAdmin.Utilities.CommonUtilities;
import goldenindia.RestaurantGroupAdmin.Utilities.TestNGReportGenerator;

public class GroupAdminListeners extends GroupAdminBase implements ITestListener {

	ExtentTest test;
	private ExtentReports extent = TestNGReportGenerator.reportGenerating();
	// Using ThreadLocal to manage ExtentTest for parallel tests
	private ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	@Override
	public void onTestStart(ITestResult result) {
		deletePreviousFailureScreenshots(result.getMethod().getMethodName());
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test); // Set the ExtentTest instance in ThreadLocal
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logTestResult(result, Status.PASS, "Test Passed");

		
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String filePath = null;
		filePath = takingPageScreenShot(result.getMethod().getMethodName(), driver);
		test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());

	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test failed: " + result.getName());
		test.fail(result.getThrowable());
		WebDriver driver = CommonUtilities.driver;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String filePath = null;
		filePath = takingPageScreenShot(result.getMethod().getMethodName(), driver);
		test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test skipped: " + result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// Optional for success percentage tracking
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test suite started: " + context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test suite finished: " + context.getName());
		extent.flush();
	}

	private void logTestResult(ITestResult result, Status status, String message) {
		System.out.println(message + ": " + result.getName());
		ExtentTest test = extentTest.get(); // Retrieve the ExtentTest instance from ThreadLocal
		if (test != null) {
			test.log(status, message);
			// Attempt to retrieve driver and capture screenshot
			captureScreenshot(result);
		}

	}

	private String captureScreenshot(ITestResult result) {
		try {
			// Use CommonUtilities.driver instead of reflection
			WebDriver driver = CommonUtilities.driver;
			return takingPageScreenShot(result.getMethod().getMethodName(), driver);
		} catch (Exception e) {
			System.err.println("Error capturing screenshot for test: " + result.getName());
			e.printStackTrace();
			return null;
		}
	}
}
