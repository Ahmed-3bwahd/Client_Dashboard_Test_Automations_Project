package com.rahul.academy.client.dashboard.pages;

import com.rahul.academy.client.dashboard.base.BasePage;
import com.rahul.academy.client.dashboard.utils.ConfigUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DashboardPage extends BasePage {

    private WebElement getProduct;

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".mb-3")
    WebElement productCard;

    @FindBy(css = "button[routerlink*='cart']")
    WebElement cartButtonBy;

    By productCardBy = By.cssSelector(".mb-3");
    By productNameBy= By.cssSelector("h5 b");
    By addToCartButtonBy = By.cssSelector(".btn.w-10.rounded");
    By sniperBy = By.cssSelector(".ng-animating");
    By successAddProductMessageBy= By.cssSelector("[id=\"toast-container\"]");

    public boolean IsTheCardsDisplayed(){
        wait.waitForVisibility(productCard);
        return productCard.isDisplayed();
    }

    public DashboardPage addProductToCart() {
        getSpecificProduct();
        getProduct.findElement(addToCartButtonBy).click();
        return this;
    }

    public CartPage clickCartButton() {
        //wait until the adding product success message is displayed and the sniper is hidden
        wait.waitForVisibility(successAddProductMessageBy);
        wait.waitForInvisibility(sniperBy);
        cartButtonBy.click();

        return new CartPage(driver);
    }

    public void getSpecificProduct() {
        wait.waitForVisibility(productCard);
        List<WebElement> cardProducts = driver.findElements(productCardBy);
        getProduct = cardProducts.stream()
                .filter(x ->
                        x.findElement(productNameBy)
                        .getText()
                        .contains(ConfigUtils.getInstance().getProductName()))
                .findFirst()
                .orElse(null);
    }

}
