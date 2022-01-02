package com.example.enhancejavarest.repository;

import com.example.enhancejavarest.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface VideoRepository extends JpaRepository<Video, Integer> {
    @Query(value = "select c.video_id , c.brand_id, c.campaign_id, c.\"name\", c.max_value, c.estimated_views, c.current_views, " +
            "c.coin_balance_remaining, v.video_url " +
            "from video v join campaign c on c.video_id = v.video_id where c.brand_id = ?1", nativeQuery = true)
    public List<Map<String, Object>> getVideoByBrandId(Integer brandId);
}
