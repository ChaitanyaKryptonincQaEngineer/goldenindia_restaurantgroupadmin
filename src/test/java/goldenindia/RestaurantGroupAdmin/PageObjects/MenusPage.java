package goldenindia.RestaurantGroupAdmin.PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import goldenindia.RestaurantGroupAdmin.TestData.restaurantTestData;
import goldenindia.RestaurantGroupAdmin.Utilities.CommonUtilities;

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

	public MenusPage(WebDriver driver) {
		CommonUtilities.driver = driver;
		PageFactory.initElements(CommonUtilities.driver, this);
		System.out.println("Menus page " + CommonUtilities.driver);

	}

	WebDriverWait wait = new WebDriverWait(CommonUtilities.driver, Duration.ofSeconds(10));
	JavascriptExecutor js = (JavascriptExecutor) CommonUtilities.driver;
	Actions action = new Actions(CommonUtilities.driver);
	restaurantTestData testData = new restaurantTestData();

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

}
