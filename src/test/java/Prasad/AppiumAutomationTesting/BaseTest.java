package Prasad.AppiumAutomationTesting;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	AndroidDriver driver;
	AppiumDriverLocalService as;

	@BeforeClass
	public void configureAppium() throws MalformedURLException {
		as = new AppiumServiceBuilder()
				.withAppiumJS(
						new File("\\Users\\prasa\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("0.0.0.0").usingPort(4723).build();
		as.start();
		UiAutomator2Options options = new UiAutomator2Options();

		options.setDeviceName("OnePlus CPH2487");

		options.setApp("\\Users\\prasa\\Downloads\\APKFiles\\resources\\ApiDemos-debug.apk");

		driver = new AndroidDriver(new URL("http://0.0.0.0:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void longPressGesture(WebElement ele) {
		driver.executeScript("mobile: longClickGesture ",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration", 2000));

	}

	@AfterClass()
	public void teardown() {
		driver.quit();
		as.stop();
	}
}
