package com.test.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractScreen {

	@AndroidFindBy(className = "android.webkit.WebView")
	private WebElement androidWebView;

	public AndroidDriver driver;

	public AbstractScreen(AndroidDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public void loadPage(){
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);		
	}

	protected boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public void rotateScreen() {
		driver.rotate(ScreenOrientation.LANDSCAPE);
		// TODO Auto-generated method stub
	}

	public void switchToWebView() {
		driver.manage()
				.timeouts()
				.implicitlyWait(AppUtils.DEFAULT_WAIT_TIME,
						TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,
				AppUtils.EXPLICIT_WAIT_TIME);
		wait.until(ExpectedConditions.visibilityOf(androidWebView));
		driver.manage()
				.timeouts()
				.implicitlyWait(AppUtils.EXPLICIT_WAIT_TIME,
						TimeUnit.SECONDS);

		Set<String> contextSet = driver.getContextHandles();
		for (String contextName : contextSet) {
			System.out.println(contextName);
			if (!contextName.contains("NATIVE_APP")) {
				driver.context(contextName);				
				break;
			}
		}
	}

	public void takeScreenShot(String fileName) {
		// TODO Auto-generated method stub
		File file = new File(fileName + ".png");
		File tmpFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(tmpFile, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
