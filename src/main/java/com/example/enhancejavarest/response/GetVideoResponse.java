package com.example.enhancejavarest.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetVideoResponse {
    private Integer videoId;
    private Integer brandId;
    private Integer campaignId;
    private String name;
    private Double maxValue;
    private Integer estimatedViews;
    private Integer currentViews;
    private Integer coinBalanceRemaining;
    private String videoUrl;
}
