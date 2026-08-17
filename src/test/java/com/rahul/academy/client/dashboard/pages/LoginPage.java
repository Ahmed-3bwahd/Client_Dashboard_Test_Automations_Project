package com.rahul.academy.client.dashboard.pages;

import com.rahul.academy.client.dashboard.base.BasePage;
import com.rahul.academy.client.dashboard.utils.ConfigUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[id=\"userEmail\"]")
    WebElement email;

    @FindBy(css = "[id=\"userPassword\"]")
    WebElement password;

    @FindBy(css = "[id=\"login\"]")
    WebElement loginButton;

    public LoginPage loadApp(){
        driver.get(ConfigUtils.getInstance().getBaseURL());
        return this;
    }

    public DashboardPage enterCredentials(String userEmail, String pass){
        email.sendKeys(userEmail);
        password.sendKeys(pass);
        loginButton.click();

        return new DashboardPage(driver);
    }

}
