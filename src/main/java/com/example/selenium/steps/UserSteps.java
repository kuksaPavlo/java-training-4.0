package com.example.selenium.steps;

import com.example.selenium.pages.LoginPage;
import com.example.selenium.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;

public class UserSteps {
    MainPage mainPage;
    LoginPage loginPage;
    private WebDriver driver;
    public UserSteps(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public UserSteps login(String username, String password) {
        // TODO initialize LoginPage, call setUsername, setPassword, and click login methods
        loginPage = new LoginPage(driver);
        mainPage = loginPage.setUsername(username)
                .setPassword(password)
                .clickLogin();

        if (mainPage == null) {
            throw new AssertionError("Failed to navigate to main page after login");
        }

        //  TODO assert title
        assertEquals(mainPage.getTitle(), "Secure Area", "Login failed");
        return this;
    }

    public UserSteps logout() {
        mainPage.clickLogout(); // TODO call logout method
        return this;
    }
}
