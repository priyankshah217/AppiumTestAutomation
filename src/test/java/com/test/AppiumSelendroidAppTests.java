package com.test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.selendroid.app.screens.HomeScreen;
import com.test.selendroid.app.screens.UserRegistrationScreen;
import com.test.selendroid.app.screens.VerifyUserScreen;
import com.test.selendroid.app.screens.WebViewScreen;
import com.test.utils.TestAppUtils;

public class AppiumSelendroidAppTests {
	private TestAppUtils testAppUtils;
	private AndroidDriver driver;
	private UserRegistrationScreen userRegistrationScreen;
	private HomeScreen homeScreen;
	private VerifyUserScreen verifyUserScreen;
	private WebViewScreen webViewScreen;

	@BeforeMethod
	public void beforeMethod() {
	}

	@AfterMethod
	public void afterMethod() {
	}

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws IOException {
		TestAppUtils.loadConfigProp("config_selendroid_test_app.properties");
		testAppUtils = new TestAppUtils();
		testAppUtils.setCapability(MobileCapabilityType.BROWSER_NAME, "");
		testAppUtils.setCapability(MobileCapabilityType.PLATFORM_VERSION,
				"4.4.2");
		testAppUtils.setCapability(MobileCapabilityType.PLATFORM_NAME,
				"Android");
		testAppUtils.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		testAppUtils.setCapability(MobileCapabilityType.AUTOMATION_NAME,
				"Appium");
		testAppUtils.setCapability(MobileCapabilityType.APP, new File(
				ClassLoader.getSystemResource(TestAppUtils.APPLICATION_NAME)
						.getFile()).getAbsolutePath());
		testAppUtils.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,
				"300");
		testAppUtils.setCapability(MobileCapabilityType.DEVICE_READY_TIMEOUT,
				"300");
		testAppUtils.setCapability(MobileCapabilityType.APP_ACTIVITY,
				TestAppUtils.APP_ACTIVITY);
		testAppUtils.setCapability(MobileCapabilityType.APP_PACKAGE,
				TestAppUtils.BASE_PKG);
		driver = testAppUtils.getDriver();
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}

	@Test(groups = { "Smoke" }, enabled = false)
	public void testRegisterUser() {
		homeScreen = new HomeScreen(driver);
		userRegistrationScreen = homeScreen.getUserRegistration();
		verifyUserScreen = userRegistrationScreen.fillUserName("TestUser")
				.fillEmailID("abc@abc.com").fillPassword("123456")
				.fillName("Test User").selectProgrammingLanguage("C++")
				.selectAddsRadio().verifyUser();
		verifyUserScreen.registerUser();
	}

	@Test(groups = { "Smoke" }, enabled = true)
	public void testWebView() {		
		homeScreen = new HomeScreen(driver);		
		webViewScreen = homeScreen.openWebView();		
		webViewScreen.selectOptionFromList();
	}
}
