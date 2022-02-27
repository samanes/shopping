package io.jur.shopping.repository;

import io.jur.shopping.domain.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingListRepository extends JpaRepository<ShoppingList, Long> {
    ShoppingList findTopByUserIdAndActiveTrue(Long userId);
}
