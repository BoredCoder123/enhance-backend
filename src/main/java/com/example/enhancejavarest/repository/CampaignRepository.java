package com.example.enhancejavarest.repository;

import com.example.enhancejavarest.entity.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignRepository extends JpaRepository<Campaign, Integer> {
}
