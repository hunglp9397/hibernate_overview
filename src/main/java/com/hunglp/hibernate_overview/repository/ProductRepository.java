package com.hunglp.hibernate_overview.repository;

import com.hunglp.hibernate_overview.entity.many_to_many.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
