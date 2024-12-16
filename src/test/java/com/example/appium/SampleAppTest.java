package com.example.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.nio.file.Paths;

import static java.lang.System.getenv;

public class SampleAppTest {
    private AppiumDriverLocalService server;
    private AppiumDriver driver;

    @BeforeClass
    private void setUp() {
       String platform = getenv("APPIUM_DRIVER");
        platform = platform == null ? "ANDROID" : platform.toUpperCase();
        String path = System.getProperty("user.dir");

        if (platform.equals("ANDROID")) {
            var options = new UiAutomator2Options()
                    .setPlatformName("Android")
                    .setDeviceName("Pixel_9")
                    .setApp(Paths.get(path).resolve("ApiDemos-debug.apk").toString())
                    .setAppActivity(".view.TextFields")
                    .setShowChromedriverLog(true);

            server = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                    .usingPort(4723)
                    .withArgument(GeneralServerFlag.BASEPATH, "/wd/hub"));

            driver = new AndroidDriver(server, options);

            ((InteractsWithApps) driver).activateApp("io.appium.android.apis");
        } else {
            var options = new XCUITestOptions()
                    .setPlatformName("iOS")
                    .setPlatformVersion("18.0")
                    .setAutomationName("XCuiTest")
                    .setDeviceName("iPhone 16")
                    .setApp(Paths.get(path).resolve("TestApp.app.zip").toString())
                    .setShowXcodeLog(true);


            server = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                    .usingPort(4723)
                    .withArgument(GeneralServerFlag.BASEPATH, "/wd/hub"));

            server.start();
            System.out.println("Appium server started: " + server.isRunning());
            driver = new IOSDriver(server, options);
        }
    }

    @Test
    public void textFieldTest() {
        PageView view = new PageView(driver);// TODO initialise PageView and set "text" to its textField
        view.setTextField("test");

        Assert.assertEquals(view.getTextField(),"test", "test was not");// TODO assert that textField equals to "text"
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        if (server != null) {
            server.stop();
        }
    }
}
