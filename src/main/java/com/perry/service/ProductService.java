package com.perry.service;

import com.perry.model.dto.ProductDto;
import com.perry.model.entity.Product;
import com.perry.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
@Service
public class ProductService implements GeneralService<Product, ProductDto> {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(UUID uuid) {
        return productRepository.findById(uuid).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public Product create(ProductDto productDto) {
        return productRepository.save(mapToEntity(productDto, Product.class));
    }

    @Override
    public Product update(UUID uuid, ProductDto productDto) {
        findById(uuid);
        Product product = mapToEntity(productDto, Product.class);
        product.setUuid(uuid);
        return productRepository.save(product);
    }

    @Override
    public void delete(UUID uuid) {
        productRepository.delete(findById(uuid));
    }
}
