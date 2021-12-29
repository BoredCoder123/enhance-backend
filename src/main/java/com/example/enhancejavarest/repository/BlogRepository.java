package com.example.enhancejavarest.repository;

import com.example.enhancejavarest.entity.Blog;
import com.example.enhancejavarest.response.GetBlogsResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = "select blog_id")
    public GetBlogsResponse getBlogsByBrandId(Integer brandId);
}
