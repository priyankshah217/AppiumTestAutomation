package com.test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.apidemo.app.screens.AppActivityScreen;
import com.test.apidemo.app.screens.AppMenuScreen;
import com.test.apidemo.app.screens.HomeScreen;
import com.test.apidemo.app.screens.ScreenOrientationScreen;
import com.test.utils.TestAppUtils;

public class AppiumApiDemoAppTests {
	private TestAppUtils testAppUtils;
	private AndroidDriver driver;
	private HomeScreen homeScreen;
	private AppMenuScreen appMenuPage;
	private AppActivityScreen appActivityPage;
	private ScreenOrientationScreen screenOrientationPage;

	@BeforeMethod
	public void beforeMethod() {
	}

	@AfterMethod
	public void afterMethod() {
	}

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws IOException {
		TestAppUtils.loadConfigProp("config_apidemo_test_app.properties");
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

	@Test(groups = { "Smoke" }, enabled = true)
	public void testAppActivity() {
		homeScreen = new HomeScreen(driver);
		appMenuPage = homeScreen.getAppMenuPage();
		appActivityPage = appMenuPage.getActivityPage();
		screenOrientationPage = appActivityPage.browseAppActivityScreen()
				.getScreenOrientationPage();
		Assert.assertEquals(
				screenOrientationPage.isItValidScreenOrientationPage(), true);
		screenOrientationPage.changeScreenOrientation("USER");
		Assert.assertEquals(screenOrientationPage.checkOrientationType(), true);
	}
}
