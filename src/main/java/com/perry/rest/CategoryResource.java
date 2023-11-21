package com.perry.rest;

import com.perry.model.dto.CategoryDto;
import com.perry.model.entity.Category;
import com.perry.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/category")
public class CategoryResource implements GeneralRest<Category, CategoryDto> {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    @Override
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    @Override
    public Category findById(@PathVariable("id") UUID uuid) {
        return categoryService.findById(uuid);
    }

    @PostMapping("/create")
    @Override
    public Category create(@RequestBody CategoryDto categoryDto) {
        return categoryService.create(categoryDto);
    }

    @PutMapping("/update/{id}")
    @Override
    public Category update(@PathVariable("id") UUID uuid, @RequestBody CategoryDto categoryDto) {
        return categoryService.update(uuid, categoryDto);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public void delete(@PathVariable("id") UUID uuid) {
        categoryService.delete(uuid);
    }
}
