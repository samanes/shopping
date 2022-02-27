package io.jur.shopping.service.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ShoppingItemDto {
    private String name;
    private String description;
    private String productCode;
    private BigDecimal price;
    private Integer quantity;
    private BigDecimal subTotal;
}
