package com.example.enhancejavarest.repository;

import com.example.enhancejavarest.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Integer> {
}
