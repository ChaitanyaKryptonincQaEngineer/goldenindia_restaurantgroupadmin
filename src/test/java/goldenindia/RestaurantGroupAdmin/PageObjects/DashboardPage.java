package goldenindia.RestaurantGroupAdmin.PageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import goldenindia.RestaurantGroupAdmin.Utilities.CommonUtilities;

public class DashboardPage {

	//CommonUtilities utilities = new CommonUtilities(driver);
	JavascriptExecutor js;

	@FindBy(css = "h1.[class*=\"fw-bolder\"]")
	WebElement dashBoard;

	@FindBy(css = "[class=\"nav-item\"]")
	List<WebElement> dashboardTabs;

	@FindBy(css = "[class=\" css-1d8n9bt\"]")
	WebElement dashboardBranchDropDown;

	public DashboardPage(WebDriver driver) {
		CommonUtilities.driver = driver;
		PageFactory.initElements(driver, this);
		System.out.println("Dashboard Page Driver : " + driver);
	}

	public void printingTheDashboardTitle() {
		System.out.println("You entered into the Dashboard");
		System.out.println("Driver Title " + CommonUtilities.driver.getTitle());
	}

	public void clickingOnEachTab() {
		for (WebElement dashboardTab : dashboardTabs) {
			System.out.println(dashboardTab.getText());
			dashboardTab.click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		dashboardTabs.get(0).click();
	}

	public void gettingDetailsAfterSelectingIndividualBranch() throws InterruptedException {
		System.out.println("You are clicking on the branch selection drop down");
		Thread.sleep(2000);
		dashboardBranchDropDown.click();
		Thread.sleep(1000);
		Actions ac = new Actions(CommonUtilities.driver);
		ac.keyDown(Keys.ARROW_DOWN).build().perform();
		ac.keyUp(Keys.ARROW_DOWN).build().perform();
		ac.keyDown(Keys.ENTER).build().perform();
		ac.keyUp(Keys.ENTER).build().perform();
//		System.out.println("Driver Value is " + CommonUtilities.driver);
//		System.out.println("You already clicked on the drop down");
		Thread.sleep(2000);
	}

}
