package io.jur.shopping.service;

import io.jur.shopping.ShoppingListTestData;
import io.jur.shopping.domain.ShoppingItem;
import io.jur.shopping.domain.ShoppingList;
import io.jur.shopping.repository.ShoppingListRepository;
import io.jur.shopping.service.dto.ShoppingListDto;
import io.jur.shopping.service.mapper.ShoppingListMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ShoppingListServiceTest {
    @Mock
    private ShoppingListRepository repository;

    @Mock
    private ShoppingListMapper mapper;

    @InjectMocks
    private ShoppingListService shoppingListService;

    @Test
    public void getShoppingList() {
        when(repository.findTopByUserIdAndActiveTrue(anyLong()))
                .thenReturn(getTestShoppingListData());
        when(mapper.toShoppingListDto(any()))
                .thenReturn(ShoppingListTestData.getTestShoppingListData());
        ShoppingListDto shoppingListByUser = shoppingListService.getShoppingListByUser(1L);
        assertThat(shoppingListByUser.getShoppingItems())
                .hasSize(2)
                .extracting("name")
                .contains("item1", "item2");
        assertEquals(BigDecimal.valueOf(50), shoppingListByUser.getTotal());
    }

    public ShoppingList getTestShoppingListData() {
        ShoppingList shoppingList = new ShoppingList();
        ShoppingItem shoppingItem1 = createShoppingItem("item1", "item1 description", 20, 1, 20);
        ShoppingItem shoppingItem2 = createShoppingItem("item2", "item2 description", 15, 2, 30);
        shoppingList.setShoppingItems(Arrays.asList(shoppingItem1, shoppingItem2));
        shoppingList.setId(1L);
        shoppingList.setTotal(BigDecimal.valueOf(50));
        return shoppingList;
    }

    private ShoppingItem createShoppingItem(String name, String description, int price, int quantity, int subTotal) {
        ShoppingItem shoppingItem = new ShoppingItem();
        shoppingItem.setName(name);
        shoppingItem.setPrice(BigDecimal.valueOf(price));
        shoppingItem.setSubTotal(BigDecimal.valueOf(subTotal));
        shoppingItem.setQuantity(quantity);
        shoppingItem.setDescription(description);
        return shoppingItem;
    }

}
