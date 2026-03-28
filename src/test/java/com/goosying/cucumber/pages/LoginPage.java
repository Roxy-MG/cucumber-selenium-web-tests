package com.goosying.cucumber.pages;

import com.goosying.cucumber.common.DriverManager;
import com.goosying.cucumber.utils.ConfigReader;
import org.openqa.selenium.By;


public class LoginPage extends BasePage{



    private static final String LOGIN_URL =  ConfigReader.getConfig("login.url");
    private static final String PRODUCTS_URL =  ConfigReader.getConfig("production.url");

    private static final By USERNAME_INPUT = By.id("user-name");
    private static final By PASSWORD_INPUT = By.id("password");
    private static final By LOGIN_BUTTON = By.id("login-button");
    private static final By ERROR_MESSAGE = By.tagName("h3");

    public LoginPage(DriverManager driverManager) {
        super(driverManager);
    }

    public void openLoginPage(){
        driver.get(LOGIN_URL);
    }

    public void inputUsernameAndPassword(String username, String password){
        waitForVisible(USERNAME_INPUT).sendKeys(ConfigReader.getConfig(username+".username"));
        waitForVisible(PASSWORD_INPUT).sendKeys(ConfigReader.getConfig(password+".password"));
    }

    public void clickLogin(){
        waitForClickable(LOGIN_BUTTON).click();
    }

    public boolean isOnProductsPage(){
        return isCorrectPage(PRODUCTS_URL);
    }

    public void clearUsernameAndPassword(){
        waitForVisible(USERNAME_INPUT).clear();
        waitForVisible(PASSWORD_INPUT).clear();
    }

    public String getErrorMessage(){
        System.out.println(driver.findElement(By.tagName("h3")).getText());
        return waitForVisible(ERROR_MESSAGE).getText();
    }

}
