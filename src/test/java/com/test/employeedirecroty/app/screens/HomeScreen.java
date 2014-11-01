package com.test.employeedirecroty.app.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;

import org.openqa.selenium.WebElement;

import com.test.utils.AbstractScreen;

public class HomeScreen extends AbstractScreen {

	@AndroidFindBy(className = "android.widget.EditText")
	private WebElement searchTextBox;

	@AndroidFindBy(className = "android.widget.ListView")
	private WebElement employeeName;

	public HomeScreen(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		loadPage();
	}

	public HomeScreen searchName(String employeeName) {
		// TODO Auto-generated method stub
		searchTextBox.sendKeys(employeeName);
		if (employeeName.equals("")) {
			driver.sendKeyEvent(AndroidKeyCode.ENTER);
		}
		return this;
	}

	public EmployeeDetailsScreen getEmployeeDetails() {
		// TODO Auto-generated method stub
		// driver.navigate().back();
		// driver.findElementByAndroidUIAutomator(
		// "new UiSelector().descriptionContains(\"" + employeeName
		// + "\")").click();		
		employeeName.click();
		return new EmployeeDetailsScreen(driver);
	}

	public HomeScreen scrollTo(String employeeName) {
		// TODO Auto-generated method stub
		driver.navigate().back();
		driver.scrollTo(employeeName);
		return this;
	}

	public HomeScreen clearSearchEdit() {
		// TODO Auto-generated method stub
		searchTextBox.clear();
		return this;
	}

}
