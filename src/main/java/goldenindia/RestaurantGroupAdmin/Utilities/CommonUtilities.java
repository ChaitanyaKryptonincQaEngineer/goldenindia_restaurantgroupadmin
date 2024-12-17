package goldenindia.RestaurantGroupAdmin.Utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtilities {

	

	public static WebDriver driver;

	public static JavascriptExecutor js;
	
	public CommonUtilities(WebDriver driver) {
        CommonUtilities.driver = driver;
        PageFactory.initElements(driver, this);  // Initialize elements
    }


	public static String gettingValueFromPropertyFile(String str) {
		Properties prop = new Properties();
		try (FileInputStream in = new FileInputStream(new File(System.getProperty("user.dir")
				+ "/src/test/java/goldenindia/RestaurantGroupAdmin/TestData/RGA.properties"))) {
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty(str);
	}

	public static JavascriptExecutor javascriptExecutor() {
		return js = (JavascriptExecutor) driver;

	}

	public static String gettingValueFromFile() throws IOException {
		// TODO Auto-generated method stub

		String file = System.getProperty("user.dir")
				+ "/src/test/java/goldenindia/RestaurantGroupAdmin/TestData/RestaurantGroupAdmin.txt";

		FileInputStream in = new FileInputStream(file);
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));

		// Read the first line from the file
		String infileValue = reader.readLine();
		System.out.println("Before increment: " + infileValue); 

		// Check if the line is not null
		if (infileValue != null && !infileValue.trim().isEmpty()) {
			// Parse the line to an integer
			int incrementValue = Integer.parseInt(infileValue.trim());

			// Increment the value
			int incrementedValue = incrementValue + 1;
			System.out.println("After increment: " + incrementedValue);

			FileOutputStream out = new FileOutputStream(file);
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
			Integer.toString(incrementedValue);
			writer.flush();
			writer.write(Integer.toString(incrementedValue));
			writer.close();
			reader.close();

			// TODO: Write the incremented value back to the file (not shown here)
		} else {
			System.out.println("File is empty or does not contain a valid integer.");
		}

		return infileValue;
	}

	public static void waitingTillVisibilityOfElement(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public static void waitingTillVisibilityOfElements(List<WebElement> ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElements(ele));
	}
	
}
