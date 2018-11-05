package ru.aplana.demo.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Maria on 05.11.2018.
 */
public class BaseSteps {

	private static AndroidDriver driver;

	public static AndroidDriver getDriver() {
		return driver;
	}

	@Before("@native")
	public void setUpNative() throws Exception {
		//Определяем desired capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0.1");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "YT9113N0NB");
		caps.setCapability("appPackage", "ru.rzd.pass");
		caps.setCapability("appActivity", "ru.rzd.app.common.gui.SplashActivity");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}


	@Before("@web")
	public void setUpWeb() throws Exception {
		//Определяем desired capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0.1");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "YT9113N0NB");
		caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}


	/* We disable the driver after EACH test has been executed. */
	@After("@native")
	public void teardown() {
		driver.closeApp();
	}

	@After("@web")
	public void tearDownWeb() {
		driver.quit();
	}
}
