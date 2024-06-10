package Prasad.AppiumAutomationTesting;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class MiscellaneousActionExercise extends BaseTest {

	@Test
	public void Demo1() {

		driver.findElement(AppiumBy.accessibilityId("App")).click();
		driver.findElement(AppiumBy.accessibilityId("Action Bar")).click();
		driver.findElement(AppiumBy.accessibilityId("Display Options")).click();
		driver.findElement(AppiumBy.accessibilityId("DISPLAY_HOME_AS_UP")).click();
		String isEnabled = driver.findElement(AppiumBy.accessibilityId("Navigate up")).getAttribute("enabled");
		Assert.assertEquals(isEnabled, "true");

		driver.findElement(AppiumBy.accessibilityId("DISPLAY_SHOW_HOME")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//android.widget.ImageView")).isDisplayed());

		driver.findElement(AppiumBy.accessibilityId("DISPLAY_USE_LOGO")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//android.widget.ImageView")).isDisplayed());

		driver.findElement(AppiumBy.accessibilityId("Navigation")).click();
		driver.findElement(By.xpath(
				"//android.widget.HorizontalScrollView/android.widget.LinearLayout/android.app.ActionBar.Tab[1]"))
				.click();
		Assert.assertTrue(driver.findElement(By.xpath(
				"//android.widget.HorizontalScrollView/android.widget.LinearLayout/android.app.ActionBar.Tab[1]"))
				.isSelected());

		driver.findElement(By.xpath(
				"//android.widget.HorizontalScrollView/android.widget.LinearLayout/android.app.ActionBar.Tab[2]"))
				.click();
		Assert.assertTrue(driver.findElement(By.xpath(
				"//android.widget.HorizontalScrollView/android.widget.LinearLayout/android.app.ActionBar.Tab[2]"))
				.isSelected());

		driver.findElement(By.xpath(
				"//android.widget.HorizontalScrollView/android.widget.LinearLayout/android.app.ActionBar.Tab[3]"))
				.click();
		Assert.assertTrue(driver.findElement(By.xpath(
				"//android.widget.HorizontalScrollView/android.widget.LinearLayout/android.app.ActionBar.Tab[3]"))
				.isSelected());

	}

	@Test
	public void selectDialogBoxDemo() {
		do {
			driver.navigate().back();
		} while ((driver.findElements(AppiumBy.accessibilityId("App")).isEmpty()));
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with a message")).click();
		driver.findElement(By.id("android:id/button1")).click();
	}

	@Test
	public void selectListDemo() {
		do {
			driver.navigate().back();
		} while ((driver.findElements(AppiumBy.accessibilityId("App")).isEmpty()));
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		driver.findElement(AppiumBy.accessibilityId("List dialog")).click();
		driver.findElement(
				By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Command three\"]"))
				.click();
		String msg = driver.findElement(By.id("android:id/message")).getText();
		Assert.assertEquals(msg, "You selected: 2 , Command three");
	}

	@Test
	public void selectRadioButtonDemo() {
		do {
			driver.navigate().back();
		} while ((driver.findElements(AppiumBy.accessibilityId("App")).isEmpty()));
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		driver.findElement(AppiumBy.accessibilityId("Single choice list")).click();
		driver.findElement(
				By.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Satellite\"]"))
				.click();
		driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")).click();
		driver.findElement(AppiumBy.accessibilityId("Single choice list")).click();
		String isChecked = driver
				.findElement(By.xpath(
						"//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Satellite\"]"))
				.getAttribute("checked");
		String isChecked1 = driver
				.findElement(By.xpath(
						"//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Traffic\"]"))
				.getAttribute("checked");
		String isChecked2 = driver.findElement(By
				.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Street view\"]"))
				.getAttribute("checked");
		String isChecked3 = driver
				.findElement(By
						.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Map\"]"))
				.getAttribute("checked");
		Assert.assertEquals(isChecked, "true");
		Assert.assertEquals(isChecked1, "false");
		Assert.assertEquals(isChecked2, "false");
		Assert.assertEquals(isChecked3, "false");

	}

}
