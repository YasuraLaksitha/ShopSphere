package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.config.ApplicationDefaultConstants;
import org.example.dto.CategoryDTO;
import org.example.dto.CategoryPaginationResponseDTO;
import org.example.service.CategoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/category" )
@RequiredArgsConstructor
public class Controller {

    private final CategoryService service;

    @PostMapping("/public/save" )
    public CategoryDTO save(@RequestBody CategoryDTO categoryDTO) {
        return service.save(categoryDTO);
    }

    @GetMapping("/public/get/{name}" )
    public CategoryDTO get(@PathVariable String name) {
        return service.retrieveByName(name);
    }

    @PutMapping("/public" )
    public CategoryDTO replace(@RequestBody CategoryDTO categoryDTO) {
        return service.update(categoryDTO);
    }

    @GetMapping("/public/categories" )
    public CategoryPaginationResponseDTO getAll
            (
                    @RequestParam(defaultValue = ApplicationDefaultConstants.PAGE_NUMBER, required = false)
                    Integer page,
                    @RequestParam(defaultValue = ApplicationDefaultConstants.PAGE_SIZE, required = false)
                    Integer size,
                    @RequestParam(defaultValue = ApplicationDefaultConstants.SORT_CATEGORY_BY, required = false)
                    String  sortBy,
                    @RequestParam(defaultValue = ApplicationDefaultConstants.SORT_DIR, required = false)
                    String sortDir
            ) {
        return service.retrieveAll(page, size,sortBy ,sortDir );
    }
}
