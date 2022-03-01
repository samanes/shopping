package io.jur.shopping.service.mapper;

import java.util.List;

public interface BaseEDMapper<E, D> {
    E toEntity(D dto);

    D toDto(E entity);
}
