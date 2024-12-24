package goldenindia.RestaurantGroupAdmin.PageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import goldenindia.RestaurantGroupAdmin.TestData.restaurantTestData;
import goldenindia.RestaurantGroupAdmin.Utilities.CommonUtilities;
import goldenindia.RestaurantGroupAdmin.Utilities.ExcelUtilities;

public class MenusPage {

	@FindBy(xpath = "/html/body/div[1]/div/div/div/div/aside/div/div/div[1]/div/div/a")
	List<WebElement> sideBarOptions;

	@FindBy(xpath = "//button[contains(text(),\"Add New Menu\")]")
	WebElement addMenuBtn;

	@FindBy(css = "[placeholder=\"Menu Name\"]")
	WebElement menuNameInput;

	@FindBy(xpath = "//div[contains(@class, 'css-b62m3t-container')]")
	WebElement dropDowns;

	@FindBy(id = "kt_modal_new_address_submit")
	WebElement detailsaveBtn;

	@FindBy(xpath = "//tbody/tr/td[1]/a")
	List<WebElement> menuNames;

	@FindBy(xpath = "//div[contains(@class, 'css-b62m3t-container')]")
	WebElement branchSelection;

	@FindBy(xpath = "//li/a[contains(text(),'Categories')]")
	WebElement categoryBar;

	@FindBy(xpath = "//div/a[contains(text(),\"Add Category\")]")
	WebElement addCategoryBtn;

	@FindBy(xpath = "(//input[@type=\"text\"])[1]")
	WebElement nameInput;

	@FindBy(css = "[placeholder=\"Enter catagory sequel number\"]")
	WebElement sequenceNumInput;

	@FindBy(css = "[class=\"py-5\"] a div div div b")
	List<WebElement> menuCategories;

	@FindBy(xpath = "//li/a[contains(text(),'Products')]")
	WebElement productBar;

	@FindBy(xpath = "//button[contains(text(),'New Product')]")
	WebElement addProdutBtn;

	@FindBy(css = "[placeholder=\"Enter Amount\"]")
	WebElement produtAmount;

	@FindBy(css = "[placeholder=\"Min. Order Quantity\"]")
	WebElement minquantityInput;

	public static String newBranchValue = null;

	public static boolean menuCheck = false;

	public MenusPage(WebDriver driver) {
		CommonUtilities.driver = driver;
		PageFactory.initElements(CommonUtilities.driver, this);
		System.out.println("Menus page " + CommonUtilities.driver);

	}

	WebDriverWait wait = new WebDriverWait(CommonUtilities.driver, Duration.ofSeconds(10));
	JavascriptExecutor js = (JavascriptExecutor) CommonUtilities.driver;
	Actions action = new Actions(CommonUtilities.driver);
	restaurantTestData testData = new restaurantTestData();
	Set<String> uniqueCategories;

	ExcelUtilities excelUtils = new ExcelUtilities(System.getProperty("user.dir")
			+ "\\src\\main\\java\\goldenindia\\RestaurantGroupAdmin\\Utilities\\Distinct_Categories_and_Products.xlsx");

	public void clickingOnMenuManagement() throws InterruptedException {

//		System.out.println("You are clicking on the coupons and vouchers");
		wait.until(ExpectedConditions.visibilityOfAllElements(sideBarOptions));
		System.out.println("Size of the side options " + sideBarOptions.size());

		for (WebElement sideBarOption : sideBarOptions) {
			System.out.println("You are inside the for loop");
			String anchorValue = sideBarOption.getAttribute("href");
			System.out.println(anchorValue);
			if (anchorValue.contains("menu_management")) {
				sideBarOption.click();
				break;
			}
			Thread.sleep(1000);
		}

	}

	public void creatingMenu() throws InterruptedException {

		clickingOnMenuManagement();
		clickingOnAddMenuButton();
		enteringMenuDetails();

	}

	public String enteringMenuDetails() {
		menuNameInput.sendKeys(testData.gettingRandomName() + " Menu");
		newBranchValue = menuNameInput.getAttribute("value");
		System.out.println(newBranchValue);
		branchSelection.click();
		action.moveToElement(branchSelection).sendKeys(Keys.ENTER).build().perform();
		detailsaveBtn.click();
		return newBranchValue;
	}

	public void clickingOnAddMenuButton() {
		addMenuBtn.click();
	}

	public void creatingCategory() throws InterruptedException, IOException {

		System.out.println(ExcelUtilities.getRowCount("Categories_Products"));
		int rowsValue = ExcelUtilities.getRowCount("Categories_Products");
		uniqueCategories = new LinkedHashSet<>();
		for (int i = 2; i <= rowsValue; i++) {
			String category = ExcelUtilities.getCellData("Categories_Products", "Category", i);
			uniqueCategories.add(category);
		}
		System.out.println("Unique Categories:");
		int rowIndex = 2;
		for (String uniqueCategory : uniqueCategories) {
			System.out.println(uniqueCategory);
		}

		clickingOnMenu();

		for (String string : uniqueCategories) {
			System.out.println(string);
			Thread.sleep(2000);
			addCategoryBtn.click();
			Thread.sleep(2000);
			CommonUtilities.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			nameInput.sendKeys(string);
			sequenceNumInput.sendKeys(CommonUtilities.gettingValueFromFile());
			detailsaveBtn.click();
			wait.until(ExpectedConditions.elementToBeClickable(addCategoryBtn));
			CommonUtilities.waitingTillVisibilityOfElement(addCategoryBtn);
			js.executeScript("arguments[0].scrollIntoView(true);", addCategoryBtn);
			wait.until(ExpectedConditions.elementToBeClickable(addCategoryBtn));

		}

		creatingProduct();
	}

	public void creatingProduct() throws InterruptedException {
		System.out.println(ExcelUtilities.getRowCount("Categories_Products"));
		int rowsValue = ExcelUtilities.getRowCount("Categories_Products");

		// Fetch Excel Data
		List<String> productNames = ExcelUtilities.getAllValues("Categories_Products", "Product Name");
		List<String> fileCategories = getCategory(); // Fetch categories from the file
		List<String> fileDescriptions = getProductDescription();
		List<String> fileQuantities = getTotalQuantity();
		 Iterator<String> iterator = uniqueCategories.iterator();
		// Log the size of each list for debugging
		System.out.println("Product Names size: " + productNames.size());
		System.out.println("File Categories size: " + fileCategories.size());
		System.out.println("File Descriptions size: " + fileDescriptions.size());
		System.out.println("File Quantities size: " + fileQuantities.size());
		System.out.println("Menu Categories size: " + menuCategories.size());

		// Validate data alignment
		if (productNames.size() != fileCategories.size() || fileCategories.size() != fileDescriptions.size()
				|| fileDescriptions.size() != fileQuantities.size()) {
			throw new IllegalStateException("Excel data columns are not aligned!");
		}

		int i;
		// Loop through the menu categories (3 categories in your case)
		for (i = 0; i < uniqueCategories.size(); i++) {
			wait.until(ExpectedConditions.visibilityOfAllElements(menuCategories));
			Thread.sleep(2000);

			for (int j = 1; j < productNames.size(); j++) {
				if (iterator.hasNext() && getCategory().get(j).) {
					System.out.println("=================================");
			
					System.out.println(i);
					System.out.println(menuCategories.size());
					
				    menuCategories.get(i).click();
					System.out.println(getProductPrice().get(j));
					System.out.println(getProductDescription().get(j));
				}
			}
		}
	}

	public List<String> getCategory() {
		List<String> arr = ExcelUtilities.getAllValues("Categories_Products", "Category");
		return arr;
	}

	public List<String> getProductPrice() {
		List<String> productPrices = ExcelUtilities.getAllValues("Categories_Products", "Product Price");

		return productPrices;
	}

	public List<String> getTotalQuantity() {
		List<String> totalQuantities = ExcelUtilities.getAllValues("Categories_Products", "Total Quantity");
		return totalQuantities;
	}

	public List<String> getProductDescription() {
		List<String> productDescriptions = ExcelUtilities.getAllValues("Categories_Products", "Description");
		return productDescriptions;
	}

	public void clickingOnMenu() throws InterruptedException {
		Thread.sleep(2000);
		for (WebElement menuName : menuNames) {
			System.out.println(menuName.getText());
			if (menuName.getText().equals(newBranchValue)) {
				System.out.println("Condition success: " + menuName.getText());
				Assert.assertEquals(menuName.getText(), newBranchValue);
				wait.until(ExpectedConditions.elementToBeClickable(menuName));
				js.executeScript("arguments[0].scrollIntoView(true);", menuName);
				js.executeScript("arguments[0].click();", menuName);
				CommonUtilities.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				categoryBar.click();

			}
		}
	}

	public void enteringProdutDetails() {

	}
}
