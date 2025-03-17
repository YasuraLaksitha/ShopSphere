package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.CategoryDTO;
import org.example.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class Controller {

    private final CategoryService service;

    @PostMapping("/public/save")
    public CategoryDTO save(@RequestBody CategoryDTO categoryDTO){
        return service.save(categoryDTO);
    }

    @GetMapping("/public/get/{name}")
    public CategoryDTO get(@PathVariable  String name){
        return service.retrieveByName(name);
    }

    @GetMapping("/public/get")
    public Set<CategoryDTO> getAll(){
        return service.retrieveAll();
    }
}
