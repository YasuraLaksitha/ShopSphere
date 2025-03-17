package org.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.dto.CategoryDTO;
import org.example.dto.CategoryPaginationResponseDTO;
import org.example.entity.CategoryEntity;
import org.example.exceptions.ResourceNotFoundException;
import org.example.reppository.CategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;
    private final ObjectMapper mapper;

    @Override
    public CategoryDTO save(CategoryDTO categoryDTO) {
        final CategoryEntity saved = repository.save(mapper.convertValue(categoryDTO, CategoryEntity.class));
        return mapper.convertValue(saved, CategoryDTO.class);
    }

    @Override
    public CategoryDTO update(CategoryDTO categoryDTO) {
        if (!repository.existsByName(categoryDTO.getName()))
            throw new ResourceNotFoundException("CategoryModel", "name", categoryDTO.getName());
        return save(categoryDTO);
    }

    @Override
    public CategoryDTO delete(String name) {
        final CategoryEntity category = repository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("CategoryModel", "name", name));
        repository.delete(category);
        return mapper.convertValue(category, CategoryDTO.class);
    }

    @Override
    public CategoryDTO retrieveByName(String name) {
        final CategoryEntity categoryEntity = repository.findByName(name).orElseThrow(
                () -> new ResourceNotFoundException("CategoryModel", "name", name)
        );
        return mapper.convertValue(categoryEntity, CategoryDTO.class);
    }

    @Override
    public CategoryPaginationResponseDTO retrieveAll(Integer page, Integer size, String sortBy, String sortDir) {

        final Sort sortByAndOrder = sortDir.equalsIgnoreCase("asc" ) ?
                Sort.by(sortBy).ascending() :
                Sort.by(sortBy).descending();

        final Pageable pageable = PageRequest.of(page, size, sortByAndOrder);
        final Page<CategoryEntity> categoryEntities = repository.findAll(pageable);

        return CategoryPaginationResponseDTO.builder()
                .contentSet(categoryEntities.getContent().stream().map(
                        categoryEntity -> mapper.convertValue(categoryEntity, CategoryDTO.class)
                ).collect(Collectors.toUnmodifiableSet()))
                .page(page)
                .sortDir(sortDir)
                .sortBy(sortBy)
                .size(size)
                .isLast(categoryEntities.isLast())
                .build();
    }
}
