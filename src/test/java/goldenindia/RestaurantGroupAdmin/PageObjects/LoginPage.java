package goldenindia.RestaurantGroupAdmin.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import goldenindia.RestaurantGroupAdmin.Utilities.CommonUtilities;

public class LoginPage {
	
	// Locate the email input field
	@FindBy(css = "[name=\"email\"]")
	WebElement resEmail;

	// Locate the password input field
	@FindBy(css = "[type=\"password\"]")
	WebElement resPassword;

	// Locate the login button
	@FindBy(css = "[class*=\"mb-5\"]")
	WebElement resLoginButton;

	// Constructor for the LoginPage class
	public LoginPage(WebDriver driver) {
		// Initialize WebElements using PageFactory

		CommonUtilities.driver = driver;
		PageFactory.initElements(driver, this);
		// Print the status of the WebDriver instance
		System.out.println("Driver Status " + driver);
	}

	// Method to enter login details
	public void enteringLoginDetails(String email, String password) {
		// Enter the email address
		resEmail.sendKeys(email);
		// Enter the password
		resPassword.sendKeys(password);
	}

	// Method to submit the login details
	public void submittingLoginDetails() {
		// Click the login button
		resLoginButton.click();

	}

	// Method to navigate to the login URL
	public void gotoURL() {
		// Navigate to the specified URL
		CommonUtilities.driver.get("http://resgroup.mypreview.xyz/");
	}
}
