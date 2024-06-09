package Prasad.AppiumAutomationTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class ScrollGesture extends BaseTest {

	@Test
	public void scrollAction() {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		//Prior method when we know the till which element to scroll
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
		
		//Prior method when we don't know the till which element to scroll
		scrollTillEndGesture();
	}
}
