package io.jur.shopping.service;

import io.jur.shopping.ShoppingListTestData;
import io.jur.shopping.domain.Product;
import io.jur.shopping.domain.ShoppingItem;
import io.jur.shopping.domain.ShoppingList;
import io.jur.shopping.repository.ShoppingListRepository;
import io.jur.shopping.service.dto.ShoppingItemInput;
import io.jur.shopping.service.dto.ShoppingListDto;
import io.jur.shopping.service.mapper.InputShoppingItemMapper;
import io.jur.shopping.service.mapper.ShoppingListMapper;
import liquibase.pro.packaged.B;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ShoppingListServiceTest {
    @Mock
    private ShoppingListRepository repository;

    @Mock
    private ShoppingListMapper shoppingListMapper;

    @Mock
    private InputShoppingItemMapper shoppingItemMapper;

    @InjectMocks
    private ShoppingListService shoppingListService;

    @Test
    public void getShoppingList() {
        when(repository.findTopByUserIdAndActiveTrue(anyLong()))
                .thenReturn(getTestShoppingListData());
        when(shoppingListMapper.toDto(any()))
                .thenReturn(ShoppingListTestData.getTestShoppingListData());
        ShoppingListDto shoppingListByUser = shoppingListService.getShoppingListByUser(1L);
        assertThat(shoppingListByUser.getShoppingItems())
                .hasSize(2)
                .extracting("name")
                .contains("item1", "item2");
        assertEquals(BigDecimal.valueOf(50), shoppingListByUser.getTotal());
    }

    @Test
    public void addShoppingItem_test() {
        when(repository.findTopByUserIdAndActiveTrue(anyLong()))
                .thenReturn(getTestShoppingListData());
        when(shoppingItemMapper.toEntity(any())).thenReturn(createShoppingItem());
        when(repository.save(any(ShoppingList.class))).thenReturn(getTestShoppingListData());

        shoppingListService.addShoppingItem(1L, createShoppingItemInput());

        verify(repository, times(1)).save(any());
    }

    private ShoppingItem createShoppingItem() {
        ShoppingItem shoppingItem = new ShoppingItem();
        shoppingItem.setId(1L);
        shoppingItem.setPrice(BigDecimal.valueOf(10));
        shoppingItem.setQuantity(2);
        Product product = new Product();
        product.setId(1L);
        shoppingItem.setProduct(product);
        return shoppingItem;
    }

    private ShoppingItemInput createShoppingItemInput() {
        ShoppingItemInput shoppingItemInput = new ShoppingItemInput();
        shoppingItemInput.setProductId(1L);
        shoppingItemInput.setQuantity(2);
        shoppingItemInput.setPrice(BigDecimal.valueOf(10));
        return shoppingItemInput;
    }

    private ShoppingList getTestShoppingListData() {
        ShoppingList shoppingList = new ShoppingList();
        ShoppingItem shoppingItem1 = createShoppingItemInput(20, 1);
        ShoppingItem shoppingItem2 = createShoppingItemInput(15, 2);
        shoppingList.setShoppingItems(new ArrayList<>(Arrays.asList(shoppingItem1, shoppingItem2)));
        shoppingList.setId(1L);
        shoppingList.setTotal(BigDecimal.valueOf(50));
        return shoppingList;
    }

    private ShoppingItem createShoppingItemInput(int price, int quantity) {
        ShoppingItem shoppingItem = new ShoppingItem();
        shoppingItem.setPrice(BigDecimal.valueOf(price));
        Product product = new Product();
        product.setId(1L);
        shoppingItem.setProduct(product);
        shoppingItem.setQuantity(quantity);
        return shoppingItem;
    }

}
