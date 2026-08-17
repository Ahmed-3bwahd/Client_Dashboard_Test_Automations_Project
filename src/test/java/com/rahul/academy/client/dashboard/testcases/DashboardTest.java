package com.rahul.academy.client.dashboard.testcases;

import com.rahul.academy.client.dashboard.base.BaseTest;
import com.rahul.academy.client.dashboard.pages.LoginPage;
import com.rahul.academy.client.dashboard.utils.ConfigUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    @Test(description = "Add a new product to the cart")
    @Feature("Add product to the cart feature")
    @Description("The user should be able to add a product into the cart")
    public void shouldBeAbleToAddProductToCart(){
        LoginPage loginPage = new LoginPage(driver);
        boolean isCartSectionLoaded = loginPage.loadApp()
                .enterCredentials(ConfigUtils.getInstance().getUserEmail(), ConfigUtils.getInstance().getUserPassword())
                .addProductToCart()
                .clickCartButton()
                .isCartSectionLoaded();
        Assert.assertTrue(isCartSectionLoaded);

    }
}
