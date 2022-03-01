package io.jur.shopping.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Getter
@Entity
public class ShoppingItem extends BaseEntity {
    private BigDecimal price;
    private Integer quantity;
    private BigDecimal subTotal = BigDecimal.ZERO;

    @ManyToOne
    @JoinColumn(name = "shopping_list_id")
    @Setter
    private ShoppingList shoppingList;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @Setter
    private Product product;

    public void setPrice(BigDecimal price) {
        this.price = price;
        if (quantity != null) {
            subTotal = calculateSubtotal();
        }
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
        if (price != null) {
            subTotal = calculateSubtotal();
        }
    }

    private BigDecimal calculateSubtotal() {
        return price.multiply(BigDecimal.valueOf(quantity));
    }
}
