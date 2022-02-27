package io.jur.shopping.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class ShoppingItem extends BaseEntity {
    private String name;
    private String description;
    private String productCode;
    private BigDecimal price;
    private Integer quantity;
    private BigDecimal subTotal;
    @ManyToOne
    @JoinColumn(name = "shopping_list_id")
    private ShoppingList shoppingList;
}
