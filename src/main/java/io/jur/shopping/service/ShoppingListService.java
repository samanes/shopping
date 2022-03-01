package io.jur.shopping.service;

import io.jur.shopping.domain.ShoppingItem;
import io.jur.shopping.domain.ShoppingList;
import io.jur.shopping.repository.ShoppingItemRepository;
import io.jur.shopping.repository.ShoppingListRepository;
import io.jur.shopping.repository.UserRepository;
import io.jur.shopping.service.dto.ShoppingItemInput;
import io.jur.shopping.service.dto.ShoppingListDto;
import io.jur.shopping.service.mapper.InputShoppingItemMapper;
import io.jur.shopping.service.mapper.ShoppingListMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ShoppingListService {

    private final ShoppingListRepository shoppingListRepository;
    private final ShoppingItemRepository shoppingItemRepository;
    private final UserRepository userRepository;
    private final ShoppingListMapper shoppingListMapper;
    private final InputShoppingItemMapper shoppingItemMapper;

    public ShoppingListDto getShoppingListByUser(Long userId) {
        ShoppingList shoppingList = shoppingListRepository.findTopByUserIdAndActiveTrue(userId);
        ShoppingListDto shoppingListDto = shoppingListMapper.toDto(shoppingList);
        return shoppingListDto;
    }

    @Transactional
    public void addShoppingItem(Long userId, ShoppingItemInput shoppingItemInput) {
        ShoppingList shoppingList = fetchShoppingList(userId);
        ShoppingItem shoppingItem = shoppingItemMapper.toEntity(shoppingItemInput);
        shoppingList.addShoppingItem(shoppingItem);
        shoppingListRepository.save(shoppingList);
    }

    @Transactional
    public void removeShoppingItem(Long userId, Long itemId) {
        ShoppingList shoppingList = shoppingListRepository.findTopByUserIdAndActiveTrue(userId);
        shoppingList.removeShoppingItem(itemId);
        shoppingItemRepository.deleteById(itemId);
        shoppingListRepository.save(shoppingList);
    }

    private ShoppingList fetchShoppingList(Long userId) {
        ShoppingList shoppingList = shoppingListRepository.findTopByUserIdAndActiveTrue(userId);
        if (shoppingList == null) {
            shoppingList = new ShoppingList();
            shoppingList.setUser(userRepository.getById(userId));
        }
        return shoppingList;
    }
}
