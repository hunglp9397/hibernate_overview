package com.hunglp.hibernate_overview.repository;

import com.hunglp.hibernate_overview.entity.many_to_many.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
