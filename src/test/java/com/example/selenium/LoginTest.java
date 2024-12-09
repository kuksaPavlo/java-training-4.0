package com.example.selenium;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void login() {
        user.login("tomsmith", "SuperSecretPassword!")
                .logout();
        // TODO use steps for the login and logout
    }
}
