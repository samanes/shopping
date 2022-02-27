package io.jur.shopping.service;

import io.jur.shopping.domain.ShoppingList;
import io.jur.shopping.repository.ShoppingListRepository;
import io.jur.shopping.service.dto.ShoppingItemDto;
import io.jur.shopping.service.dto.ShoppingListDto;
import io.jur.shopping.service.mapper.ShoppingListMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ShoppingListService {

    private final ShoppingListRepository shoppingListRepository;
    private final ShoppingListMapper shoppingListMapper;

    public ShoppingListDto getShoppingListByUser(Long userId) {
        ShoppingList shoppingList = shoppingListRepository.findTopByUserIdAndActiveTrue(userId);
        ShoppingListDto shoppingListDto = shoppingListMapper.toShoppingListDto(shoppingList);
        calculateTotal(shoppingListDto);
        return shoppingListDto;
    }

    private void calculateTotal(ShoppingListDto shoppingListDto) {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (ShoppingItemDto shoppingItem : shoppingListDto.getShoppingItems()) {
            BigDecimal subTotal = shoppingItem.getPrice().multiply(BigDecimal.valueOf(shoppingItem.getQuantity()));
            shoppingItem.setSubTotal(subTotal);
            totalPrice = totalPrice.add(subTotal);
        }
        shoppingListDto.setTotal(totalPrice);
    }
}
