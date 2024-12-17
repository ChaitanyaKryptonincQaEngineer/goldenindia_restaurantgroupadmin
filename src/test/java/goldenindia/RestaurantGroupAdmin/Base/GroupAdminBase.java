package goldenindia.RestaurantGroupAdmin.Base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;

import goldenindia.RestaurantGroupAdmin.Utilities.CommonUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GroupAdminBase {

	public WebDriver driver;

	public GroupAdminBase() {

		if (CommonUtilities.driver == null) {
			driverIntialization();
		}
		this.driver = CommonUtilities.driver; // Use the initialized driver
	}

	public WebDriver driverIntialization() {
		String browserValue = CommonUtilities.gettingValueFromPropertyFile("browserName");

		switch (browserValue.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			CommonUtilities.driver = new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			CommonUtilities.driver = new EdgeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			CommonUtilities.driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Invalid browser value: " + browserValue);
			break;
		}

		if (CommonUtilities.driver != null) {
			CommonUtilities.driver.manage().window().maximize();
			CommonUtilities.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			CommonUtilities.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		}
		return CommonUtilities.driver;
	}

	public void deletePreviousFailureScreenshots(String currentTestName) {
		String reportsFolderPath = System.getProperty("user.dir") + "//screenshots//";
		File reportsFolder = new File(reportsFolderPath);

		if (reportsFolder.exists() && reportsFolder.isDirectory()) {
			File[] files = reportsFolder.listFiles();

			// Delete previous failure screenshots for the current test
			for (File file : files) {
				if (file.getName().startsWith(currentTestName) && file.getName().endsWith(".png")) {
					if (!file.delete()) {
						System.out.println("Failed to delete file: " + file.getName());
					}
				}
			}
		} else {
			System.out.println("Reports folder not found: " + reportsFolderPath);
		}
	}

	@AfterSuite(enabled = false, alwaysRun = true)
	public void tearDown() {
		if (CommonUtilities.driver != null) {
			CommonUtilities.driver.quit();
		}
	}

	// Screenshot Capture Logic with a null check for driver
	public String takingPageScreenShot(String methodName, WebDriver driver) {
		// Null check for driver
		if (driver == null) {
			System.err.println("Error: WebDriver is null. Screenshot cannot be captured.");
			return null;
		}

		String fileName = methodName + ".png";
		String screenshotDir = System.getProperty("user.dir") + "/screenshots/";

		// Create the directory if it doesn't exist
		File dir = new File(screenshotDir);
		if (!dir.exists()) {
			dir.mkdir(); // Create directory if it doesn't exist
		}

		String filePath = screenshotDir + fileName;
		try {
			// Take screenshot and store it in the specified file
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(filePath));
			System.out.println("Screenshot saved to: " + filePath);
			return filePath; // Return the path to the screenshot
		} catch (IOException e) {
			System.err.println("Failed to capture screenshot: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
}
