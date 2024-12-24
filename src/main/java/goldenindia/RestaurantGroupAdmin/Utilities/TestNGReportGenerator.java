package goldenindia.RestaurantGroupAdmin.Utilities;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestNGReportGenerator {

	public static ExtentReports extent;
	public static ExtentSparkReporter report;

	public static ExtentReports reportGenerating() {

		// Specify the exact report file path (e.g., Reports/Report.html)
		String reportPath = System.getProperty("user.dir") + "//Reports";
		report = new ExtentSparkReporter(reportPath);
		report.config().setDocumentTitle("Test Report");
		report.config().setReportName("Bug Report Version 1.0");

		extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("FE", "Krunal Prajapathi");
		extent.setSystemInfo("BE", "Bhavik Paun");
		extent.setSystemInfo("Chrome", "Version 1");

		return extent;
	}
}
