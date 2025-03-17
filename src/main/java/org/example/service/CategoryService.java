package org.example.service;

import org.example.dto.CategoryDTO;

import java.util.Set;

public interface CategoryService {
    CategoryDTO save(CategoryDTO categoryDTO);
    CategoryDTO update(CategoryDTO categoryDTO);
    CategoryDTO delete(Long id);
    CategoryDTO retrieveByName(String name);
    Set<CategoryDTO> retrieveAll();
}
