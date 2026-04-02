package com.goosying.cucumber.steps;

import com.goosying.cucumber.pages.CartPage;
import io.cucumber.java.en.Then;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class CartSteps {
    private final CartPage cartPage;

    public CartSteps(CartPage cartPage) {
        this.cartPage = cartPage;
    }

    @Then("购物车中的商品及其价格应该是")
    public void assertCart(List<Map<String,String>> expCartList) {
        Set<Map<String, String>> expCart = new HashSet<>(expCartList);
        Set<Map<String, String>> realCart = cartPage.getCartItems();
        assertIterableEquals(expCart, realCart);
    }
}
