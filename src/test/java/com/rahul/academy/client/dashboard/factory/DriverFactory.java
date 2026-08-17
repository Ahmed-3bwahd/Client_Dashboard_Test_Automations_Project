package com.rahul.academy.client.dashboard.factory;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    private WebDriver driver;

    public DriverFactory initWebDriver() {

        String browser = System.getProperty("browser", "CHROME");

        switch (browser){
            case "CHROME":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("-incognito");
                driver= new ChromeDriver(chromeOptions);
                break;
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions= new FirefoxOptions();
                driver= new FirefoxDriver(firefoxOptions);
                break;
            default:
                throw new RuntimeException("the browser not found");
        }

        return this;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
