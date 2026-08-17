package com.rahul.academy.client.dashboard.pages;

import com.rahul.academy.client.dashboard.base.BasePage;
import com.rahul.academy.client.dashboard.utils.ConfigUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PaymentPage extends BasePage {

    private WebElement getSpecificCountry;

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    By isPaymentLoadedBy= By.cssSelector(".payment__info");
    By countryListBy= By.cssSelector(".ta-results");
    By countryListItemBy= By.cssSelector(".ta-item");
    By completePaymentBy= By.cssSelector(".hero-primary");

    @FindBy(className = "payment__info")
    WebElement isPaymentLoadedElement;

    @FindBy(css = "[placeholder='Select Country']")
    WebElement enterCountryFieldElement;

    @FindBy(css = ".action__submit")
    WebElement placeOrderButtonElement;

    @FindBy(className = "hero-primary")
    WebElement completePaymentElement;


    public boolean isPaymentLoaded(){
        wait.waitForVisibility(isPaymentLoadedBy);
        return isPaymentLoadedElement.isDisplayed();
    }

    public PaymentPage enterCountryName() {
        wait.waitForVisibility(isPaymentLoadedBy);
        enterCountryFieldElement.sendKeys(ConfigUtils.getInstance().getCountryName());
        return this;
    }

    public PaymentPage selectSpecificCountry() {
        getSpecificCountry();
        getSpecificCountry.click();
        return this;
    }

    public PaymentPage clickPlaceOrderButton() {
        placeOrderButtonElement.click();
        return this;
    }

    public boolean isPaymentCompleted(){
        wait.waitForVisibility(completePaymentBy);
        return completePaymentElement.isDisplayed();
    }

    public void getSpecificCountry() {
        wait.waitForVisibility(countryListBy);
        List<WebElement> countries = driver.findElements(countryListItemBy);
        getSpecificCountry = countries.stream()
                .filter(x-> x.getText()
                        .equalsIgnoreCase(ConfigUtils.getInstance().getCountryName()))
                .findFirst()
                .orElse(null);
    }


}
