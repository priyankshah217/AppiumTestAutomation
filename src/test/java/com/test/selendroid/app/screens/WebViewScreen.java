package com.test.selendroid.app.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class WebViewScreen extends AbstractScreen {

	@AndroidFindBy(id = "android:id/text1")
	private WebElement selectItemFromList;

	@AndroidFindBy(id = "android:id/text1")
	private List<WebElement> optionList;

	@AndroidFindBy(uiAutomator = "new UiSelector().testContains(\"iframes\")")
	private WebElement iFrameOption;

	@AndroidFindBy(className = "android.widget.EditText")
	private WebElement enterNameText;

	@AndroidFindBy(className = "android.widget.Button")
	private List<WebElement> buttonList;

	@AndroidFindBy(id = "io.selendroid.testapp:id/mainWebView")
	private WebElement mainWebView;

	public WebViewScreen(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public WebViewScreen selectOptionFromList() {
		selectItemFromList.click();
		optionList.get(0).click();
		enterNameText.clear();
		enterNameText.sendKeys("abc@abc.com");
		buttonList.get(1).click();
		return this;
	}

}