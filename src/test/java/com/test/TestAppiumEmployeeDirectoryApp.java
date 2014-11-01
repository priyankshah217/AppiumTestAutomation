package com.test;

import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.employeedirecroty.app.screens.DirectReportScreen;
import com.test.employeedirecroty.app.screens.EmployeeDetailsScreen;
import com.test.employeedirecroty.app.screens.HomeScreen;
import com.test.utils.AppUtils;

public class TestAppiumEmployeeDirectoryApp {
	private AndroidDriver driver;
	private HomeScreen homeScreen;
	private EmployeeDetailsScreen employeeDetailsScreen;
	private DirectReportScreen viewDirectReportScreen;

	@BeforeClass(alwaysRun=true)
	public void initAutomation() throws IOException{
		AppUtils.loadConfigProp("config_employee_directory_test_app.properties");
		AppUtils.setCapabilities();
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException {		
		driver = AppUtils.getDriver();
	}	

	@Test(groups = { "Smoke" }, enabled = true)
	public void testEmployeeDetails() {
		String employeeName = "John Williams";

		homeScreen = new HomeScreen(driver);
		homeScreen.switchToWebView();
		employeeDetailsScreen = homeScreen.searchName(employeeName)
				.getEmployeeDetails();
		Assert.assertEquals(
				employeeDetailsScreen.verifyManagerName("James King"), true,
				"Displayed wrong manager name");
		viewDirectReportScreen = employeeDetailsScreen.viewDirectReports();
		Assert.assertEquals(
				viewDirectReportScreen.verifyDirectReporterName("Paul Jones"),
				true, "Error in direct report");
		Assert.assertEquals(
				viewDirectReportScreen.verifyDirectReporterName("Paula Gates"),
				true, "Error in direct report");
		Assert.assertEquals(
				viewDirectReportScreen.verifyDirectReporterName("Steven Wells"),
				true, "Error in direct report");
	}

	@Test(groups = { "Smoke" }, enabled = true)
	public void testScrolling() {
		String employeeName = "";
		homeScreen = new HomeScreen(driver);
		homeScreen.switchToWebView();
		homeScreen.searchName(employeeName).scrollTo("Steven Wells");
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
}
