package Prasad.AppiumAutomationTesting;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
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

	public void scrollTillEndGesture() {
		boolean canScrollMore;
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap
					.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 5.0));
		} while (canScrollMore);

	}

	public void swipeGesture(WebElement firstImage, String direction) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
				((RemoteWebElement) firstImage).getId(), "direction", direction, "percent", 0.75));
	}
	
   public void dragDropDemo(WebElement dragElement) {
	   ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) dragElement).getId(),
			    "endX", 630,
			    "endY", 584
			));
   }

	@AfterClass()
	public void teardown() {
		driver.quit();
		as.stop();
	}
}
