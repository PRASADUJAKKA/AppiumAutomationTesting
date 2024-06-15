package Prasad.AppiumAutomationTesting;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class EcommerceTestCase4 extends BaseTest2 {

	@Test
	public void addItemsToCartMultiple() throws InterruptedException {
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Australia']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Prasad Shanmukha Jakka");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Male']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();

		int addedSize = driver.findElements(By.xpath(
				"//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\" and @text=\"ADDED TO CART\"]"))
				.size();
		Assert.assertEquals(addedSize, 2);
	}

	@Test(dependsOnMethods = "addItemsToCartMultiple")
	public void goToCartAndAssertPrice() throws InterruptedException {
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(
				driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));

		double sum = 0;
		int countOfItems = driver
				.findElements(By.xpath(
						"//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productPrice\"]"))
				.size();
		for (int i = 0; i < countOfItems; i++) {
			String productPriceString = driver.findElements(By.xpath(
					"//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productPrice\"]"))
					.get(i).getText();
			Double oneItemPrice = formattedStringToDouble(productPriceString);
			sum += oneItemPrice;
		}
		String displayPrice = driver
				.findElement(By.xpath(
						"//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/totalAmountLbl\"]"))
				.getText();
		Double price = formattedStringToDouble(displayPrice);
		Assert.assertEquals(sum, price);

	}

	@Test(dependsOnMethods = "goToCartAndAssertPrice")
	public void submitOrder() throws InterruptedException {
		WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		longPressGesture(ele);
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(5000);
		driver.openNotifications();
		Thread.sleep(5000);
		Set<String> ss = driver.getContextHandles();
		for(String s1: ss) {
			System.out.println(s1);
		}
		driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElement(By.name("q")).sendKeys("Prasad Automation");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");
		
	}

}
