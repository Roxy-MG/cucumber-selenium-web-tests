package com.goosying.cucumber.pages;

import com.goosying.cucumber.common.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    protected final WebDriver driver;
    protected WebDriverWait wait;

    protected BasePage(DriverManager driverManager) {
        this.driver = driverManager.getDriver();
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }

    // 等待单个元素可见，并返回元素
    protected WebElement waitForVisible(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    // 等待全部元素可见，并返回元素
    protected List<WebElement> waitForAllVisible(By by) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    // 等待单个元素可点击，并返回元素
    protected WebElement waitForClickable(By by) {
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    // 等待弹窗出现
    protected void waitForAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
    }

    // 确认页面
    protected boolean isCorrectPage(String url) {
        return driver.getCurrentUrl().contains(url);
    }
}
