package goldenindia.RestaurantGroupAdmin.TestCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import goldenindia.RestaurantGroupAdmin.PageObjects.TourGroupsPage;
import goldenindia.RestaurantGroupAdmin.Utilities.CommonUtilities;

public class TourGroupTestCases {
	private String tourSelect = null;
	private int methodClicker = 0;

	TourGroupsPage tourPage = new TourGroupsPage(CommonUtilities.driver);

	@Test(priority = 1, enabled = true, groups = "Regression")
	public void verifyuserabletocreatenewtourgroup() {
		boolean tourMatch = false;
		List<WebElement> referenceIds = tourPage.tablereferenceIds;
		String outputTour = tourPage.enteringTourdata();
		System.out.println("Newly created tour " + outputTour);

		// Set tourSelect here
		this.tourSelect = outputTour;

		CommonUtilities.waitingTillVisibilityOfElements(referenceIds);
		for (WebElement referenceId : referenceIds) {
			String tableReferences = referenceId.getText();
			System.out.println(tableReferences);
			if (tableReferences.equals(outputTour)) {
				tourMatch = true;
				break;
			}
		}
		Assert.assertTrue(tourMatch);
	}

	@Test(priority = 2, groups = "Regression")
	public void verifyUserabletogenerateInvoice() throws InterruptedException {
		System.out.println("You are generating Invoice for " + tourSelect);
		tourPage.selectingInvoiceCheckbox(tourSelect);
		tourPage.submittingInvoiceDetails();
	}

	@BeforeMethod
	public void userclickingOnTourGroups() throws InterruptedException {
		if (methodClicker == 0) {
			tourPage.clickingOnTourGroups();
			methodClicker++;
		}
	}
	
	
}
