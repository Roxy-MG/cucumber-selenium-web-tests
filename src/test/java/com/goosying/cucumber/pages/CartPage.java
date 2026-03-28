package com.goosying.cucumber.pages;

import com.goosying.cucumber.common.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class CartPage extends BasePage{

    private static final String ITEM_NAMES =  "inventory_item_name";
    private static final String ITEM_PRICES = "inventory_item_price";

    public CartPage(DriverManager driverManager) {
        super(driverManager);
    }

    public Set<Map<String, String>> getCartItems(){
        try {
            List<WebElement> itemNames = waitForAllVisible(By.className(ITEM_NAMES));
            List<WebElement> itemPrices = waitForAllVisible(By.className(ITEM_PRICES));
            assertEquals(itemNames.size(), itemPrices.size(), "商品数量与商品价格数量数据不一致");
            Set<Map<String, String>> itemSet = new HashSet<>();
            for (int i = 0; i < itemNames.size(); i++) {
                Map<String, String> itemMap = new HashMap<>();
                itemMap.put("itemName", itemNames.get(i).getText());
                itemMap.put("itemPrice", itemPrices.get(i).getText());
                itemSet.add(itemMap);
            }
            return itemSet;
        } catch (TimeoutException e){
            return new HashSet<>();
        }
    }
}
