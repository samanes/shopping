package io.jur.shopping.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity
public class ShoppingList extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserInfo user;
    @OneToMany(mappedBy = "shoppingList")
    private List<ShoppingItem> shoppingItems;
    private String description;
    private boolean active;
    private BigDecimal total;
}
