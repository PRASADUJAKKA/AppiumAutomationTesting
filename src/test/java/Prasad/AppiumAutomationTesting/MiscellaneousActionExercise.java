package Prasad.AppiumAutomationTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

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

	@Test
	public void setDeviceRotationDemo() {
		do {
			driver.navigate().back();
			driver.activateApp("io.appium.android.apis");
		} while ((driver.findElements(AppiumBy.accessibilityId("Preference")).isEmpty()));

		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
		driver.findElement(By.xpath("//android.widget.CheckBox[@resource-id=\"android:id/checkbox\"]")).click();

		DeviceRotation dr = new DeviceRotation(0, 0, 90);
		driver.rotate(dr);
		driver.findElement(By.xpath(
				"//android.widget.ListView[@resource-id=\"android:id/list\"]/android.widget.LinearLayout[2]/android.widget.RelativeLayout"))
				.click();
		driver.findElement(By.id("android:id/edit")).click();
		driver.findElement(By.id("android:id/edit")).sendKeys("Prasad's wifi");
	}

	@Test
	public void keyEventsDemo() {
		do {
			driver.navigate().back();
			driver.activateApp("io.appium.android.apis");
		} while ((driver.findElements(AppiumBy.accessibilityId("Preference")).isEmpty()));

		driver.setClipboardText("Prasad's wifi");
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
		driver.findElement(By.xpath("//android.widget.CheckBox[@resource-id=\"android:id/checkbox\"]")).click();
		driver.findElement(By.xpath(
				"//android.widget.ListView[@resource-id=\"android:id/list\"]/android.widget.LinearLayout[2]/android.widget.RelativeLayout"))
				.click();
		driver.findElement(By.id("android:id/edit")).click();
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.findElement(By.id("android:id/button1")).click();
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		driver.activateApp("io.appium.android.apis");
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		
	}

}
