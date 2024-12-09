package com.example.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginPage extends BasePage {
        @FindBy(how = How.ID, using = "username")
        private WebElement username;
        @FindBy(how = How.ID, using = "password")
        private WebElement password;
        @FindBy(how = How.CSS, using = ".fa")
        private WebElement login;
    // TODO define username, password, and login WebElements using @FindBy ;
    private WebElement enterMessageField;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public LoginPage setUsername(String text) {
        username.sendKeys(text);
        //TODO set username
        return this;
    }
    public LoginPage setPassword(String text) {
        password.sendKeys(text);
        // TODO set password
        return this;
    }
    public MainPage clickLogin() {
        login.click();
        return new MainPage(driver);
    }
}
