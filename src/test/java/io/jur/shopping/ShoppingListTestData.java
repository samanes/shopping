package io.jur.shopping;

import io.jur.shopping.domain.ShoppingItem;
import io.jur.shopping.service.dto.ShoppingItemDto;
import io.jur.shopping.service.dto.ShoppingListDto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

public class ShoppingListTestData {
    public static ShoppingListDto getTestShoppingListData() {
        ShoppingListDto shoppingListDto = new ShoppingListDto();
        ShoppingItemDto shoppingItem1Dto = getShoppingItemDto(1L, "item1", "item1 description", 20, 1, 20);
        ShoppingItemDto shoppingItem2Dto = getShoppingItemDto(2L, "item2", "item2 description", 15, 2, 30);
        shoppingListDto.setShoppingItems(new ArrayList<>(Arrays.asList(shoppingItem1Dto, shoppingItem2Dto)));
        shoppingListDto.setTotal(BigDecimal.valueOf(50));
        return shoppingListDto;
    }

    public static ShoppingItemDto getShoppingItemDto(Long id, String name, String description, int price, int quantity, int subTotal) {
        ShoppingItemDto shoppingItemDto = new ShoppingItemDto();
        shoppingItemDto.setId(id);
        shoppingItemDto.setName(name);
        shoppingItemDto.setPrice(BigDecimal.valueOf(price));
        shoppingItemDto.setSubTotal(BigDecimal.valueOf(subTotal));
        shoppingItemDto.setQuantity(quantity);
        shoppingItemDto.setDescription(description);
        return shoppingItemDto;
    }

    public static ShoppingItem getShoppingItem( int price, int quantity) {
        ShoppingItem shoppingItem = new ShoppingItem();
        shoppingItem.setPrice(BigDecimal.valueOf(price));
        shoppingItem.setQuantity(quantity);
        return shoppingItem;
    }
}
