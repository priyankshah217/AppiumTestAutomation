package com.test.selendroid.app.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

import org.openqa.selenium.WebElement;

import com.test.utils.AbstractScreen;

public class VerifyUserScreen extends AbstractScreen {

	@AndroidFindBy(id = "io.selendroid.testapp:id/buttonRegisterUser")
	private WebElement registerUserButton;

	public VerifyUserScreen(AndroidDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		// TODO Auto-generated constructor stub
		loadPage();
	}

	public HomeScreen registerUser() {
		registerUserButton.click();
		return new HomeScreen(driver);
	}
}
