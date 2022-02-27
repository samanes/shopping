package io.jur.shopping.service.mapper;

import io.jur.shopping.domain.ShoppingItem;
import io.jur.shopping.service.dto.ShoppingItemDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShoppingItemMapper {
    ShoppingItemDto toShoppingItemDto(ShoppingItem shoppingItem);
}
