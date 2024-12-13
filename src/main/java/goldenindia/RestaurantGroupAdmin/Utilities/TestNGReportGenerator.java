package goldenindia.RestaurantGroupAdmin.Utilities;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestNGReportGenerator {

	public static ExtentReports reportGenerating() {

		File file = new File(System.getProperty("user.dir") + "//Reports");
		ExtentSparkReporter report = new ExtentSparkReporter(file);
		report.config().setDocumentTitle("Test Report");
		report.config().setReportName("Bug Report Vesion 1.0");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("FE", "Krunal Prajapathi");
		extent.setSystemInfo("BE", "Bhavik Paun");
		extent.setSystemInfo("Chrome", "Version 1");

		return extent;
	}
}
