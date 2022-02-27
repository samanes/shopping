package io.jur.shopping;

import io.jur.shopping.service.dto.ShoppingItemDto;
import io.jur.shopping.service.dto.ShoppingListDto;

import java.math.BigDecimal;
import java.util.Arrays;

public class ShoppingListTestData {
    public static ShoppingListDto getTestShoppingListData() {
        ShoppingListDto shoppingListDto = new ShoppingListDto();
        ShoppingItemDto shoppingItem1Dto = createShoppingItem("item1", "item1 description", 20, 1, 20);
        ShoppingItemDto shoppingItem2Dto = createShoppingItem("item2", "item2 description", 15, 2, 30);
        shoppingListDto.setShoppingItems(Arrays.asList(shoppingItem1Dto, shoppingItem2Dto));
        shoppingListDto.setTotal(BigDecimal.valueOf(50));
        return shoppingListDto;
    }

    private static ShoppingItemDto createShoppingItem(String name, String description, int price, int quantity, int subTotal) {
        ShoppingItemDto shoppingItemDto = new ShoppingItemDto();
        shoppingItemDto.setName(name);
        shoppingItemDto.setPrice(BigDecimal.valueOf(price));
        shoppingItemDto.setSubTotal(BigDecimal.valueOf(subTotal));
        shoppingItemDto.setQuantity(quantity);
        shoppingItemDto.setDescription(description);
        return shoppingItemDto;
    }
}
