package com.rahul.academy.client.dashboard.testcases;

import com.rahul.academy.client.dashboard.base.BaseTest;
import com.rahul.academy.client.dashboard.pages.LoginPage;
import com.rahul.academy.client.dashboard.utils.ConfigUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PaymentTest extends BaseTest {

    @Test(description = "Complete the payment process")
    @Feature("Payment Feature")
    @Description("The user should be able to complete the payment process")
    public void shouldBeAbleToCompletePayment() {
        LoginPage loginPage = new LoginPage(driver);
        boolean isPaymentCompleted=  loginPage.loadApp()
                .enterCredentials(ConfigUtils.getInstance().getUserEmail(), ConfigUtils.getInstance().getUserPassword())
                .addProductToCart()
                .clickCartButton()
                .clickCheckout()
                .enterCountryName()
                .selectSpecificCountry()
                .clickPlaceOrderButton()
                .isPaymentCompleted();

        Assert.assertTrue(isPaymentCompleted);
    }
}
