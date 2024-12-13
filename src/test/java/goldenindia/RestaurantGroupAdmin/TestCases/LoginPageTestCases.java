package goldenindia.RestaurantGroupAdmin.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


import goldenindia.RestaurantGroupAdmin.PageObjects.*;
import goldenindia.RestaurantGroupAdmin.Base.GroupAdminBase;
import goldenindia.RestaurantGroupAdmin.PageObjects.LoginPage;
import goldenindia.RestaurantGroupAdmin.TestData.restaurantTestData;
import goldenindia.RestaurantGroupAdmin.Utilities.CommonUtilities;

public class LoginPageTestCases extends GroupAdminBase {

//public static WebDriver driver;

	LoginPage loginPage = new LoginPage(CommonUtilities.driver);
	restaurantTestData testData  = new restaurantTestData();

	@Test(groups = "Regression")
	public void loginToThePanel() {
	    loginPage.gotoURL(); 
		loginPage.enteringLoginDetails(testData.devresEmail, testData.devresPassword);
		loginPage.submittingLoginDetails();
	}

//	@Test(dataProvider = "loginData", dataProviderClass = TestData.class)
//	public void loginDifferentValues() {
//
//	}

}
