package goldenindia.RestaurantGroupAdmin.TestCases;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import goldenindia.RestaurantGroupAdmin.Base.GroupAdminBase;
import goldenindia.RestaurantGroupAdmin.PageObjects.CouponAndVouchersPage;
import goldenindia.RestaurantGroupAdmin.Utilities.CommonUtilities;

public class CouponVoucherTestCases extends GroupAdminBase {

	CouponAndVouchersPage discounts = new CouponAndVouchersPage(CommonUtilities.driver);

	@BeforeMethod(alwaysRun = true)
	public void userPreConditionClick() {
		try {
			discounts.clickingOnCouponsAndVouchers();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 1)
	public void testUserabletoaddCoupons() throws InterruptedException {
		discounts.userCreatingCoupoun();
	}

	@Test(priority = 2, alwaysRun = true, groups = "Regression")
	public void testUserabletoaddVoucher() throws InterruptedException, AWTException {
		Thread.sleep(2000);
		discounts.creatingVoucher();
	}
}
