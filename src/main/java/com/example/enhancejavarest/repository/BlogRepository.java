package com.example.enhancejavarest.repository;

import com.example.enhancejavarest.entity.Blog;
import com.example.enhancejavarest.response.GetBlogsResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = "select c.blog_id, c.brand_id, c.campaign_id, c.\"name\", c.max_value, c.estimated_views, c.current_views, " +
            "c.coin_balance_remaining, b.blog_body " +
            "from blog b join campaign c on c.blog_id = b.id where c.brand_id = ?1", nativeQuery = true)
    public List<Map<String, Object>> getBlogsByBrandId(Integer brandId);
}
