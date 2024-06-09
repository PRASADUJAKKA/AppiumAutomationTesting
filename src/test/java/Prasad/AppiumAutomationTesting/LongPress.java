package Prasad.AppiumAutomationTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class LongPress extends BaseTest {

	@Test
	public void longPressAction() {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		;
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Expandable Lists\"]")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Custom Adapter\"]")).click();
		WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text=\"People Names\"]"));

		longPressGesture(ele);

		String menuText = driver
				.findElement(By.xpath(
						"//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Sample action\"]"))
				.getText();
		Assert.assertEquals(menuText, "Sample action");
		Assert.assertTrue(driver
				.findElement(By.xpath(
						"//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Sample action\"]"))
				.isDisplayed());
	}
}
