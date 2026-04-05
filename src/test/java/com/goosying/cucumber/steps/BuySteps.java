package com.goosying.cucumber.steps;

import com.goosying.cucumber.pages.ProductsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.*;

public class BuySteps {

    private final ProductsPage productsPage;

    public BuySteps(ProductsPage productsPage) {
        this.productsPage = productsPage;
    }

    @When("点击购买:{string}")
    public void addToCart(String productName) throws InterruptedException {
        productsPage.BuyProduct(productName);
        Thread.sleep(500);
    }

    @Then("购物车数量显示为:{int}")
    public void assertShoppingCartBadge(int badge) {
        assertEquals(badge, productsPage.getShoppingCartBadge(), "购物车角标数量校验失败");
    }

    @When("点击购物车图标")
    public void clickShoppingCart() {
        productsPage.clickCartItem();
    }
}
