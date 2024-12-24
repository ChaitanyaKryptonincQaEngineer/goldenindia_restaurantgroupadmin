package goldenindia.RestaurantGroupAdmin.TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import goldenindia.RestaurantGroupAdmin.Base.GroupAdminBase;
import goldenindia.RestaurantGroupAdmin.PageObjects.MenusPage;
import goldenindia.RestaurantGroupAdmin.Utilities.CommonUtilities;

public class MenuManagementTestCases extends GroupAdminBase {

	MenusPage menuPage = new MenusPage(CommonUtilities.driver);

	@Test(priority = 1)
	public void verifyUserCreatingMenu() throws InterruptedException {
		menuPage.creatingMenu();
		
		try {
			menuPage.creatingCategory();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}


}
