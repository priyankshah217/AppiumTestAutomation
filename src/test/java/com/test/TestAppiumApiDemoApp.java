package com.test;

import io.appium.java_client.android.AndroidDriver;

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
import com.test.utils.AppUtils;

public class TestAppiumApiDemoApp {
	private AndroidDriver driver;
	private HomeScreen homeScreen;
	private AppMenuScreen appMenuScreen;
	private AppActivityScreen appActivityScreen;
	private ScreenOrientationScreen screenOrientationScreen;

	@AfterMethod
	public void afterMethod() {
	}

	@BeforeClass(alwaysRun = true)
	public void initAutomation() throws IOException {
		AppUtils.loadConfigProp("config_apidemo_test_app.properties");
		AppUtils.setCapabilities();
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException {
		driver = AppUtils.getDriver();
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}

	@Test(groups = { "Smoke" }, enabled = true)
	public void testAppActivity() {
		homeScreen = new HomeScreen(driver);
		appMenuScreen = homeScreen.getAppMenuPage();
		appActivityScreen = appMenuScreen.getActivityPage();
		// screenOrientationPage = appActivityPage.browseAppActivityScreen()
		// .getScreenOrientationPage();
		screenOrientationScreen = appActivityScreen.getScreenOrientationPage();
		Assert.assertEquals(
				screenOrientationScreen.isItValidScreenOrientationPage(), true);
		screenOrientationScreen.changeScreenOrientation("USER");
		Assert.assertEquals(screenOrientationScreen.checkOrientationType(),
				true);
	}
}
