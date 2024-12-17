package goldenindia.RestaurantGroupAdmin.PageObjects;

import java.time.Duration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
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
	WebElement menuNameSaveBtn;

	@FindBy(xpath = "//tbody/tr/td[1]/a")
	List<WebElement> menuNames;

	@FindBy(xpath = "//div[contains(@class, 'css-b62m3t-container')]")
	WebElement branchSelection;

	@FindBy(xpath = "//li/a[contains(text(),'Categories')]")
	WebElement categoryBar;

	public static String newBranchValue = null;

	public MenusPage(WebDriver driver) {
		CommonUtilities.driver = driver;
		PageFactory.initElements(CommonUtilities.driver, this);
		System.out.println("Menus page " + CommonUtilities.driver);

	}

	WebDriverWait wait = new WebDriverWait(CommonUtilities.driver, Duration.ofSeconds(10));
	JavascriptExecutor js = (JavascriptExecutor) CommonUtilities.driver;
	Actions action = new Actions(CommonUtilities.driver);
	restaurantTestData testData = new restaurantTestData();

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
		menuNameSaveBtn.click();
		return newBranchValue;
	}

	public void clickingOnAddMenuButton() {
		addMenuBtn.click();
	}

	public void creatingCategory() throws InterruptedException {

		System.out.println(ExcelUtilities.getRowCount("Categories_Products"));
		int rowsValue = ExcelUtilities.getRowCount("Categories_Products");
		Set<String> uniqueCategories = new LinkedHashSet<>();
		for (int i = 2; i <= rowsValue; i++) {
			String category = ExcelUtilities.getCellData("Categories_Products", "Category", i);
			uniqueCategories.add(category);
		}
		System.out.println("Unique Categories:");
		int rowIndex = 2;
		for (String uniqueCategory : uniqueCategories) {
			System.out.println(uniqueCategory);
		}
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

	public void creatingProduct() {

		
	}
}
