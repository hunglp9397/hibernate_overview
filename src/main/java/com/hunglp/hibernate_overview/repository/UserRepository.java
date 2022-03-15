package com.hunglp.hibernate_overview.repository;

import com.hunglp.hibernate_overview.entity.one_to_one.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
