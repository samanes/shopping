package io.jur.shopping.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class Product extends BaseEntity {
    private String name;
    private String description;
}
