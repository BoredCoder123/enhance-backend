package com.example.enhancejavarest.repository;

import com.example.enhancejavarest.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
}
