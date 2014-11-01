package com.test.apidemo.app.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.test.utils.AbstractScreen;

public class AppActivityScreen extends AbstractScreen {

	@AndroidFindBy(id = "android:id/text1")
	private List<WebElement> activityList;

	public AppActivityScreen(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		loadPage();
	}

	public AppActivityScreen browseAppActivityScreen() {
		// TODO Auto-generated method stub

		// Swipe can be simulate using TouchAction

		// TouchAction action = new TouchAction(driver);
		// action.press(0, 1533).waitAction(900).moveTo(0, 219).release()
		// .perform();

		// Swipe can be simulate directly using AppiumDriver

		driver.swipe(0, 1533, 0, 219, 900);
		return this;
	}

	public ScreenOrientationScreen getScreenOrientationPage() {
		driver.scrollTo("Screen Orientation").click();
		// for (WebElement el : activityList) {
		// if (el.getText().equals("Screen Orientation")) {
		// el.click();
		// break;
		// }
		// }
		return new ScreenOrientationScreen(driver);
	}
}
