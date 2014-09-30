package com.test.googlesearch.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppiumGithubScreen extends AbstractScreen {

	@FindBy(partialLinkText = "View all issues")
	private WebElement viewAllIssuesLink;

	@FindBy(linkText = "▶")
	private WebElement nextIssuePageLink;

	public AppiumGithubScreen(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	public AppiumGithubScreen viewAllIssues() {
		viewAllIssuesLink.click();
		return this;
	}

	public void navigateToIssue(String issueNo) {
		if (!isElementPresent(By.name(issueNo))) {
			nextIssuePageLink.click();
		}
	}

	public AppiumGithubScreen zoomInWebPage() {
		// TODO Auto-generated method stub
		TouchAction action1 = new TouchAction(driver);
		TouchAction action2 = new TouchAction(driver);
		action1.press(620, 885).waitAction(300).moveTo(620, 590).release();
		action1.press(620, 885).waitAction(300).moveTo(620, 1408).release();
		MultiTouchAction multiTouchActions = new MultiTouchAction(driver);
		multiTouchActions.add(action1).add(action2).perform();
		return this;
	}

	public AppiumGithubScreen zoomOutWebPage() {
		// TODO Auto-generated method stub
		return this;
	}	
}
