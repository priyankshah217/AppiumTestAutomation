package com.test.apidemo.app.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.test.utils.AbstractScreen;

public class ScreenOrientationScreen extends AbstractScreen {

	private String sensorType;
	@AndroidFindBy(id = "io.appium.android.apis:id/orientation")
	private WebElement orientationMenu;

	@AndroidFindBy(id = "android:id/text1")
	private List<WebElement> orientationList;

	@AndroidFindBy(id = "android:id/action_bar_title")
	private WebElement actionBarTitle;

	public ScreenOrientationScreen(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		loadPage();
	}

	public ScreenOrientationScreen changeScreenOrientation(String sensorType) {
		this.sensorType = sensorType;
		orientationMenu.click();
		driver.scrollTo(sensorType).click();
		// if (!isElementPresent(By.name(sensorType))) {
		// TouchAction action = new TouchAction(driver);
		// action.press(245, 1637).waitAction(300).moveTo(245, 615).release()
		// .perform();
		// }
		// for (WebElement el : orientationList) {
		// if (el.getText().equals(sensorType)) {
		// el.click();
		// break;
		// }
		// }
		return this;
	}

	public boolean checkOrientationType() {
		boolean isPassed = false;
		if (orientationList.get(0).getText().equals(this.sensorType)) {
			isPassed = true;
		} else {
			takeScreenShot("InvalidOrientation");
		}
		return isPassed;
	}

	public boolean isItValidScreenOrientationPage() {
		boolean isPassed = false;
		if (actionBarTitle.getText().equals("App/Activity/Screen Orientation")) {
			isPassed = true;
		} else {
			takeScreenShot("InvalidSensor");
		}
		return isPassed;
	}
}
