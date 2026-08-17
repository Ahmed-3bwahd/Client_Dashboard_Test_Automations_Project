package com.rahul.academy.client.dashboard.base;

import com.rahul.academy.client.dashboard.factory.DriverFactory;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void intWebDriver(){
        driver = new DriverFactory().initWebDriver().getDriver();
    }

    @AfterMethod
    public void quitDriver(ITestResult result){
        String testCaseName= result.getMethod().getMethodName();
        File file = new File("target" + File.separator + "screenshots" + File.separator + testCaseName+ ".PNG");
        takeScreenShot(file);

        driver.quit();
    }

    public void takeScreenShot(File destfile) {

        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, destfile);

            InputStream inputStream = new FileInputStream(destfile);
            Allure.addAttachment("screenshot", inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
