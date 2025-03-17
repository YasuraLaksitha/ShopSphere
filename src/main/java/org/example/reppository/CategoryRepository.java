package org.example.reppository;

import org.example.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<CategoryEntity,Long> {
}
