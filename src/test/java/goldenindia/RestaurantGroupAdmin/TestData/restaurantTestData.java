package goldenindia.RestaurantGroupAdmin.TestData;

import java.util.Random;

import org.testng.annotations.DataProvider;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import com.github.javafaker.Number;

public class restaurantTestData {

	public String devresEmail = "new@gmail.com";
	public String devresPassword = "123456";
	public String devbranchName = "MapleLeaf";
	public static boolean[] dashboardPermissions = { true, false, false, false }; // Only view is allowed
	public static boolean[] branchPermissions = { true, true, true, true }; // Full CRUD permissions
	public static boolean[] tablesPermissions = { true, false, true, false }; // Full CRUD permissions
	public static boolean[] ordersPermissions = { true, false, false, true }; // Full CRUD permissions
	public static boolean[] menusPermissions = { true, true, true, true }; // Full CRUD permissions
	public static boolean[] stockPermissions = { true, true, false, true }; // Full CRUD permissions
	public static boolean[] couponsPermissions = { true, true, true, true }; // Full CRUD permissions
	public static boolean[] vouchersPermissions = { true, true, true, true }; // Full CRUD permissions
	public static boolean[] tourGroupsPermissions = { true, true, true, true }; // Full CRUD permissions
	public static boolean[] emailMarketingPermissions = { true, true, true, true }; // Full CRUD permissions
	public static boolean[] subscriptionsPermissions = { true, true, true, true }; // Full CRUD permissions
	public static boolean[] enquiriesPermissions = { true, false, false, false }; // Full CRUD permissions
	public static boolean[] kpgptPermissions = { true, false, false, false }; // Full CRUD permissions

	// Reports - only view permissions
	public static boolean[] revenueReportsPermissions = { true, false, false, false };
	public static boolean[] orderReportsPermissions = { true, false, false, false };
	public static boolean[] productReportsPermissions = { true, false, false, false };
	public static boolean[] generalReportsPermissions = { true, false, false, false };
	public static boolean[] billingReportsPermissions = { true, false, false, false };
	public static boolean[] voucherReportsPermissions = { true, false, false, false };
	public static boolean[] tourGroupReportsPermissions = { true, false, false, false };

	// Other sections with full CRUD permissions
	public static boolean[] deliveryPermissions = { true, true, true, true };
	public static boolean[] pickupPermissions = { true, true, true, true };
	public static boolean[] dineInPermissions = { true, true, true, true };
	public static boolean[] paymentProviderPermissions = { true, true, true, true };
	public static boolean[] posPermissions = { true, true, true, true };
	public static boolean[] vatChargesPermissions = { true, true, true, true };
	public static boolean[] propertiesManagementPermissions = { true, true, true, true };
	public static boolean[] groupSetupPermissions = { true, true, true, true };
	public static boolean[] printerPermissions = { true, true, true, true };
	public static boolean[] tourSetupPermissions = { true, true, true, true };
	public static boolean[] cmsSettingsPermissions = { true, true, true, true };
	public static boolean[] languageSettingsPermissions = { true, true, true, true };
	public static boolean[] discountPermissions = { true, true, true, true };
	public static boolean[] tipsPermissions = { true, true, true, true };
	public static boolean[] optionsPermissions = { true, true, true, true };
	public static boolean[] inventoryPermissions = { true, true, true, true };

	Faker fk = new Faker();

	@DataProvider(name = "loginData")
	public Object[][] getDetails() {
		return new Object[][] { {}, {}

		};

	}

	public String gettingRandomAddress() {
		Address address = fk.address();
		String userAddress = address.state();

		return userAddress;
	}

	public String gettingRandomName() {
		Name value = fk.name();
		String name = value.firstName();
		return name;
	}

	public String gettingRandomEmail() {
		String username = gettingRandomName();
		String domainName = generateRandomDomainName();
		String topLevelDomain = generateRandomTopLevelDomain();
		return username + "@" + domainName + "." + topLevelDomain;
	}

	private static String generateRandomUsername() {
		// Predefined list of usernames
		String[] usernames = { "john", "jane", "user", "test", "abcd", "demo", "admin" };
		int index = new Random().nextInt(usernames.length);
		return usernames[index];
	}

	private static String generateRandomDomainName() {
		// Predefined list of domain names
		String[] domainNames = { "gmail", "yahoo", "outlook", "example", "mail" };
		int index = new Random().nextInt(domainNames.length);
		return domainNames[index];
	}

	private static String generateRandomTopLevelDomain() {
		// Predefined list of top-level domains
		String[] topLevelDomains = { "com", "net", "org", "io", "edu" };
		int index = new Random().nextInt(topLevelDomains.length);
		return topLevelDomains[index];
	}

	public String gettingRandomPhoneNumber() {
		String number = fk.number().digits(10);
		return number;
	}

	public String gettingRandomNumber() {
		Number number = fk.number();
		return Integer.toString(number.randomDigit());
	
	}

}
