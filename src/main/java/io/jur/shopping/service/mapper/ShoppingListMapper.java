package io.jur.shopping.service.mapper;

import io.jur.shopping.domain.ShoppingList;
import io.jur.shopping.service.dto.ShoppingListDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShoppingListMapper {

    ShoppingListDto toShoppingListDto(ShoppingList shoppingList);
}
