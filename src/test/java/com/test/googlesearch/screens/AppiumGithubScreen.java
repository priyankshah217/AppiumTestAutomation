package com.test.googlesearch.screens;

import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.test.utils.AbstractScreen;

public class AppiumGithubScreen extends AbstractScreen {

	@FindBy(partialLinkText = "View all issues")
	private WebElement viewAllIssuesLink;

	@FindBy(linkText = "▶")
	private WebElement nextIssuePageLink;

	public AppiumGithubScreen(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		loadPage();
	}

	public AppiumGithubScreen viewAllIssues() {
		viewAllIssuesLink.click();
		return this;
	}

	public void navigateToIssue() {		
			nextIssuePageLink.click();
	}

	public AppiumGithubScreen zoomInWebPage() {
		// TODO Auto-generated method stub

		// With multi touch

		TouchAction action1 = new TouchAction(driver);
		TouchAction action2 = new TouchAction(driver);
		action1.press(620, 885).waitAction(300).moveTo(620, 590).release();
		action2.press(620, 885).waitAction(300).moveTo(620, 1408).release();
		MultiTouchAction multiTouchActions = new MultiTouchAction(driver);
		multiTouchActions.add(action1).add(action2).perform();

		// With zoom functions

		// driver.zoom(620, 885);
		// driver.zoom(620, 1408);
		// driver.zoom(620, 590);
		return this;
	}

	public AppiumGithubScreen zoomOutWebPage() {
		// TODO Auto-generated method stub
		return this;
	}
}
