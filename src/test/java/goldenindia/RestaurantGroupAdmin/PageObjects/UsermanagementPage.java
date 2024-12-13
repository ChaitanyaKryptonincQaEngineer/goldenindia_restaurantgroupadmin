package goldenindia.RestaurantGroupAdmin.PageObjects;

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

import goldenindia.RestaurantGroupAdmin.TestData.restaurantTestData;
import goldenindia.RestaurantGroupAdmin.Utilities.CommonUtilities;

public class UsermanagementPage {

	@FindBy(id = "section-13")
	private WebElement settings;

	@FindBy(css = "[class*=\"card-body\"]")
	private List<WebElement> settingOptions;

	@FindBy(xpath = "(//li[@class=\"nav-item\"])[2]")
	private WebElement rolesTab;

	@FindBy(xpath = "(//li[@class=\"nav-item\"])[1]")
	private WebElement usersTab;

	@FindBy(xpath = "//button[normalize-space()='Add Role']")
	private WebElement addRoleBtn;

	@FindBy(css = "[placeholder=\"Enter Role Name\"]")
	private WebElement roleName;

	@FindBy(id = "kt_modal_new_address_submit")
	private WebElement savingRoleBtn;

	@FindBy(css = "[class*=\"btn-primary\"]")
	private WebElement addUserBtn;

	@FindBy(css = "[placeholder=\"Enter Full Name\"]")
	private WebElement userName;

	@FindBy(css = "[placeholder=\"Enter Phone Number\"]")
	private WebElement userPhoneNumber;

	@FindBy(css = "[placeholder=\"Enter Email\"]")
	private WebElement userEmail;

	@FindBy(css = "[placeholder=\"Enter Password\"]")
	private WebElement userPassword;

	@FindBy(xpath = "(//div[@class=\" css-ackcql\"])[1]")
	private WebElement userRoleDropdown;

	@FindBy(xpath = "(//div[@class=\" css-ackcql\"])[2]")
	private WebElement userBranchDropDown;

	@FindBy(id = "kt_modal_new_address_submit")
	private WebElement userSaveBtn;

	@FindBy(xpath = "//td[4]")
	List<WebElement> userEmails;

	@FindBy(css = "[name=\"email\"]")
	private WebElement resEmail;

	@FindBy(css = "[name=\"password\"]")
	private WebElement resPassword;

	@FindBy(xpath = "//button[@type=\"submit\"]")
	private WebElement userSubmissionBtn;

	restaurantTestData testData = new restaurantTestData();

	public UsermanagementPage(WebDriver driver) {
		CommonUtilities.driver = driver;
		PageFactory.initElements(CommonUtilities.driver, this);
		System.out.println("User Management Driver" + CommonUtilities.driver);
	}

	public void clickingOnSettings() throws InterruptedException {
		System.out.println("You are clicking on the settings");
		CommonUtilities.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		try {
			JavascriptExecutor js = CommonUtilities.javascriptExecutor();
			js.executeScript("arguments[0].scrollIntoView(true);", settings);
			settings.click();
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			List<WebElement> sideBarOptions = CommonUtilities.driver
					.findElements(By.cssSelector("[class*=\"menu-item\"]"));

			for (WebElement sideBarOption : sideBarOptions) {
				String optionNames = sideBarOption.getText();
				if (optionNames.equals("Settings")) {
					sideBarOption.click();
				}
			}
		}
	}

	public void clickingOnUserManagementOption(String str) throws InterruptedException {
		for (WebElement option : settingOptions) {
			String optionValue = option.getText();
			System.out.println(optionValue);
			if (optionValue.equals(str)) {
				JavascriptExecutor js = CommonUtilities.javascriptExecutor();
				js.executeScript("arguments[0].scrollIntoView(true);", option);
				Thread.sleep(1000);
				option.click();
				break;
			}
		}
	}

	public void clickingOnRolesTab() {

		rolesTab.click();
		CommonUtilities.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	public void clickingOnUsersTab() {

		usersTab.click();
		CommonUtilities.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	public void createRole(WebDriver driver, String section, boolean[] permissions) throws InterruptedException {

		System.out.println("You are creating the role for " + section);
		clickingOnRolesTab();
		CommonUtilities.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		addRoleBtn.click();
		CommonUtilities.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		roleName.clear();
		roleName.sendKeys(section + " " + testData.gettingRandomName() + " Role");

		String sectionXPath = getSectionXPath(section);

		if (permissions[0]) {
			selectEnabledCheckbox(driver, sectionXPath);
		}
		if (permissions[1]) {
			selectEnabledCheckbox(driver, sectionXPath);
		}
		if (permissions[2]) {
			selectEnabledCheckbox(driver, sectionXPath);
		}
		if (permissions[3]) {
			selectEnabledCheckbox(driver, sectionXPath);
		}

		JavascriptExecutor js = CommonUtilities.javascriptExecutor();
		js.executeScript("arguments[0].scrollIntoView(true);", savingRoleBtn);
		savingRoleBtn.click();

		Thread.sleep(3000);
	}

	public static String getSectionXPath(String sectionName) {
		switch (sectionName) {
		case "Dashboard":
			return "//form/div[3]";

		case "Branch":
			return "//form/div[4]";

		case "Tables":
			return "//form/div[5]";

		case "Orders":
			return "//form/div[6]";

		case "Menus":
			return "//form/div[7]";

		case "Stock":
			return "//form/div[8]";

		case "Coupons":
			return "//form/div[9]";

		case "Vouchers":
			return "//form/div[10]";

		case "Tour Groups":
			return "//form/div[11]";

		case "Email Marketing":
			return "//form/div[12]";

		case "Subscriptions":
			return "//form/div[13]";

		case "Enquiries":
			return "//form/div[14]";
		case "KPGPT":

			return "//form/div[15]";

		case "Revenue Reports":
			return "//form/div[16]/div/div[2]";

		case "Order Reports":
			return "//form/div[16]/div/div[3]";

		case "Product Reports":
			return "//form/div[16]/div/div[4]";

		case "General Reports":
			return "//form/div[16]/div/div[5]";

		case "Billing Reports":
			return "//form/div[16]/div/div[6]";

		case "Voucher Reports":
			return "//form/div[16]/div/div[7]";

		case "Tour Group Reports":
			return "//form/div[16]/div/div[8]";

		case "Delivery":
			return "//form/div[17]/div/div[2]";

		case "Pickup":
			return "//form/div[17]/div/div[3]";

		case "Dine In":
			return "//form/div[17]/div/div[4]";

		case "Payment Provider":
			return "//form/div[17]/div/div[5]";

		case "POS":
			return "//form/div[17]/div/div[6]";

		case "Vat Charges":
			return "//form/div[17]/div/div[7]";

		case "Properties Management":
			return "//form/div[17]/div/div[8]";

		case "Group Setup":
			return "//form/div[17]/div/div[9]";

		case "Printer":
			return "//form/div[17]/div/div[10]";

		case "Tour Setup":
			return "//form/div[17]/div/div[11]";

		case "CMS Settings":
			return "//form/div[17]/div/div[12]";

		case "Language Settings":
			return "//form/div[17]/div/div[13]";

		case "Discount":
			return "//form/div[17]/div/div[14]";

		case "Tips":
			return "//form/div[17]/div/div[15]";

		case "Options":
			return "//form/div[17]/div/div[16]";

		case "Inventory":
			return "//form/div[17]/div/div[17]";

		default:
			return "Invalid value selection" + sectionName;
		}
	}

	public static void selectEnabledCheckbox(WebDriver driver, String sectionXPath) {

		List<WebElement> checkboxes = driver
				.findElements(By.xpath(sectionXPath + "//input[@type='checkbox' and not(@disabled)]"));

		for (WebElement checkbox : checkboxes) {
			if (!checkbox.isSelected()) {
				checkbox.click();
			}
		}
	}

	public void createUser() throws InterruptedException {

		Thread.sleep(2000);
		clickingOnUsersTab();
		addUserBtn.click();
		CommonUtilities.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		userName.sendKeys(testData.gettingRandomName());
		userPhoneNumber.sendKeys(testData.gettingRandomPhoneNumber());
		userEmail.sendKeys(testData.gettingRandomEmail());
		userPassword.sendKeys(testData.devresPassword);

		Thread.sleep(2000);
		Actions action = new Actions(CommonUtilities.driver);
		userRoleDropdown.click();
		action.keyDown(Keys.ENTER).build().perform();
		action.keyUp(Keys.ENTER).build().perform();

		userBranchDropDown.click();
		Thread.sleep(2000);
		action.keyDown(Keys.ENTER).build().perform();
		action.keyUp(Keys.ENTER).build().perform();
		userSaveBtn.click();
		CommonUtilities.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(1000);
//		System.out.println("User password is " + userEmails.get(0).getText());
//		System.out.println("We are opening the new tab ");
//		JavascriptExecutor js = (JavascriptExecutor) CommonUtilities.driver;
//		js.executeScript("window.open();");
//
//		String newUserEmail = userEmails.get(0).getText();
//		System.out.println("New User Email " + newUserEmail);
//		// Store the current window handle
//		String parentWindow = CommonUtilities.driver.getWindowHandle();
//
//		// Get all window handles
//		Set<String> allWindows = CommonUtilities.driver.getWindowHandles();
//		String childWindow = null;
//
//		// Find the new window handle
//		for (String windowHandle : allWindows) {
//			if (!windowHandle.equals(parentWindow)) {
//				childWindow = windowHandle;
//				break;
//			}
//		}
//
//		// Switch to the new window
//		if (childWindow != null) {
//			CommonUtilities.driver.manage().deleteAllCookies();
//			CommonUtilities.driver.switchTo().window(childWindow);
//			CommonUtilities.driver.navigate().to("https://resgroup.mypreview.xyz/");
//			resEmail.sendKeys(newUserEmail);
//			resPassword.sendKeys("123456");
//			userSubmissionBtn.click();
//			CommonUtilities.driver.switchTo().window(parentWindow);
//		} else {
//			System.out.println("New window handle not found!");
//		}

	}

}
