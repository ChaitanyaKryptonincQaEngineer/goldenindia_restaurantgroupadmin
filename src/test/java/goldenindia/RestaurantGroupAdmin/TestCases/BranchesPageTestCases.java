package goldenindia.RestaurantGroupAdmin.TestCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import goldenindia.RestaurantGroupAdmin.Base.GroupAdminBase;
import goldenindia.RestaurantGroupAdmin.PageObjects.BranchesPage;
import goldenindia.RestaurantGroupAdmin.Utilities.CommonUtilities;

public class BranchesPageTestCases extends GroupAdminBase {

	
	BranchesPage branchesPage = new BranchesPage(CommonUtilities.driver);

	List<WebElement> branchManagerNames;
	List<WebElement> branchServiceStaffNames;
	List<WebElement> branchKitchenStaffNames;
	Actions action = new Actions(CommonUtilities.driver);

	@Test(priority = 1, alwaysRun = true, enabled = true, groups = "Regression")
	public void testCreatingNewBranch() throws InterruptedException, IOException {
		// Test case for creating a new branch
		System.out.println("Starting test: Creating a new branch.");

		branchesPage.addingBranchDetails();
		Thread.sleep(2000);
		System.out.println("Branch created successfully.");
	}

	@Test(priority = 2, alwaysRun = true, enabled = true, groups = "Regression")
	public void testAddingTablesInBranches() throws InterruptedException, IOException {
		// Test case for adding tables in branches
		System.out.println("Starting test: Adding tables in branches.");

		branchesPage.creatingTables();
		System.out.println("Tables added successfully.");
		Thread.sleep(2000);
	}

	@Test(priority = 3, alwaysRun = true, enabled = true, groups = "Regression")
	public void testCreatingManagerInBranches() throws InterruptedException {
		String createdManagerName = branchesPage.creatingManager();
		boolean managerFound = false;

		branchManagerNames = branchesPage.createdbranchManagers;
		System.out.println("Initial size of branchManagerNames: " + branchManagerNames.size());
		while (!managerFound) {
			if (!branchManagerNames.isEmpty() && branchManagerNames.get(0).isDisplayed()) {
				System.out.println("Checking for manager name on the current page...");

				for (int i = 0; i < branchManagerNames.size(); i++) {
					String managerText = branchManagerNames.get(i).getText();
					System.out.println("Checking manager name: " + managerText);

					JavascriptExecutor js = (JavascriptExecutor) CommonUtilities.driver;
					js.executeScript("arguments[0].scrollIntoView(true);", branchManagerNames.get(0));
					Thread.sleep(2000);
					if (managerText.trim().equalsIgnoreCase(createdManagerName.trim())) {
						System.out.println("Manager found successfully... ");
						managerFound = true;
						break;
					}
				}
			}

			if (!managerFound) {
				WebElement pageChangeBtn = branchesPage.managerNextPageBtn;
				System.out.println("Clicking on the 'Next Page' button to continue search...");
				Thread.sleep(2000);

				pageChangeBtn.click();
				// Wait for the page to load and re-initialize branchManagerNames
				// Adjust the sleep time if needed
			} else {
				// If no more pages to check, break out of the loop
				System.out.println("No more pages to check. Manager not found.");
				break;

			}
		}

		Assert.assertTrue(managerFound, "Manager was not found in the list.");
		System.out.println("Manager created successfully.");
	}

	@Test(priority = 4, alwaysRun = true, enabled = true, groups = "Regression")
	public void testCreatingServiceStaffInBranches() throws InterruptedException {
		String createdServiceStaffName = branchesPage.creatingServiceStaff();
		boolean serviceStaffFound = false;

		branchServiceStaffNames = branchesPage.createdBranchServiceStaff;
		System.out.println("Initial size of branchServiceStaffNames: " + branchServiceStaffNames.size());
		while (!serviceStaffFound) {
			if (!branchServiceStaffNames.isEmpty() && branchServiceStaffNames.get(0).isDisplayed()) {
				System.out.println("Checking for service staff name on the current page...");

				for (int i = 0; i < branchServiceStaffNames.size(); i++) {
					String serviceStaffText = branchServiceStaffNames.get(i).getText();
					System.out.println("Checking service staff name: " + serviceStaffText);
					JavascriptExecutor js = (JavascriptExecutor) CommonUtilities.driver;
					js.executeScript("arguments[0].scrollIntoView(true);", branchServiceStaffNames.get(0));

					if (serviceStaffText.trim().equalsIgnoreCase(createdServiceStaffName.trim())) {
						System.out.println("Service staff found successfully... ");
						serviceStaffFound = true;
						break;
					}
				}
			}

			if (!serviceStaffFound) {
				WebElement pageChangeBtn = branchesPage.serviceStaffNextPageBtn;
				System.out.println("Clicking on the 'Next Page' button to continue search...");
				Thread.sleep(2000);
				action.keyDown(Keys.ESCAPE).build().perform();
				action.keyUp(Keys.ESCAPE).build().perform();

				pageChangeBtn.click();
			} else {
				System.out.println("No more pages to check. Service staff not found.");
				break;
			}
		}

		Assert.assertTrue(serviceStaffFound, "Service staff was not found in the list.");
		System.out.println("Service staff created successfully.");
	}

	@Test(priority = 5, enabled = true, groups = "Regression")
	public void testCreatingKitchenStaffInBranches() throws InterruptedException {
		String createdKitchenStaffName = branchesPage.creatingKitchenStaff();
		boolean kitchenStaffFound = false;

		branchKitchenStaffNames = branchesPage.createdBranchKitchenStaff;
		System.out.println("Initial size of branchKitchenStaffNames: " + branchKitchenStaffNames.size());
		while (!kitchenStaffFound) {
			if (!branchKitchenStaffNames.isEmpty() && branchKitchenStaffNames.get(0).isDisplayed()) {
				System.out.println("Checking for kitchen staff name on the current page...");

				for (int i = 0; i < branchKitchenStaffNames.size(); i++) {
					String kitchenStaffText = branchKitchenStaffNames.get(i).getText();
					System.out.println("Checking kitchen staff name: " + kitchenStaffText);
					JavascriptExecutor js = (JavascriptExecutor) CommonUtilities.driver;
					js.executeScript("arguments[0].scrollIntoView(true);", branchKitchenStaffNames.get(0));
					Thread.sleep(1000);
					if (kitchenStaffText.trim().equalsIgnoreCase(createdKitchenStaffName.trim())) {
						System.out.println("Kitchen staff found successfully... ");
						kitchenStaffFound = true;
						break;
					}
				}
			}

			if (!kitchenStaffFound) {
				WebElement pageChangeBtn = branchesPage.kitchenStaffNextPageBtn;
				System.out.println("Clicking on the 'Next Page' button to continue search...");
				Thread.sleep(2000);
				action.keyDown(Keys.ESCAPE).build().perform();
				action.keyUp(Keys.ESCAPE).build().perform();
				action.moveToElement(pageChangeBtn).click().build().perform();
			} else {
				System.out.println("No more pages to check. Kitchen staff not found.");
				break;
			}
		}

		Assert.assertTrue(kitchenStaffFound, "Kitchen staff was not found in the list.");
		System.out.println("Kitchen staff created successfully.");
	}

}
