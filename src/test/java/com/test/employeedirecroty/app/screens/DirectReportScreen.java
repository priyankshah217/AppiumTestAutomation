package com.test.employeedirecroty.app.screens;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

import com.test.utils.AbstractScreen;

public class DirectReportScreen extends AbstractScreen {

	public DirectReportScreen(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		loadPage();
	}

	public boolean verifyDirectReporterName(String employeeName) {
		return isElementPresent(MobileBy
				.AndroidUIAutomator("new UiSelector().descriptionContains(\""
						+ employeeName + "\")"));
	}

}
