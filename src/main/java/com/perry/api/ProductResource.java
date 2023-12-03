package com.perry.api;

import com.perry.model.dto.ProductDto;
import com.perry.model.entity.Product;
import com.perry.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/create")
    @Override
    public Product create(@RequestBody ProductDto productDto) {
        return productService.create(productDto);
    }

    @PutMapping("/update/{uuid}")
    @Override
    public Product update(@PathVariable("uuid") UUID uuid, @RequestBody ProductDto productDto) {
        return productService.update(uuid, productDto);
    }

    @DeleteMapping("/delete/{uuid}")
    @Override
    public void delete(@PathVariable("uuid") UUID uuid) {
        productService.delete(uuid);
    }
}
