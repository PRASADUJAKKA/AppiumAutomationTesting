package Prasad.AppiumAutomationTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class EcommerceTestCase3 extends BaseTest2 {

	@Test
	public void addItemsToCart() throws InterruptedException {
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Australia']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Prasad Shanmukha Jakka");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Male']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"LeBron Soldier 12 \"));"));

		int count = driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).size();

		for (int i = 0; i < count; i++) {
			String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i)
					.getText();
			if (productName.equalsIgnoreCase("LeBron Soldier 12 ")) {
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();

			}
		}

	}

	@Test(dependsOnMethods = "addItemsToCart")
	public void goToCart() throws InterruptedException {
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(
				driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));

		String price = driver
				.findElement(By.xpath(
						"//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/totalAmountLbl\"]"))
				.getText();
		Assert.assertEquals(price, "$ 130.0");
		Thread.sleep(3000);
	}
}
