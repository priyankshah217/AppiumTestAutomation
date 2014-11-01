package com.test;

import io.appium.java_client.android.AndroidDriver;

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
import com.test.utils.AppUtils;

public class TestAppiumSelendroidApp {
	private AndroidDriver driver;
	private UserRegistrationScreen userRegistrationScreen;
	private HomeScreen homeScreen;
	private VerifyUserScreen verifyUserScreen;
	private WebViewScreen webViewScreen;
	
	@BeforeClass(alwaysRun=true)
	public void initAutomation() throws IOException{
		AppUtils.loadConfigProp("config_selendroid_test_app.properties");
		AppUtils.setCapabilities();
	}	

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException {		
		driver = AppUtils.getDriver();
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
	
	@AfterMethod
	public void afterMethod() {
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}
}
