package io.jur.shopping.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class ShoppingItemTest {
    @Test
    public void calcSubtotal_nullPrice_test() {
        ShoppingItem shoppingItem = new ShoppingItem();
        shoppingItem.setQuantity(5);
        assertThat(shoppingItem.getSubTotal())
                .isEqualTo(BigDecimal.ZERO);
    }

    @Test
    public void calcSubtotal_nullQuantity_test() {
        ShoppingItem shoppingItem = new ShoppingItem();
        shoppingItem.setPrice(BigDecimal.valueOf(10));
        assertThat(shoppingItem.getSubTotal())
                .isEqualTo(BigDecimal.ZERO);
    }

    @Test
    public void calcSubtotal_test() {
        ShoppingItem shoppingItem = new ShoppingItem();
        shoppingItem.setPrice(BigDecimal.valueOf(10));
        shoppingItem.setQuantity(4);
        assertThat(shoppingItem.getSubTotal())
                .isEqualTo(BigDecimal.valueOf(40));
    }
}
