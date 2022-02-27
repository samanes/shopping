package io.jur.shopping.controller;

import io.jur.shopping.domain.ShoppingList;
import io.jur.shopping.service.ShoppingListService;
import io.jur.shopping.service.dto.ShoppingListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shopping-list")
@RequiredArgsConstructor
public class ShoppingListController {

    private final ShoppingListService shoppingListService;

    @GetMapping("/{userId}")
    public ShoppingListDto getShoppingList(@PathVariable Long userId) {
        return shoppingListService.getShoppingListByUser(userId);
    }
}
