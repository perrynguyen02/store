package com.perry.api;

import com.perry.model.dto.ProductDto;
import com.perry.model.entity.Product;
import com.perry.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/product")
public class ProductResource implements GeneralRest<Product, ProductDto> {
    @Autowired
    private ProductService productService;

    @GetMapping
    @Override
    public List<Product> findAll() {
        return productService.findAll();
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
