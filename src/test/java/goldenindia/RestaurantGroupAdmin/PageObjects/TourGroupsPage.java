package goldenindia.RestaurantGroupAdmin.PageObjects;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import goldenindia.RestaurantGroupAdmin.Utilities.CommonUtilities;
import goldenindia.RestaurantGroupAdmin.TestData.restaurantTestData;



public class TourGroupsPage {

	@FindBy(xpath = "/html/body/div[1]/div/div/div/div/aside/div/div/div[1]/div/div/a")
	List<WebElement> sideBarOptions;

	@FindBy(xpath = "//button[contains(text(),'Add New')]")
	WebElement tourAddBtn;

	@FindBy(css = "[placeholder=\"Reference\"]")
	WebElement referenceInput;

	@FindBy(css = "[placeholder=\"No of Adults\"]")
	WebElement adultsInput;

	@FindBy(css = "[placeholder=\"No of Kids\"]")
	WebElement kidsInput;

	@FindBy(css = "[placeholder=\"No of Vegetarian Meals\"]")
	WebElement vegeterianMealsInput;

	@FindBy(css = "[placeholder=\"No of Jain Meals\"]")
	WebElement jainsMealsInput;

	@FindBy(css = "[placeholder=\"No of Non Vegetarian Meals\"]")
	WebElement nonvegeterianMealsInput;

	@FindBy(css = "[placeholder=\"Adult Unit Price\"]")
	WebElement adultUnitpriceInput;

	@FindBy(css = "[placeholder=\"Kids Unit Price\"]")
	WebElement kidsUnitpriceInput;

	@FindBy(id = "kt_modal_new_address_submit")
	WebElement detailsSubmitBtn;

	@FindBy(xpath = "//div[contains(@class, 'search-line')]")
	List<WebElement> dropDowns;

	@FindBy(xpath = "//*[@id=\"react-select-17-placeholder\"]")
	WebElement paymentDropdown;

	@FindBy(xpath = "//table/tbody/tr/td[5]")
	public List<WebElement> tablereferenceIds;

	@FindBy(xpath = "//table/tbody//input[@type=\"checkbox\"]")
	public List<WebElement> groupCheckboxes;

	@FindBy(xpath = "//button[contains(text(),'Generate Invoice')]")
	WebElement generateInvoiceBtn;

	@FindBy(xpath = "//button[contains(text(),'Save')]")
	WebElement invoiceSaveBtn;

	WebDriverWait wait = new WebDriverWait(CommonUtilities.driver, Duration.ofSeconds(10));
	JavascriptExecutor js = (JavascriptExecutor) CommonUtilities.driver;
	restaurantTestData testData = new restaurantTestData();
	Actions action = new Actions(CommonUtilities.driver);

	public TourGroupsPage(WebDriver driver) {

		CommonUtilities.driver = driver;
		PageFactory.initElements(driver, this);
		System.out.println("Tour groups driver " + CommonUtilities.driver);

	}

	public void clickingOnTourGroups() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfAllElements(sideBarOptions));
		System.out.println("Size of the side options " + sideBarOptions.size());

		for (WebElement sideBarOption : sideBarOptions) {
			System.out.println("You are inside the for loop");
			String anchorValue = sideBarOption.getAttribute("href");
			System.out.println(anchorValue);
			if (anchorValue.contains("tour")) {
				sideBarOption.click();
				break;
			}
			Thread.sleep(1000);
		}
	}

	public void clickingOnAddNewButton() {
		tourAddBtn.click();
	}

	public void enteringReferenceValue() {
		referenceInput.sendKeys(testData.gettingRandomName());
	}

	public void enteringKidsValue() {
		kidsInput.clear();
		kidsInput.sendKeys(testData.gettingRandomNumber());
	}

	public void enteringAdultsValue() {
		adultsInput.clear();
		adultsInput.sendKeys(testData.gettingRandomNumber());
	}

	public void enteringVegeterianmealsValue() {
		vegeterianMealsInput.clear();
		vegeterianMealsInput.sendKeys(testData.gettingRandomNumber());
	}

	public void enteringJainmealsValue() {

		jainsMealsInput.clear();
		jainsMealsInput.sendKeys(testData.gettingRandomNumber());
	}

	public void enteringNonvegeterianmealsValue() {

		nonvegeterianMealsInput.clear();
		nonvegeterianMealsInput.sendKeys(testData.gettingRandomNumber());
	}

	public void enteringAdultunitsValue() {
		adultUnitpriceInput.clear();
		adultUnitpriceInput.sendKeys(testData.gettingRandomNumber());
	}

	public void enteringKidsunitsValue() {
		kidsUnitpriceInput.clear();
		kidsUnitpriceInput.sendKeys(testData.gettingRandomNumber());

	}

	public String enteringTourdata() {
		wait.until(ExpectedConditions.visibilityOf(tourAddBtn));
		clickingOnAddNewButton();
		System.out.println("We are entering the tour details");

		// Entering individual values
		enteringReferenceValue();
		selectCompany();
		selectClient();
		selectStatus();
		selectDineLocation();
		selectCookingLocation();
		selectMeal();
		enteringKidsValue();
		enteringAdultsValue();
		enteringVegeterianmealsValue();
		enteringJainmealsValue();
		enteringNonvegeterianmealsValue();
		enteringAdultunitsValue();
		enteringKidsunitsValue();
		selectPaymentCurrency();
		// selectPaymentStatus();
		// getDropdownValues();
		System.out.println("Tour details have been successfully entered.");
		submittingDetails();

		return referenceInput.getAttribute("value");

	}

	public void enteringCompanyData() {

	}

	public void selectCompany() {
		for (WebElement dropdown : dropDowns) {
			if (dropdown.getText().equals("Search Company...")) {
				dropdown.click(); // Open the dropdown
				action.moveToElement(dropdown).sendKeys(Keys.DOWN).build().perform();
				action.moveToElement(dropdown).sendKeys(Keys.ENTER).build().perform();
				return;
			}
		}
		System.out.println("Dropdown with placeholder 'Search Company...' not found.");
	}

	public void selectClient() {
		for (WebElement dropdown : dropDowns) {
			if (dropdown.getText().equals("Search Client...")) {
				dropdown.click(); // Open the dropdown
				action.moveToElement(dropdown).sendKeys(Keys.DOWN).build().perform();
				action.moveToElement(dropdown).sendKeys(Keys.ENTER).build().perform();
				return;
			}
		}
		System.out.println("Dropdown with placeholder 'Search Client...' not found.");
	}

	public void selectStatus() {
		for (WebElement dropdown : dropDowns) {
			if (dropdown.getText().equals("Search Status...")) {
				dropdown.click(); // Open the dropdown
				action.moveToElement(dropdown).sendKeys(Keys.DOWN).build().perform();
				action.moveToElement(dropdown).sendKeys(Keys.ENTER).build().perform();
				return;
			}
		}
		System.out.println("Dropdown with placeholder 'Search Status...' not found.");
	}

	public void selectDineLocation() {
		for (WebElement dropdown : dropDowns) {
			if (dropdown.getText().equals("Search Dining Location...")) {
				dropdown.click(); // Open the dropdown
				action.moveToElement(dropdown).sendKeys(Keys.DOWN).build().perform();
				action.moveToElement(dropdown).sendKeys(Keys.ENTER).build().perform();
				return;
			}
		}
		System.out.println("Dropdown with placeholder 'Search Dining Location...' not found.");
	}

	public void selectCookingLocation() {
		for (WebElement dropdown : dropDowns) {
			if (dropdown.getText().equals("Search Cooking Location...")) {
				dropdown.click(); // Open the dropdown
				action.moveToElement(dropdown).sendKeys(Keys.DOWN).build().perform();
				action.moveToElement(dropdown).sendKeys(Keys.ENTER).build().perform();
				return;
			}
		}
		System.out.println("Dropdown with placeholder 'Search Cooking Location...' not found.");
	}

	public void selectMeal() {
		for (WebElement dropdown : dropDowns) {
			if (dropdown.getText().equals("Search Meal...")) {
				dropdown.click(); // Open the dropdown
				action.moveToElement(dropdown).sendKeys(Keys.DOWN).build().perform();
				action.moveToElement(dropdown).sendKeys(Keys.ENTER).build().perform();
				return;
			}
		}
		System.out.println("Dropdown with placeholder 'Search Meal...' not found.");
	}

	public void selectPaymentCurrency() {
		for (WebElement dropdown : dropDowns) {
			if (dropdown.getText().equals("Search Payment Currency...")) {
				dropdown.click(); // Open the dropdown
				action.moveToElement(dropdown).sendKeys(Keys.DOWN).build().perform();
				action.moveToElement(dropdown).sendKeys(Keys.ENTER).build().perform();
				return;
			}
		}
		System.out.println("Dropdown with placeholder 'Search Payment Currency...' not found.");
	}

	public void selectPaymentStatus() {
		for (WebElement dropdown : dropDowns) {
			if (dropdown.getText().equals("Search Payment Status...")) {
				dropdown.click(); // Open the dropdown
				action.moveToElement(dropdown).sendKeys(Keys.DOWN).build().perform();
				action.moveToElement(dropdown).sendKeys(Keys.ENTER).build().perform();
				return;
			}
		}
		System.out.println("Dropdown with placeholder 'Search Payment Status...' not found.");
	}

	public void submittingDetails() {
		detailsSubmitBtn.click();

	}

	public void selectingInvoiceCheckbox(String str) throws InterruptedException {

		try {
			// Iterate through the list of reference IDs (outer loop)
			for (int tablereferenceId = 0; tablereferenceId < tablereferenceIds.size(); tablereferenceId++) {
				String selectingGroups = tablereferenceIds.get(tablereferenceId).getText();
				System.out.println(selectingGroups);

				// If the current reference ID matches the given string
				if (selectingGroups.equals(str)) {
					System.out.println("Both values are equal: " + str);
					Thread.sleep(2000);
					for (int checkboxIndex = 0; checkboxIndex < groupCheckboxes.size(); checkboxIndex++) {
						// Check if the checkbox corresponds to the current group
						if (checkboxIndex == tablereferenceId) {
							// Use JavaScriptExecutor to click the checkbox
							js.executeScript("arguments[0].click();", groupCheckboxes.get(checkboxIndex));
							break; // Break once the checkbox is clicked for the matched group
						}
					}

					break; // Exit the outer loop after the first match is found
				}
			}

			// Optional: Click on generate invoice after selecting checkboxes
			Thread.sleep(2000);
			clickingOnGenerateInvoice();
		} catch (Exception e) {
			// Handle any exceptions
			System.out.println("Exception encountered: " + e.getMessage());
			CommonUtilities.waitingTillVisibilityOfElements(tablereferenceIds);

			// Ensure all unchecked checkboxes are clicked (fallback)
			for (WebElement groupCheckbox : groupCheckboxes) {
				if (!groupCheckbox.isSelected()) {
					js.executeScript("arguments[0].click();", groupCheckbox);
				}
			}
		}
	}

	public void clickingOnGenerateInvoice() {
		js.executeScript("arguments[0].click();", generateInvoiceBtn);

	}

	public void submittingInvoiceDetails() {

		System.out.println("You are clicking on the invoice saving button");
		CommonUtilities.waitingTillVisibilityOfElement(invoiceSaveBtn);
		CommonUtilities.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		js.executeScript("arguments[0].scrollIntoView(true);", invoiceSaveBtn);
		js.executeScript("arguments[0].click();", invoiceSaveBtn);
	}

}
