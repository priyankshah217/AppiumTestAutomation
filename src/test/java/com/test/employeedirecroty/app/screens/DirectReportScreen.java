package com.test.employeedirecroty.app.screens;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.PageFactory;

public class DirectReportScreen extends AbstractScreen {

	public DirectReportScreen(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public boolean verifyDirectReporterName(String employeeName) {
		return isElementPresent(MobileBy
				.AndroidUIAutomator("new UiSelector().descriptionContains(\""
						+ employeeName + "\")"));
	}

}
