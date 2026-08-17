package com.rahul.academy.client.dashboard.base;

import com.rahul.academy.client.dashboard.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected WaitUtils wait;

    public BasePage (WebDriver driver){
        this.driver = driver;
        this.wait = new WaitUtils(driver);
        PageFactory.initElements(driver, this);
    }
}
