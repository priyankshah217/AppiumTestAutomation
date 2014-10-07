package com.test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.employeedirecroty.app.screens.DirectReportScreen;
import com.test.employeedirecroty.app.screens.EmployeeDetailsScreen;
import com.test.employeedirecroty.app.screens.HomeScreen;
import com.test.utils.AppUtils;

public class TestAppiumEmployeeDirectoryApp {
	private AppUtils testAppUtils;
	private AndroidDriver driver;
	private HomeScreen homeScreen;
	private EmployeeDetailsScreen employeeDetailsScreen;
	private DirectReportScreen viewDirectReportScreen;

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException {
		AppUtils
				.loadConfigProp("config_employee_directory_test_app.properties");
		testAppUtils = new AppUtils();
		testAppUtils.setCapability(MobileCapabilityType.BROWSER_NAME, "");
		testAppUtils.setCapability(MobileCapabilityType.PLATFORM_VERSION,
				"4.4.2");
		testAppUtils.setCapability(MobileCapabilityType.PLATFORM_NAME,
				"Android");
		testAppUtils.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		testAppUtils.setCapability(MobileCapabilityType.AUTOMATION_NAME,
				"Appium");
		testAppUtils.setCapability(MobileCapabilityType.APP, new File(
				ClassLoader.getSystemResource(AppUtils.APPLICATION_NAME)
						.getFile()).getAbsolutePath());
		testAppUtils.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,
				"300");
		testAppUtils.setCapability(MobileCapabilityType.DEVICE_READY_TIMEOUT,
				"300");
		testAppUtils.setCapability(MobileCapabilityType.APP_ACTIVITY,
				AppUtils.APP_ACTIVITY);
		testAppUtils.setCapability(MobileCapabilityType.APP_PACKAGE,
				AppUtils.BASE_PKG);
		driver = testAppUtils.getDriver();
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
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
}
