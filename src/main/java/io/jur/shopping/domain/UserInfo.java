package io.jur.shopping.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class UserInfo extends BaseEntity {
    private String username;
    private String firstName;
    private String lastName;
}
