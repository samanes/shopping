package io.jur.shopping.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@Entity
public class ShoppingList extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserInfo user;
    @OneToMany(mappedBy = "shoppingList", cascade = CascadeType.MERGE)
    private List<ShoppingItem> shoppingItems;
    private String description;
    private boolean active;
    private BigDecimal total;

    public void addShoppingItem(ShoppingItem shoppingItem) {
        if (shoppingItems == null) {
            this.shoppingItems = new ArrayList<>();
        }
        shoppingItems.add(shoppingItem);
        total = calculateTotal();
        shoppingItem.setShoppingList(this);
    }

    private BigDecimal calculateTotal() {
        return shoppingItems.stream()
                .map(item -> item.getSubTotal())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
