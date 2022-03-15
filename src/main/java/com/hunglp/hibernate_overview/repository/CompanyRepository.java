package com.hunglp.hibernate_overview.repository;

import com.hunglp.hibernate_overview.entity.one_to_many.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Long> {
}
