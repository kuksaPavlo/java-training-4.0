package com.example.selenium;

import com.example.selenium.steps.UserSteps;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected WebDriver driver;
    protected UserSteps userSteps;
    UserSteps user;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriverManager.chromedriver().clearResolutionCache().setup();
        driver = WebDriverManager.chromedriver().create();
        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().window().setSize(new Dimension(900, 1100));
        user = new UserSteps(driver);
        // TODO initialize a driver, open login URL, resize windows, and initialize steps
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
            // TODO driver close and quit
        }
    }
}
