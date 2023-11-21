package com.perry.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private String name;
    private String description;
    private String image;
    private Long price;
    private Long quantity;
    private String unit;

    @ManyToOne
    @JoinColumn(name = "category_uuid")
    private Category category;
}
