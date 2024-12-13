package goldenindia.RestaurantGroupAdmin.TestCases;

import org.testng.annotations.Test;

import goldenindia.RestaurantGroupAdmin.Base.GroupAdminBase;
import goldenindia.RestaurantGroupAdmin.PageObjects.DashboardPage;
import goldenindia.RestaurantGroupAdmin.Utilities.CommonUtilities;

public class DashboardPageTestCases extends GroupAdminBase {

	DashboardPage dashBoardPage = new DashboardPage(CommonUtilities.driver);

	@Test(priority = 3)
	public void gettingDashboardName() {

		dashBoardPage.printingTheDashboardTitle();
	}

	@Test(priority = 1)
	public void travellingEachTab() {
		System.out.println("I am travelling each tab");
		dashBoardPage.clickingOnEachTab();
	}

	@Test(priority = 2)
	public void testDashboardValuesChangeAfterBranchSelection() throws InterruptedException {
		dashBoardPage.gettingDetailsAfterSelectingIndividualBranch();
	}
}
