package Prasad.AppiumAutomationTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class SwipeGesture extends BaseTest {

	@Test
	public void scrollAction() {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		
		driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
		
		WebElement firstImage = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
		String focusable  = driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable");
		Assert.assertEquals(focusable, "true");
		String direction = "left";
		swipeGesture(firstImage,direction);
		String focusableValue  = driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable");
		Assert.assertEquals(focusableValue, "false");
	}
}
