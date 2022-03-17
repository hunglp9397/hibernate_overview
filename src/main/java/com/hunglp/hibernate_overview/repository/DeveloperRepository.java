package com.hunglp.hibernate_overview.repository;

import com.hunglp.hibernate_overview.entity.one_to_one_share_primary_key.*;
import org.springframework.data.jpa.repository.*;

public interface DeveloperRepository extends JpaRepository<Developer,Long> {
}
