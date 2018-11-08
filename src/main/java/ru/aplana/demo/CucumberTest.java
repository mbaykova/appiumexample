package ru.aplana.demo;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Baykova-MS on 16.01.2018.
 */


public abstract class CucumberTest extends AbstractTestNGCucumberTests {
    /**
     * Make the driver static. This allows it to be created only once
     * and used across all of the test classes.
     */
    public static AndroidDriver driver;



    /**
     * This method runs before any other method.
     *
     * Appium follows a client - server model:
     * We are setting up our appium client in order to connect to Device Farm's appium server.
     *
     * We do not need to and SHOULD NOT set our own DesiredCapabilities
     * Device Farm creates custom settings at the server level. Setting your own DesiredCapabilities
     * will result in unexpected results and failures.
     *
     * @throws MalformedURLException An exception that occurs when the URL is wrong
     */
    @BeforeSuite
    public void setUpAppium() throws MalformedURLException {

        //Определяем desired capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
//		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0.1");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
//		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "YT9113N0NB");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        caps.setCapability("appPackage", "ru.rzd.pass");
        caps.setCapability("appActivity", "ru.rzd.app.common.gui.SplashActivity");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
    }


    /**
     * Restart the app after every test class to go back to the main
     * screen and to reset the behavior
     */
    @AfterSuite
    public void restartApp() {
        driver.closeApp();
    }

}
