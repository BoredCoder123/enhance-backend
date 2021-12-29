package com.example.enhancejavarest.repository;

import com.example.enhancejavarest.entity.Deal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DealRepository extends JpaRepository<Deal, Integer> {
}
