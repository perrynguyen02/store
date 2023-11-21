package com.perry.service;

import com.perry.model.dto.CategoryDto;
import com.perry.model.entity.Category;
import com.perry.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryService implements GeneralService<Category, CategoryDto> {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(UUID uuid) {
        return categoryRepository.findById(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public Category create(CategoryDto categoryDto) {
        return categoryRepository.save(mapToEntity(categoryDto, Category.class));
    }

    @Override
    public Category update(UUID uuid, CategoryDto categoryDto) {
        Category category = findById(uuid);
        category = mapToEntity(categoryDto, Category.class);
        category.setUuid(uuid);
        return categoryRepository.save(category);
    }

    @Override
    public void delete(UUID uuid) {
        categoryRepository.delete(findById(uuid));
    }
}
