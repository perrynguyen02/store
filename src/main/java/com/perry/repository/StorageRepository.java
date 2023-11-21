package com.perry.repository;


import com.perry.model.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface StorageRepository extends JpaRepository<Image, UUID> {
    Optional<Image> findByName(String filename);
}