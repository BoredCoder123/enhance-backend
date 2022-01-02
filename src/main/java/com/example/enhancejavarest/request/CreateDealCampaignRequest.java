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
public class CreateDealCampaignRequest {
    private Integer estimatedClicks;
    private Integer estimatedViews;
    private Double maxValue;
    private String name;
    private CampaignType type;
    private String couponCode;
    private Double discountedValue;
    private String imageUrl;
    private Double originalValue;
}
