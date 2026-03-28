package com.goosying.cucumber.steps;

import com.goosying.cucumber.enums.LoginResult;
import com.goosying.cucumber.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.*;

public class LoginSteps {

    private final LoginPage loginPage;

    // picoContainer链式构造
    public LoginSteps(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    @Given("打开Swag Labs购物网")
    public void login() {
        loginPage.openLoginPage();
    }

    @Given("输入用户名:{string}，输入密码:{string}")
    public void inputUsernameAndPassword(String username, String password) {
        loginPage.inputUsernameAndPassword(username, password);
    }

    @When("点击登录按钮")
    public void clickLogin() {
        loginPage.clickLogin();
    }

    @Then("应该登录成功")
    public void assertLoginSuccess() {
        assertTrue(loginPage.isOnProductsPage(),"登录成功校验不通过");
    }

    @Then("应该看到:{string}")
    public void assertDifferentUserLogin(String expected) {
        LoginResult result = LoginResult.getByMessage(expected);
        switch (result){
            case SUCCESS -> assertTrue(loginPage.isOnProductsPage(),"登录成功校验不通过");
            case LOCKED -> assertTrue(loginPage.getErrorMessage().contains("locked out"),"用户锁定校验不通过");
            case INVALID -> assertTrue(loginPage.getErrorMessage().contains("Username and password do not match"),"用户名密码不匹配校验不通过");
        }

    }

}
