package goldenindia.RestaurantGroupAdmin.PageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import goldenindia.RestaurantGroupAdmin.TestData.restaurantTestData;
import goldenindia.RestaurantGroupAdmin.Utilities.CommonUtilities;

public class BranchesPage {

	Actions action = new Actions(CommonUtilities.driver);

	@FindBy(id = "section-2")
	private WebElement branches;

	@FindBy(css = "[class*=\"btn-primary\"]")
	private WebElement addBranchBtn;

	@FindBy(css = "[placeholder=\"Search Places ...\"]")
	private WebElement branchLocationField;

	@FindBy(css = "[placeholder=\"Branch Name EN\"]")
	private WebElement branchNameField;

	@FindBy(css = "[placeholder=\"Branch email\"]")
	private WebElement branchEmail;

	@FindBy(css = "[placeholder=\"Branch Phone Number\"]")
	private WebElement branchPhoneNumber;

	@FindBy(css = "[placeholder=\"Branch Sequence No\"]")
	private WebElement branchSequenceNumber;

	@FindBy(xpath = "(//input[@value=\"English\"])[1]")
	private WebElement englishSelectionOption;

	@FindBy(xpath = "(//input[@value=\"English\"])[2]")
	private WebElement englishPrimaryOption;

	@FindBy(css = "[placeholder=\"Enter VAT number\"]")
	private WebElement branchVATNumber;

	@FindBy(css = "[placeholder=\"Manager Name\"]")
	private WebElement branchManagerName;

	@FindBy(css = "[placeholder=\"Phone Number\"]")
	private WebElement branchManagerPhoneNumber;

	@FindBy(css = "[placeholder=\"Email\"]")
	private WebElement branchManagerEmail;

	@FindBy(css = "[placeholder=\"Password\"]")
	private WebElement branchManagerPassword;

	@FindBy(xpath = "(//div[@class=\" css-ackcql\"])[1]")
	private WebElement branchTimeZone;

	@FindBy(xpath = "(//div[@class=\" css-ackcql\"])[2]")
	private WebElement branchCurrency;

	@FindBy(xpath = "(//input[@type=\"file\"])[2]")
	private WebElement branchTermsAndConditionsDocument;

	@FindBy(id = "kt_modal_new_address_submit")
	private WebElement branchSubmittingDetails;

	@FindBy(xpath = "//table/tbody/tr/td[2]")
	private List<WebElement> branchNames;

	@FindBy(xpath = "//table/tbody/tr/td[10]/div/button[1]")
	private List<WebElement> branchViewOption;

	@FindBy(xpath = "(//li[@class=\"nav-item\"])[2]")
	private WebElement tableListBar;

	@FindBy(xpath = "(//li[@class=\"nav-item\"])[3]")
	private WebElement userListBar;

	@FindBy(xpath = "//a[@data-bs-toggle=\"modal\"]")
	private WebElement createTablesBtn;

	@FindBy(css = "[placeholder=\"Number of tables\"]")
	private WebElement numberOfTablesEntry;

	@FindBy(id = "kt_modal_new_address_submit")
	private WebElement tablesConfirmationBtn;

	@FindBy(css = "[placeholder=\"Table Number\"]")
	private List<WebElement> tableNumbersValue;

	@FindBy(id = "kt_modal_new_address_submit")
	private WebElement tablesSaveBtn;

	@FindBy(xpath = "//table/tbody/tr/td[2]")
	private List<WebElement> existedTableNumbers;

	@FindBy(xpath = "//span[contains(text(),'chevron_right')]")
	private WebElement pageChangeBtn;

	@FindBy(xpath = "//button[contains(text(),'Add Manager')]")
	private WebElement addManagerBtn;

	@FindBy(css = "[placeholder='Manager Name']")
	private WebElement managerNameInput;

	@FindBy(css = "[placeholder='Phone Number']")
	private WebElement phoneNumberInput;

	@FindBy(css = "[placeholder='Email']")
	private WebElement emailInput;

	@FindBy(css = "[placeholder='Password']")
	private WebElement passwordInput;

	@FindBy(id = "kt_modal_new_address_submit")
	private WebElement detailsSubmitBtn;

	@FindBy(xpath = "(//table/tbody)[1]/tr/td[2]")
	public List<WebElement> createdbranchManagers;

	@FindBy(xpath = "//button[contains(text(),'Add Staff')]")
	private WebElement addKitchenStaffBtn;

	@FindBy(css = "[placeholder=\"Satff Name\"]")
	private WebElement kitchenStaffInput;

	@FindBy(xpath = "//button[contains(text(),'Add Service Staff')]")
	private WebElement addServiceStaffBtn;

	@FindBy(css = "[placeholder=\"Service Staff Name\"]")
	private WebElement serviceStaffInput;

	@FindBy(xpath = "(//table/tbody)[2]/tr/td[2]")
	public List<WebElement> createdBranchKitchenStaff;

	@FindBy(xpath = "(//table/tbody)[3]/tr/td[2]")
	public List<WebElement> createdBranchServiceStaff;

	@FindBy(xpath = "(//span[contains(text(),'chevron_right')])[1]")
	public WebElement managerNextPageBtn;

	@FindBy(xpath = "(//span[contains(text(),'chevron_right')])[2]")
	public WebElement kitchenStaffNextPageBtn;

	@FindBy(xpath = "(//span[contains(text(),'chevron_right')])[3]")
	public WebElement serviceStaffNextPageBtn;

	@FindBy(css = "[placeholder=\"Pin Code\"]")
	public WebElement serviceStaffPincodeInput;

	public boolean userClickCheck = false;

	restaurantTestData testData = new restaurantTestData();
	JavascriptExecutor js = (JavascriptExecutor) CommonUtilities.driver;

	public BranchesPage(WebDriver driver) {
		CommonUtilities.driver = driver;
		PageFactory.initElements(CommonUtilities.driver, this);
		System.out.println("Branches Driver" + CommonUtilities.driver);
	}

	public void clickingOnBranchesIcon() throws InterruptedException {
		System.out.println("You are clicking on the branch Icon");
		try {
			branches.click();
		} catch (Exception e) {
			branches = CommonUtilities.driver.findElement(By.id("section-2"));
			branches.click();
		}

	}

	public void addingBranchDetails() throws InterruptedException, IOException {
		WebDriverWait wait = new WebDriverWait(CommonUtilities.driver, Duration.ofSeconds(10));
		clickingOnBranchesIcon();

		addBranchBtn.click();
		System.out.println("You are adding the new branch...!");
		branchLocationField.sendKeys(testData.gettingRandomAddress());

		action.keyDown(Keys.ENTER).build().perform();
		Thread.sleep(1000);
		action.keyUp(Keys.ENTER).build().perform();

		Thread.sleep(1000);
		System.out.println("Branch Location " + testData.gettingRandomAddress());
		branchNameField.sendKeys(testData.gettingRandomName());
		String branchName = branchNameField.getAttribute("value"); // Capture the branch name
		Thread.sleep(1000);
		System.out.println("Sequence number of the branch is " + CommonUtilities.gettingValueFromFile());
		branchSequenceNumber.sendKeys(CommonUtilities.gettingValueFromFile());
		branchEmail.sendKeys(testData.gettingRandomEmail());
		branchPhoneNumber.sendKeys(testData.gettingRandomPhoneNumber());

		englishSelectionOption.click();
		englishPrimaryOption.click();
		branchVATNumber.sendKeys(testData.gettingRandomPhoneNumber());
		branchManagerName.sendKeys(testData.gettingRandomName());
		branchManagerPhoneNumber.sendKeys(testData.gettingRandomPhoneNumber());
		branchManagerEmail.sendKeys(testData.gettingRandomEmail());
		branchManagerPassword.sendKeys(testData.gettingRandomPhoneNumber());
		branchTimeZone.click();

		action.keyDown(Keys.ENTER).build().perform();
		action.keyUp(Keys.ENTER).build().perform();

		branchCurrency.click();

		action.keyDown(Keys.ENTER).build().perform();
		action.keyUp(Keys.ENTER).build().perform();

		Thread.sleep(2000);

		branchTermsAndConditionsDocument.sendKeys(System.getProperty("user.dir")
				+ "/src/main/java/goldenindia/RestaurantGroupAdmin/Utilities/sample.pdf");

		Thread.sleep(2000);
		branchSubmittingDetails.click();

	}

	public void creatingTables() throws InterruptedException, IOException {

		WebDriverWait wait = new WebDriverWait(CommonUtilities.driver, Duration.ofSeconds(10));

		try {
			wait.until(ExpectedConditions.visibilityOf(tableListBar));
		} catch (Exception e) {
			clickingOnBranchesIcon();
			branchViewOption.get(0).click();
			tableListBar.click();
		}
		
		

		try {
			// Check if the list is not empty before accessing elements
			if (!existedTableNumbers.isEmpty() && existedTableNumbers.get(0).isDisplayed()) {
				String cssValue = pageChangeBtn.getCssValue("color");
				System.out.println(cssValue);

				while (cssValue.contains("0.54")) {
					pageChangeBtn.click();
					cssValue = pageChangeBtn.getCssValue("color");
					System.out.println("You are inside the loop");
				}
				createTablesBtn.click();
			} else {
				System.out.println("We are clicking on the Add tables button ");
				CommonUtilities.waitingTillVisibilityOfElement(createTablesBtn);
				createTablesBtn.click();
			}

			// If the list is not empty, access the last element
			if (!existedTableNumbers.isEmpty()) {
				System.out
						.println("Last value is " + existedTableNumbers.get(existedTableNumbers.size() - 1).getText());
			}

		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
			CommonUtilities.waitingTillVisibilityOfElement(createTablesBtn);
			createTablesBtn.click();
		}

		// Enter the number of tables to create
		numberOfTablesEntry.sendKeys("1");
		tablesConfirmationBtn.click();

		// Wait for all table numbers to be visible
		CommonUtilities.waitingTillVisibilityOfElements(tableNumbersValue);

		// Iterate over each input element in tableNumbersValue
		tableNumbersValue.get(0).sendKeys(CommonUtilities.gettingValueFromFile());

		tablesSaveBtn.click();

	}

	public String creatingManager() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(CommonUtilities.driver, Duration.ofSeconds(10));

		try {
			wait.until(ExpectedConditions.visibilityOf(userListBar));
		} catch (Exception e) {
			clickingOnBranchesIcon();
			branchViewOption.get(0).click();
		}

		// Click userListBar if not already clicked
		if (!userClickCheck) {
			userListBar.click();
			userClickCheck = true;
		}
		// Proceed with creating the manager
		addManagerBtn.click();
		CommonUtilities.waitingTillVisibilityOfElement(managerNameInput);

		String randomManagerName = testData.gettingRandomName();
		managerNameInput.sendKeys(randomManagerName);
		phoneNumberInput.sendKeys(testData.gettingRandomPhoneNumber());
		emailInput.sendKeys(testData.gettingRandomEmail());
		passwordInput.sendKeys("123456");

		detailsSubmitBtn.click();
		return randomManagerName;
	}

	public String creatingKitchenStaff() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(CommonUtilities.driver, Duration.ofSeconds(10));

		try {
			wait.until(ExpectedConditions.visibilityOf(userListBar));
		} catch (Exception e) {
			clickingOnBranchesIcon();
			branchViewOption.get(0).click();
		}

		// Click userListBar if not already clicked
		if (!userClickCheck) {
			userListBar.click();
			userClickCheck = true;
		}

		System.out.println("User List bar tab click " + userClickCheck);
		// Proceed with creating kitchen staff

		js.executeScript("arguments[0].click();", addKitchenStaffBtn);

		kitchenStaffInput.sendKeys(testData.gettingRandomName());
		phoneNumberInput.sendKeys(testData.gettingRandomPhoneNumber());
		emailInput.sendKeys(testData.gettingRandomEmail());
		passwordInput.sendKeys("123456");

		System.out.println("Kitchen staff name: " + kitchenStaffInput.getAttribute("value"));
		detailsSubmitBtn.click();
		return kitchenStaffInput.getAttribute("value");
	}

	public String creatingServiceStaff() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(CommonUtilities.driver, Duration.ofSeconds(10));

		try {
			wait.until(ExpectedConditions.visibilityOf(userListBar));
		} catch (Exception e) {
			clickingOnBranchesIcon();
			branchViewOption.get(0).click();
		}

		// Click userListBar if not already clicked
		if (!userClickCheck) {
			userListBar.click();
			userClickCheck = true;
		}

		// Proceed with creating service staff

		JavascriptExecutor js = (JavascriptExecutor) CommonUtilities.driver;
		js.executeScript("arguments[0].scrollIntoView(true);", addServiceStaffBtn);

		addServiceStaffBtn.click();
		serviceStaffInput.sendKeys(testData.gettingRandomName());
		phoneNumberInput.sendKeys(testData.gettingRandomPhoneNumber());
		serviceStaffPincodeInput.sendKeys("1234");

		System.out.println("Service staff name: " + serviceStaffInput.getAttribute("value"));
		detailsSubmitBtn.click();
		return serviceStaffInput.getAttribute("value");
	}

}
