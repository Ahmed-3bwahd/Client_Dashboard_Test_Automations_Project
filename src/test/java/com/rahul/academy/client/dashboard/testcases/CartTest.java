package com.rahul.academy.client.dashboard.testcases;

import com.rahul.academy.client.dashboard.base.BaseTest;
import com.rahul.academy.client.dashboard.pages.LoginPage;
import com.rahul.academy.client.dashboard.utils.ConfigUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test(description = "Checkout and proceed with payment flow")
    @Feature("Add product to the cart feature")
    @Description("The user should be able to checkout and navigate to the payment")
    public void shouldBeAbleToCheckout() {
        LoginPage loginPage = new LoginPage(driver);
        boolean isPaymentLoaded=  loginPage.loadApp()
                .enterCredentials(ConfigUtils.getInstance().getUserEmail(), ConfigUtils.getInstance().getUserPassword())
                .addProductToCart()
                .clickCartButton()
                .clickCheckout()
                .isPaymentLoaded();

        Assert.assertTrue(isPaymentLoaded);
    }
}
