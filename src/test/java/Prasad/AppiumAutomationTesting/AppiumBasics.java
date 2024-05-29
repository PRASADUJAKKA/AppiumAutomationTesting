package Prasad.AppiumAutomationTesting;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumBasics {
	@Test
	public void AppiumTest1() throws MalformedURLException, URISyntaxException, InterruptedException {

		AppiumDriverLocalService as = new AppiumServiceBuilder()
				.withAppiumJS(
						new File("\\Users\\prasa\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("0.0.0.0").usingPort(4723).build();
		as.start();
		UiAutomator2Options options = new UiAutomator2Options();

		options.setDeviceName("OnePlus CPH2487");

		options.setApp("\\Users\\prasa\\Downloads\\APKFiles\\resources\\ApiDemos-debug.apk");

		AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723"), options);

		driver.findElement(AppiumBy.accessibilityId("Preference")).click();

		driver.findElement(AppiumBy.accessibilityId("9. Switch")).click();

		driver.findElement(By.xpath(
				"//android.widget.TextView[@resource-id=\"android:id/summary\" and @text=\"This is a switch with custom text\"]"))
				.click();

		driver.quit();
		as.stop();

	}
}
