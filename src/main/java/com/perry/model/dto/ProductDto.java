package com.perry.model.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ProductDto {
    private UUID uuid;
    private String name;
    private String description;
    private String image;
    private Long price;
    private Long quantity;
    private String unit;

    private CategoryDto category;
}
