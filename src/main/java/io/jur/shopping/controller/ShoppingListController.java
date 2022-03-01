package io.jur.shopping.controller;

import io.jur.shopping.service.ShoppingListService;
import io.jur.shopping.service.dto.ShoppingItemDto;
import io.jur.shopping.service.dto.ShoppingItemInput;
import io.jur.shopping.service.dto.ShoppingListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shopping-list/{userId}")
@RequiredArgsConstructor
public class ShoppingListController {

    private final ShoppingListService shoppingListService;

    @GetMapping
    public ResponseEntity<ShoppingListDto> getShoppingList(@PathVariable Long userId) {
        return ResponseEntity.ok(shoppingListService.getShoppingListByUser(userId));
    }

    @PostMapping
    public ResponseEntity<Void> addItem(@PathVariable Long userId, @RequestBody ShoppingItemInput shoppingItem) {
        shoppingListService.addShoppingItem(userId, shoppingItem);
        return ResponseEntity.ok().build();
    }
}
