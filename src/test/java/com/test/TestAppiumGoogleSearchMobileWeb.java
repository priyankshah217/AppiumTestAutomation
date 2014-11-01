package com.test;

import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.googlesearch.screens.AppiumGithubScreen;
import com.test.googlesearch.screens.GoogleSearchHomeScreen;
import com.test.utils.AppUtils;

public class TestAppiumGoogleSearchMobileWeb {
	private AndroidDriver driver;
	private GoogleSearchHomeScreen googleSearchHomeScreen;
	private AppiumGithubScreen appiumGitHubScreen;
	
	@BeforeClass(alwaysRun=true)
	public void initAutomation() throws IOException{
		AppUtils.loadConfigProp("config_googlesearch_mobile_web.properties");
		AppUtils.setCapabilities();
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException {		
		driver = AppUtils.getDriver();
	}	

	@Test(groups = { "Smoke" }, enabled = true)
	public void testBrowseTopic() {
		googleSearchHomeScreen = new GoogleSearchHomeScreen(driver);
		appiumGitHubScreen = googleSearchHomeScreen.openGoogleSearch()
				.searchFor("Appium").openAppiumGitHub();
		appiumGitHubScreen.viewAllIssues().navigateToIssue();
	}

	@Test(groups = { "Smoke" }, enabled = false)
	public void testZoomAndPinchGesture() {
		googleSearchHomeScreen = new GoogleSearchHomeScreen(driver);
		appiumGitHubScreen = googleSearchHomeScreen.openGoogleSearch()
				.searchFor("Appium").openAppiumGitHub();
		appiumGitHubScreen.zoomInWebPage();
	}

	@Test(groups = { "Smoke" }, enabled = false)
	public void testScreenRotation() {
		googleSearchHomeScreen = new GoogleSearchHomeScreen(driver);
		googleSearchHomeScreen.openGoogleSearch().rotateScreen();
	}
	
	@AfterMethod
	public void afterMethod() {
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}
}
