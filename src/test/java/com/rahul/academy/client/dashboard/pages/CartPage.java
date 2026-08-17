package com.rahul.academy.client.dashboard.pages;

import com.rahul.academy.client.dashboard.base.BasePage;
import com.rahul.academy.client.dashboard.utils.ConfigUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    By isCartSectionLoadedBy = By.cssSelector(".cartSection h3");

    @FindBy(css = ".cartSection h3")
    WebElement isCartSectionLoadedElement;

    @FindBy(css = ".totalRow button")
    WebElement checkoutButtonElement;

    public boolean isCartSectionLoaded() {
        wait.waitForVisibility(isCartSectionLoadedBy);
        return isCartSectionLoadedElement.isDisplayed();
    }

    public boolean isCartContainTheAddedProduct(){
        wait.waitForVisibility(isCartSectionLoadedBy);
        List<WebElement> cartProducts= driver.findElements(isCartSectionLoadedBy);
        boolean match= cartProducts.stream()
                .anyMatch(x ->
                        x.getText()
                        .equalsIgnoreCase(ConfigUtils.getInstance().getProductName()));
        return match;
    }

    public PaymentPage clickCheckout() {
        if(isCartContainTheAddedProduct()){
            checkoutButtonElement.click();
            return new PaymentPage(driver);
        }else{
            throw new RuntimeException("the added product not found in the cart");
        }
    }
}
