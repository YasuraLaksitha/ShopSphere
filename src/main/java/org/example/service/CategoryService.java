package org.example.service;

import org.example.dto.CategoryDTO;
import org.example.dto.CategoryPaginationResponseDTO;

public interface CategoryService {
    CategoryDTO save(CategoryDTO categoryDTO);

    CategoryDTO update(CategoryDTO categoryDTO);

    CategoryDTO delete(String name);

    CategoryDTO retrieveByName(String name);

    CategoryPaginationResponseDTO retrieveAll(Integer page, Integer size, String sortBy, String sortDir);
}
