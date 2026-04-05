package com.goosying.cucumber.pages;

import com.goosying.cucumber.common.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;


public class ProductsPage extends BasePage{

    private static final String PRODUCTS_URL =  "https://www.saucedemo.com/inventory.html";

    private static final By BUY_SAUCE_LABS_BACKPACK = By.id("add-to-cart-sauce-labs-backpack");
    private static final By BUY_SAUCE_LABS_BIKE_LIGHT = By.id("add-to-cart-sauce-labs-bike-light");
    private static final By BUY_SAUCE_LABS_BOLT_T_SHIRT = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private static final By SHOPPING_CART =  By.className("shopping_cart_link");
    private static final By SHOPPING_CART_BADGE = By.className("shopping_cart_badge");


    public ProductsPage(DriverManager driverManager) {
        super(driverManager);
    }

    public void BuyProduct(String productsName){
        switch (productsName){
            case "Sauce Labs Backpack" -> jsClick(waitForClickable(BUY_SAUCE_LABS_BACKPACK));
            case "Sauce Labs Bike Light" -> jsClick(waitForClickable(BUY_SAUCE_LABS_BIKE_LIGHT));
            case "Sauce Labs Bolt T-Shirt" -> jsClick(waitForClickable(BUY_SAUCE_LABS_BOLT_T_SHIRT));
            default -> throw new IllegalArgumentException("没有此商品");
        }
    }

    public int getShoppingCartBadge(){
        try {
            return Integer.parseInt(waitForVisible(SHOPPING_CART_BADGE).getText().trim());
        }catch (TimeoutException | NoSuchElementException | NumberFormatException e){
            return 0;
        }
    }

    public void clickCartItem(){
        waitForClickable(SHOPPING_CART).click();
    }
}
