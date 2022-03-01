package io.jur.shopping.service.mapper;

import io.jur.shopping.domain.ShoppingList;
import io.jur.shopping.service.dto.ShoppingListDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = ShoppingItemMapper.class)
public interface ShoppingListMapper extends BaseEDMapper<ShoppingList, ShoppingListDto> {
}
