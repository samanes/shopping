package io.jur.shopping.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class ShoppingListTest {

    @Test
    public void addOneShoppingItem_totalPrice_test() {
        ShoppingList shoppingList = new ShoppingList();
        shoppingList.addShoppingItem(createShoppingItem(10, 2));
        assertThat(shoppingList.getShoppingItems()).hasSize(1);
        assertThat(shoppingList.getTotal()).isEqualTo(BigDecimal.valueOf(20));
    }

    @Test
    public void addMultipleShoppingItems_totalPrice_test() {
        ShoppingList shoppingList = new ShoppingList();
        shoppingList.addShoppingItem(createShoppingItem(10, 2));
        shoppingList.addShoppingItem(createShoppingItem(30, 3));
        assertThat(shoppingList.getShoppingItems()).hasSize(2);
        assertThat(shoppingList.getTotal()).isEqualTo(BigDecimal.valueOf(110));
    }

    private ShoppingItem createShoppingItem(int price, int quantity) {
        ShoppingItem shoppingItem = new ShoppingItem();
        shoppingItem.setPrice(BigDecimal.valueOf(price));
        shoppingItem.setQuantity(quantity);
        return shoppingItem;
    }
}
