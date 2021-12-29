package com.example.enhancejavarest.entity;

import com.example.enhancejavarest.Constants.CampaignType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "campaign")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Campaign {
    @Id
    @GeneratedValue
    @Column(name = "campaign_id")
    private Integer campaignId;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private CampaignType type;

    @Column(name = "max_value")
    private Double maxValue;

    @ManyToOne
    @JoinColumn(name="brand_id")
    private Brand brand;

    @Column(name = "estimated_views")
    private Integer estimatedViews;

    @Column(name = "estimated_clicks")
    private Integer estimatedClicks;

    @Column(name = "current_views")
    private Integer currentViews;

    @Column(name = "current_clicks")
    private Integer currentClicks;

    @Column(name = "coin_balance_remaining")
    private Integer coinBalanceRemaining;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name= "video_id")
    private Video video;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name= "blog_id")
    private Blog blog;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name= "deal_id")
    private Deal deal;
}
