package com.example.enhancejavarest.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "deal")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Deal {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer dealId;

    @Column(name="image_url")
    private String imageUrl;

    @Column(name = "original_value")
    private Double originalValue;

    @Column(name = "discounted_value")
    private Double discountedValue;

    @Column(name = "coupon_code")
    private String couponCode;

//    @OneToOne(mappedBy = "campaign", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Campaign campaign;
}
