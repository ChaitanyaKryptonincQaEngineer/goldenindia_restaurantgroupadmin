package goldenindia.RestaurantGroupAdmin.TestCases;

import org.testng.annotations.Test;

import goldenindia.RestaurantGroupAdmin.Base.GroupAdminBase;
import goldenindia.RestaurantGroupAdmin.PageObjects.UsermanagementPage;
import goldenindia.RestaurantGroupAdmin.TestData.restaurantTestData;
import goldenindia.RestaurantGroupAdmin.Utilities.CommonUtilities;

public class UserManagementTestCases extends GroupAdminBase {

	UsermanagementPage userPage = new UsermanagementPage(CommonUtilities.driver);

	@Test
	public void goingInsidetoUserManagement() throws InterruptedException {
		userPage.clickingOnSettings();
		userPage.clickingOnUserManagementOption("User Management");
		System.out.println("You are inside the settings.");
	}

	@Test(priority = 1, enabled = true)
	public void userCreatingRoleForDashboard() throws InterruptedException {
		userPage.createRole(CommonUtilities.driver, "Dashboard", restaurantTestData.dashboardPermissions);
		userPage.createUser();
		
	}

	@Test(priority = 2, enabled = true)
	public void userCreatingRoleForBranch() throws InterruptedException {
		userPage.createRole(CommonUtilities.driver, "Branch", restaurantTestData.branchPermissions);
		userPage.createUser();
	}

	@Test(priority = 3, enabled = true)
	public void userCreatingRoleForTables() throws InterruptedException {
		userPage.createRole(CommonUtilities.driver, "Tables", restaurantTestData.tablesPermissions);
		userPage.createUser();
	}

	@Test(priority = 4, enabled = true)
	public void userCreatingRoleForOrders() throws InterruptedException {
		userPage.createRole(CommonUtilities.driver, "Orders", restaurantTestData.ordersPermissions);
		userPage.createUser();
	}

	@Test(priority = 5, enabled = true)
	public void userCreatingRoleForMenus() throws InterruptedException {
		userPage.createRole(CommonUtilities.driver, "Menus", restaurantTestData.menusPermissions);
		userPage.createUser();
	}

	@Test(priority = 6, enabled = true)
	public void userCreatingRoleForStock() throws InterruptedException {
		userPage.createRole(CommonUtilities.driver, "Stock", restaurantTestData.stockPermissions);
		userPage.createUser();
	}

	@Test(priority = 7, enabled = true)
	public void userCreatingRoleForCoupons() throws InterruptedException {
		userPage.createRole(CommonUtilities.driver, "Coupons", restaurantTestData.couponsPermissions);
		userPage.createUser();
	}

	@Test(priority = 8, enabled = true)
	public void userCreatingRoleForVouchers() throws InterruptedException {
		userPage.createRole(CommonUtilities.driver, "Vouchers", restaurantTestData.vouchersPermissions);
		userPage.createUser();
	}

	@Test(priority = 9, enabled = true)
	public void userCreatingRoleForTourGroups() throws InterruptedException {
		userPage.createRole(CommonUtilities.driver, "Tour Groups", restaurantTestData.tourGroupsPermissions);
		userPage.createUser();
	}

	@Test(priority = 10, enabled = true)
	public void userCreatingRoleForEmailMarketing() throws InterruptedException {
		userPage.createRole(CommonUtilities.driver, "Email Marketing", restaurantTestData.emailMarketingPermissions);
		userPage.createUser();
	}

	@Test(priority = 11, enabled = true)
	public void userCreatingRoleForSubscriptions() throws InterruptedException {
		userPage.createRole(CommonUtilities.driver, "Subscriptions", restaurantTestData.subscriptionsPermissions);
		userPage.createUser();
	}

	@Test(priority = 12, enabled = true)
	public void userCreatingRoleForEnquiries() throws InterruptedException {
		userPage.createRole(CommonUtilities.driver, "Enquiries", restaurantTestData.enquiriesPermissions);
		userPage.createUser();
	}

	@Test(priority = 13, enabled = true)
	public void userCreatingRoleForKPGPT() throws InterruptedException {
		userPage.createRole(CommonUtilities.driver, "KPGPT", restaurantTestData.kpgptPermissions);
		userPage.createUser();
	}

	@Test(priority = 14, enabled = true)
	public void userCreatingRoleForRevenueReports() throws InterruptedException {
		userPage.createRole(CommonUtilities.driver, "Revenue Reports", restaurantTestData.revenueReportsPermissions);
		userPage.createUser();
	}

	@Test(priority = 15, enabled = true)
	public void userCreatingRoleForOrderReports() throws InterruptedException {
		userPage.createRole(CommonUtilities.driver, "Order Reports", restaurantTestData.orderReportsPermissions);
		userPage.createUser();
	}

	@Test(priority = 16, enabled = true)
	public void userCreatingRoleForProductReports() throws InterruptedException {
		userPage.createRole(CommonUtilities.driver, "Product Reports", restaurantTestData.productReportsPermissions);
		userPage.createUser();
	}

	@Test(priority = 17, enabled = true)
	public void userCreatingRoleForGeneralReports() throws InterruptedException {
		userPage.createRole(CommonUtilities.driver, "General Reports", restaurantTestData.generalReportsPermissions);
		userPage.createUser();
	}

	@Test(priority = 18, enabled = true)
	public void userCreatingRoleForBillingReports() throws InterruptedException {
		userPage.createRole(CommonUtilities.driver, "Billing Reports", restaurantTestData.billingReportsPermissions);
		userPage.createUser();
	}

	@Test(priority = 19, enabled = true)
	public void userCreatingRoleForVoucherReports() throws InterruptedException {
		userPage.createRole(CommonUtilities.driver, "Voucher Reports", restaurantTestData.voucherReportsPermissions);
		userPage.createUser();
	}

	@Test(priority = 20, enabled = true)
	public void userCreatingRoleForTourGroupReports() throws InterruptedException {
		userPage.createRole(CommonUtilities.driver, "Tour Group Reports", restaurantTestData.tourGroupReportsPermissions);
		userPage.createUser();
	}

	@Test(priority = 21, enabled = true)
	public void userCreatingRoleForDelivery() throws InterruptedException {
		userPage.createRole(CommonUtilities.driver, "Delivery", restaurantTestData.deliveryPermissions);
		userPage.createUser();
	}

	@Test(priority = 22, enabled = true)
	public void userCreatingRoleForPickup() throws InterruptedException {
		userPage.createRole(CommonUtilities.driver, "Pickup", restaurantTestData.pickupPermissions);
		userPage.createUser();
	}

	@Test(priority = 23, enabled = true)
	public void userCreatingRoleForDineIn() throws InterruptedException {
		userPage.createRole(CommonUtilities.driver, "Dine In", restaurantTestData.dineInPermissions);
		userPage.createUser();
	}

	@Test(priority = 24, enabled = true)
	public void userCreatingRoleForPaymentProvider() throws InterruptedException {
		userPage.createRole(CommonUtilities.driver, "Payment Provider", restaurantTestData.paymentProviderPermissions);
		userPage.createUser();
	}

	@Test(priority = 25, enabled = true)
	public void userCreatingRoleForPOS() throws InterruptedException {
		userPage.createRole(CommonUtilities.driver, "POS", restaurantTestData.posPermissions);
		userPage.createUser();
	}

	@Test(priority = 26, enabled = true)
	public void userCreatingRoleForVatCharges() throws InterruptedException {
		userPage.createRole(CommonUtilities.driver, "Vat Charges", restaurantTestData.vatChargesPermissions);
		userPage.createUser();
	}

	@Test(priority = 27, enabled = true)
	public void userCreatingRoleForPropertiesManagement() throws InterruptedException {
		userPage.createRole(CommonUtilities.driver, "Properties Management", restaurantTestData.propertiesManagementPermissions);
		userPage.createUser();
	}

	@Test(priority = 28, enabled = true)
	public void userCreatingRoleForGroupSetup() throws InterruptedException {
		userPage.createRole(CommonUtilities.driver, "Group Setup", restaurantTestData.groupSetupPermissions);
		userPage.createUser();
	}

	@Test(priority = 29, enabled = true)
	public void userCreatingRoleForPrinter() throws InterruptedException {
		userPage.createRole(CommonUtilities.driver, "Printer", restaurantTestData.printerPermissions);
		userPage.createUser();
	}

	@Test(priority = 30, enabled = true)
	public void userCreatingRoleForTourSetup() throws InterruptedException {
		userPage.createRole(CommonUtilities.driver, "Tour Setup", restaurantTestData.tourSetupPermissions);
		userPage.createUser();
	}

	@Test(priority = 31, enabled = true)
	public void userCreatingRoleForCMSSettings() throws InterruptedException {
		userPage.createRole(CommonUtilities.driver, "CMS Settings", restaurantTestData.cmsSettingsPermissions);
		userPage.createUser();
	}

	@Test(priority = 32, enabled = true)
	public void userCreatingRoleForLanguageSettings() throws InterruptedException {
		userPage.createRole(CommonUtilities.driver, "Language Settings", restaurantTestData.languageSettingsPermissions);
		userPage.createUser();
	}

	@Test(priority = 33, enabled = true)
	public void userCreatingRoleForDiscount() throws InterruptedException {
		userPage.createRole(CommonUtilities.driver, "Discount", restaurantTestData.discountPermissions);
		userPage.createUser();
	}

	@Test(priority = 34, enabled = true)
	public void userCreatingRoleForTips() throws InterruptedException {
		userPage.createRole(CommonUtilities.driver, "Tips", restaurantTestData.tipsPermissions);
		userPage.createUser();
	}

	@Test(priority = 35, enabled = true)
	public void userCreatingRoleForOptions() throws InterruptedException {
		userPage.createRole(CommonUtilities.driver, "Options", restaurantTestData.optionsPermissions);
		userPage.createUser();
	}

	@Test(priority = 36, enabled = true)
	public void userCreatingRoleForInventory() throws InterruptedException {
		userPage.createRole(CommonUtilities.driver, "Inventory", restaurantTestData.inventoryPermissions);
		userPage.createUser();
	}

}