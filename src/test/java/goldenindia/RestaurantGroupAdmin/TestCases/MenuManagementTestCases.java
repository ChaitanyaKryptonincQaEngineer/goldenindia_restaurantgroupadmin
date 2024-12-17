package goldenindia.RestaurantGroupAdmin.TestCases;

import org.testng.annotations.Test;

import goldenindia.RestaurantGroupAdmin.Base.GroupAdminBase;
import goldenindia.RestaurantGroupAdmin.PageObjects.MenusPage;
import goldenindia.RestaurantGroupAdmin.Utilities.CommonUtilities;

public class MenuManagementTestCases extends GroupAdminBase {

	MenusPage menuPage = new MenusPage(CommonUtilities.driver);

	@Test
	public void verifyUserCreatingMenu() throws InterruptedException {
		menuPage.creatingMenu();
		menuPage.creatingCategory();
	}
	
	
}
