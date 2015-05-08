package com.test.employeedirecroty.app.screens;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;

import org.openqa.selenium.WebElement;

import com.test.utils.AbstractScreen;

public class HomeScreen extends AbstractScreen {

	@AndroidFindBy(className = "android.widget.EditText")
	private WebElement searchTextBox;

	private String emoployeeName;

	public HomeScreen(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		loadPage();
	}

	public HomeScreen searchName(String employeeName) {
		// TODO Auto-generated method stub
		searchTextBox.sendKeys(employeeName);
		this.emoployeeName = employeeName;
		if (employeeName.equals("")) {
			driver.sendKeyEvent(AndroidKeyCode.ENTER);
		}
		return this;
	}

	public EmployeeDetailsScreen getEmployeeDetails() {
		// TODO Auto-generated method stub
		WebElement element = driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().descriptionContains(\""
				+ this.emoployeeName + "\")"));
		element.click();
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
