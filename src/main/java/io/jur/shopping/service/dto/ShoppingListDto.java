package io.jur.shopping.service.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ShoppingListDto {
    private List<ShoppingItemDto> shoppingItems;
    private BigDecimal total;
}
