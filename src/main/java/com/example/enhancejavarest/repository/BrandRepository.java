package com.example.enhancejavarest.repository;

import com.example.enhancejavarest.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
    public Brand findByEmail(String email);
    public Brand findByBrandName(String name);
}
