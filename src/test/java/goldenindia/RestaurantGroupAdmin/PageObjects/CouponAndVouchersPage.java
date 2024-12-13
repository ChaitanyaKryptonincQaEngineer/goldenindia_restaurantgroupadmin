package goldenindia.RestaurantGroupAdmin.PageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.GroupLayout.Group;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import goldenindia.RestaurantGroupAdmin.Base.GroupAdminBase;
import goldenindia.RestaurantGroupAdmin.TestData.restaurantTestData;
import goldenindia.RestaurantGroupAdmin.Utilities.CommonUtilities;

public class CouponAndVouchersPage{

	@FindBy(xpath = "/html/body/div[1]/div/div/div/div/aside/div/div/div[1]/div/div/a")
	List<WebElement> sideBarOptions;

	@FindBy(css = "[class*=\"card-body\"]")
	List<WebElement> discountOptions;

	@FindBy(xpath = "//button[contains(text(),'Add Coupon')]")
	WebElement addCouponBtn;

	@FindBy(xpath = "//div[contains(@class, 'css-b62m3t-container')]")
	List<WebElement> dropDowns;

	@FindBy(xpath = "(//input[@type=\"date\"])[1]")
	WebElement startDateSelection;

	@FindBy(xpath = "(//input[@type=\"date\"])[2]")
	WebElement endDateSelection;

	@FindBy(id = "kt_modal_new_address_submit")
	WebElement couponSaveBtn;

	@FindBy(css = "[placeholder=\"Enter discount value\"]")
	WebElement discountValueInput;

	@FindBy(css = "[placeholder=\"Enter min order value\"]")
	WebElement minOrderValueInput;

	@FindBy(css = "[placeholder=\"Enter max usages\"]")
	WebElement maxUsagesInput;

	@FindBy(css = "[placeholder=\"Enter max order value\"]")
	WebElement maxDiscountInput;

	@FindBy(xpath = "//button[contains(text(), \"Add Voucher\")]")
	WebElement addVoucherBtn;

	@FindBy(css = "[class*=\"card-body\"] label")
	WebElement imageInput;

	@FindBy(xpath = "//input[contains(@placeholder, \"Number of\")]")
	WebElement voucherValidityInput;

	@FindBy(xpath = "//button[contains(text(), \"Save\")]")
	WebElement voucherSbmtBtn;

	@FindBy(xpath = "//tbody/tr/td[3]")
	List<WebElement> createdVouchers;

	WebDriverWait wait = new WebDriverWait(CommonUtilities.driver, Duration.ofSeconds(10));
	JavascriptExecutor js = (JavascriptExecutor) CommonUtilities.driver;
	Actions action = new Actions(CommonUtilities.driver);
	restaurantTestData testData = new restaurantTestData();

	public CouponAndVouchersPage(WebDriver driver) {

		CommonUtilities.driver = driver;
		PageFactory.initElements(CommonUtilities.driver, this);
		System.out.println("Coupons and Vouchers driver " + CommonUtilities.driver);
	}

	public void clickingOnCouponsAndVouchers() throws InterruptedException {
//		System.out.println("You are clicking on the coupons and vouchers");
		wait.until(ExpectedConditions.visibilityOfAllElements(sideBarOptions));
		System.out.println("Size of the side options " + sideBarOptions.size());

		for (WebElement sideBarOption : sideBarOptions) {
			System.out.println("You are inside the for loop");
			String anchorValue = sideBarOption.getAttribute("href");
			System.out.println(anchorValue);
			if (anchorValue.contains("coupon_voucher_management")) {
				sideBarOption.click();
				break;
			}
			Thread.sleep(1000);
		}
	}

	public void clickingOnCoupon() {
		wait.until(ExpectedConditions.visibilityOfAllElements(discountOptions));
		for (WebElement discountOption : discountOptions) {
			System.out.println(discountOption.getText());
			if (discountOption.getText().equals("Coupon Management")) {
				discountOption.click();
				break;
			}
		}

		System.out.println("Clicking on the Add coupon button");
		CommonUtilities.waitingTillVisibilityOfElement(addCouponBtn);
		addCouponBtn.click();

		for (WebElement dropDown : dropDowns) {
			System.out.println(dropDown.getText());
		}

	}

	public void userCreatingCoupoun() throws InterruptedException {
		clickingOnCoupon();
		CommonUtilities.waitingTillVisibilityOfElement(couponSaveBtn);
		selectingBranch();
		selectingOrdertype();
		selectingCouponCodeType();
		selectingDiscountype();
		enteringDiscountValue();
		selectingStartDate();
		selectingEndDate();
		enteringminOrderValue();
		enteringMaxDiscountValue();
		enteringMaxUsagesValue();
		selectingCoupontype();
		savingCouponData();
		Thread.sleep(2000);

	}

	public void selectingBranch() {

		for (WebElement dropdown : dropDowns) {
			if (dropdown.getText().equals("Search...")) {
				dropdown.click(); // Open the dropdown
				// action.moveToElement(dropdown).sendKeys(Keys.DOWN).build().perform();
				action.moveToElement(dropdown).sendKeys(Keys.ENTER).build().perform();
				return;
			}
		}
		System.out.println("Dropdown with placeholder 'Search Company...' not found.");
	}

	public void selectingOrdertype() {
		for (WebElement dropdown : dropDowns) {
			if (dropdown.getText().equals("Select order type...")) {
				dropdown.click(); // Open the dropdown
				// action.moveToElement(dropdown).sendKeys(Keys.DOWN).build().perform();
				action.moveToElement(dropdown).sendKeys(Keys.ENTER).build().perform();
				return;
			}
		}
		System.out.println("Dropdown with placeholder 'Select order type...' not found.");
	}

	public void selectingCouponCodeType() {
		for (WebElement dropdown : dropDowns) {
			if (dropdown.getText().equals("Select coupon code...")) {
				dropdown.click(); // Open the dropdown
				action.moveToElement(dropdown).sendKeys(Keys.DOWN).build().perform();
				action.moveToElement(dropdown).sendKeys(Keys.ENTER).build().perform();
				return;
			}
		}
		System.out.println("Dropdown with placeholder 'Select coupon code...' not found.");
	}

	public void selectingDiscountype() {

		int i = 0;

		for (WebElement dropdown : dropDowns) {
			if (dropdown.getText().equals("Search...")) {
				i++;
				System.out.println("Discount type Value " + i);
				if (i == 1) {
					dropdown.click(); // Open the dropdown
					action.moveToElement(dropdown).sendKeys(Keys.DOWN).build().perform();
					action.moveToElement(dropdown).sendKeys(Keys.ENTER).build().perform();
					return;
				}
			}
		}
		System.out.println("Dropdown with placeholder 'Search...' not found.");
	}

	public void selectingCoupontype() {

		dropDowns.get(dropDowns.size() - 1).click();
		action.moveToElement(dropDowns.get(dropDowns.size() - 1)).sendKeys(Keys.ENTER).build().perform();

	}

	public void selectingStartDate() {
		System.out.println("Start date is " + LocalDate.now());
		startDateSelection.sendKeys(LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")).toString());
	}

	public void selectingEndDate() {
		endDateSelection.sendKeys(LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")).toString());
	}

	public void enteringDiscountValue() {

		discountValueInput.sendKeys(testData.gettingRandomNumber());
	}

	public void enteringMaxDiscountValue() {

		try {
			if (maxDiscountInput.isDisplayed()) {
				maxDiscountInput.sendKeys(testData.gettingRandomNumber());
			} else {
				System.out.println("Not found");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void enteringminOrderValue() {
		minOrderValueInput.sendKeys(testData.gettingRandomNumber());
	}

	public void enteringMaxUsagesValue() {
		maxUsagesInput.sendKeys(testData.gettingRandomNumber());
	}

	public void savingCouponData() {
		couponSaveBtn.click();
	}

	public void clickingOnVoucher() {

		System.out.println("You are clicking on the voucher management");
		wait.until(ExpectedConditions.visibilityOfAllElements(discountOptions));
		for (WebElement discountOption : discountOptions) {
			System.out.println(discountOption.getText());
			if (discountOption.getText().equals("Voucher Management")) {
				discountOption.click();
				break;
			}
		}
	}

	public void creatingCouponwithEndtime() {

	}

	public void creatingVoucher() throws InterruptedException, AWTException {
		System.out.println("You are creating the voucher");
		clickingOnVoucher();
		clickingOnAddVoucherButton();
		uploadingVoucherTemplateImage();
		voucherBranchSelection();
		selectingVoucherCategory();
		selectingVoucherValidity();
		submittingVoucherDetails();

	}

	public void clickingOnAddVoucherButton() {
		addVoucherBtn.click();
		CommonUtilities.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		CommonUtilities.waitingTillVisibilityOfElement(imageInput);
		for (WebElement dropDown : dropDowns) {
			System.out.println(dropDown.getText());
		}
	}

	public void uploadingVoucherTemplateImage() throws AWTException {

		System.out.println("Uploading voucher template");
		// Click to open the file explorer
		imageInput.click();

		// Set the file path to clipboard
		String filePath = System.getProperty("user.dir")
				+ "\\src\\test\\java\\goldenindia\\RestaurantGroupAdmin\\TestData\\IMG_20241102_175014.jpg";
		StringSelection selection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

		Robot robot = new Robot();

		robot.delay(1000);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		robot.delay(500);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	public void selectingVoucherCategory() {

		dropDowns.get(1).click();
		action.moveToElement(dropDowns.get(1)).sendKeys(Keys.ENTER).build().perform();

	}

	public void selectingVoucherValidity() {

		dropDowns.get(2).click();
		action.moveToElement(dropDowns.get(2)).sendKeys(Keys.ENTER).build().perform();
		voucherValidityInput.sendKeys("2");
	}

	public void voucherBranchSelection() {
		dropDowns.get(0).click();
		action.moveToElement(dropDowns.get(0)).sendKeys(Keys.ENTER).build().perform();

	}

	public void submittingVoucherDetails() {
		voucherSbmtBtn.click();
		wait.until(ExpectedConditions.visibilityOfAllElements(createdVouchers));
	}

}
