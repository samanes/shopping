package io.jur.shopping.service.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ShoppingItemInput {
    private BigDecimal price;
    private Integer quantity;
    private Long productId;
}
