package com.test.employeedirecroty.app.screens;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

import org.openqa.selenium.WebElement;

import com.test.utils.AbstractScreen;

public class EmployeeDetailsScreen extends AbstractScreen {

	@AndroidFindBy(uiAutomator = "new UiSelector().descriptionContains(\"View Direct Reports\")")
	private WebElement viewDirectReport;

	public EmployeeDetailsScreen(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		loadPage();
	}

	public boolean verifyEmail(String emailID) {
		// TODO Auto-generated method stub
		return isElementPresent(MobileBy
				.AndroidUIAutomator("new UiSelector().descriptionContains(\""
						+ emailID + "\")"));
	}

	public HomeScreen navigateToHomeScreen() {
		// TODO Auto-generated method stub
		driver.navigate().back();
		return new HomeScreen(driver);
	}

	public DirectReportScreen viewDirectReports() {
		// TODO Auto-generated method stub
		viewDirectReport.click();
		return new DirectReportScreen(driver);
	}	

	public boolean verifyManagerName(String employeeName) {
		// TODO Auto-generated method stub
		return isElementPresent(MobileBy
				.AndroidUIAutomator("new UiSelector().descriptionContains(\"View Manager"
						+ employeeName + "\")"));
	}
}
