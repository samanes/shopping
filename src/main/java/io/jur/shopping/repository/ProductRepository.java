package io.jur.shopping.repository;

import io.jur.shopping.domain.Product;
import io.jur.shopping.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
