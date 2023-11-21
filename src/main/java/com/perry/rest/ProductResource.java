package com.perry.rest;

import com.perry.model.dto.ProductDto;
import com.perry.model.entity.Product;

import java.util.List;
import java.util.UUID;

public class ProductResource implements GeneralRest<Product, ProductDto> {
    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public Product findById(UUID uuid) {
        return null;
    }

    @Override
    public Product create(ProductDto productDto) {
        return null;
    }

    @Override
    public Product update(UUID uuid, ProductDto productDto) {
        return null;
    }

    @Override
    public void delete(UUID uuid) {

    }
}
