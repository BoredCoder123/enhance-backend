package com.example.enhancejavarest.request;

import com.example.enhancejavarest.Constants.CampaignType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateVideoCampaignRequest {
    private String name;
    private CampaignType type;
    private Double maxValue;
    private Integer brandId;
    private Integer estimatedViews;
    private String videoUrl;
}
