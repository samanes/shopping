package io.jur.shopping.service.mapper;

import io.jur.shopping.domain.ShoppingItem;
import io.jur.shopping.repository.ProductRepository;
import io.jur.shopping.service.dto.ShoppingItemDto;
import io.jur.shopping.service.dto.ShoppingItemInput;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", uses = {ProductRepository.class})
public abstract class InputShoppingItemMapper implements BaseEDMapper<ShoppingItem, ShoppingItemInput> {
    @Autowired
    protected ProductRepository productRepository;

    @Override
    @Mapping(target = "product", expression = "java(productRepository.getById(dto.getProductId()))")
    public abstract ShoppingItem toEntity(ShoppingItemInput dto);
}
