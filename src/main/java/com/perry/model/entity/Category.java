package com.perry.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_parent_uuid")
    private Category categoryParent;

}
