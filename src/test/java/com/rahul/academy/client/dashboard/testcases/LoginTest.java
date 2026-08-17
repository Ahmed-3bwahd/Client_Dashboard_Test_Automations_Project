package com.rahul.academy.client.dashboard.testcases;

import com.rahul.academy.client.dashboard.base.BaseTest;
import com.rahul.academy.client.dashboard.pages.LoginPage;
import com.rahul.academy.client.dashboard.utils.ConfigUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest {

    @Test(description = "Login with valid data")
    @Feature("Auth Feature")
    @Description("The user should be able to login successfully with valid email and password")
    public void shouldBeAbleToLogin(){

        LoginPage loginPage = new LoginPage(driver);
        boolean isProductsDisplayed = loginPage.loadApp()
                .enterCredentials(ConfigUtils.getInstance().getUserEmail(), ConfigUtils.getInstance().getUserPassword())
                .IsTheCardsDisplayed();
        Assert.assertTrue(isProductsDisplayed);
    }
}
