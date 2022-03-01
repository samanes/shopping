package io.jur.shopping.service.mapper;

import io.jur.shopping.domain.ShoppingItem;
import io.jur.shopping.service.dto.ShoppingItemDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ShoppingItemMapper extends BaseEDMapper<ShoppingItem, ShoppingItemDto> {
    @Override
    @Mapping(target = "name", source = "entity.product.name")
    @Mapping(target = "description", source = "entity.product.description")
    ShoppingItemDto toDto(ShoppingItem entity);
}
